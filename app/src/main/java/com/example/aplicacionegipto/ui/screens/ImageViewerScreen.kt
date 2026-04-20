package com.example.aplicacionegipto.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import android.speech.tts.TextToSpeech
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.ui.components.MuseumAsyncImage
import com.example.aplicacionegipto.ui.theme.*
import java.util.Locale

@Composable
fun ImageViewerScreen(
    sectionId: String,
    initialIndex: Int,
    audioDescEnabled: Boolean = false,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val descriptions = MuseumRepository.getImages(sectionId).map { it.contentDescription }
    val imageUrls = MuseumRepository.getImageUrls(sectionId)
    val pageCount = descriptions.size
    val pagerState = rememberPagerState(
        initialPage = initialIndex.coerceIn(0, pageCount - 1),
        pageCount = { pageCount }
    )
    var showControls by remember { mutableStateOf(true) }

    // === TTS ===
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    DisposableEffect(Unit) {
        val t = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale("es", "MX")
            }
        }
        tts = t
        onDispose { t.stop(); t.shutdown() }
    }

    // Leer descripcion automaticamente al cambiar de pagina si audioDesc esta activo
    LaunchedEffect(pagerState.currentPage, audioDescEnabled) {
        if (audioDescEnabled) {
            val desc = descriptions.getOrElse(pagerState.currentPage) { "" }
            if (desc.isNotEmpty()) {
                tts?.stop()
                tts?.speak(desc, TextToSpeech.QUEUE_FLUSH, null, "img_desc")
            }
        }
    }

    fun speakCurrent() {
        val desc = descriptions.getOrElse(pagerState.currentPage) { "" }
        if (desc.isNotEmpty()) {
            tts?.stop()
            tts?.speak(desc, TextToSpeech.QUEUE_FLUSH, null, "img_desc_manual")
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .semantics {
                contentDescription = "Visor de imagenes. Imagen ${pagerState.currentPage + 1} de $pageCount. Desliza para cambiar. Pellizca para zoom."
            }
    ) {
        // FIX SWIPE: userScrollEnabled=true siempre en el pager exterior.
        // El zoom se maneja DENTRO de cada pagina y solo bloquea el pager
        // cuando scale > 1f, via la flag zoomActive que se sube con callback.
        var zoomActive by remember { mutableStateOf(false) }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = !zoomActive   // bloquea swipe solo cuando hay zoom
        ) { page ->
            ZoomableImage(
                pageIndex = page,
                description = descriptions.getOrElse(page) { "Imagen" },
                imageUrl = imageUrls.getOrElse(page) { "" },
                onTap = { showControls = !showControls },
                onZoomChanged = { active -> zoomActive = active }
            )
        }

        if (showControls) {
            // Barra superior
            Row(
                Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(16.dp)
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .background(Color.Black.copy(alpha = 0.5f), CircleShape)
                        .semantics { contentDescription = "Cerrar visor" }
                ) { Icon(Icons.Default.Close, null, tint = Color.White) }

                IconButton(
                    onClick = { speakCurrent() },
                    modifier = Modifier
                        .background(Color.Black.copy(alpha = 0.5f), CircleShape)
                        .semantics {
                            contentDescription = "Leer descripcion en voz alta: ${descriptions.getOrElse(pagerState.currentPage) { "" }}"
                        }
                ) { Icon(Icons.Default.VolumeUp, null, tint = GoldPharaoh) }
            }

            // Barra inferior
            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Black.copy(alpha = 0.6f))
                    .navigationBarsPadding()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    descriptions.getOrElse(pagerState.currentPage) { "" },
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.semantics { liveRegion = LiveRegionMode.Polite }
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "${pagerState.currentPage + 1} / $pageCount",
                    style = MaterialTheme.typography.labelMedium,
                    color = GoldPharaoh
                )
                Spacer(Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    repeat(pageCount) { i ->
                        Box(
                            Modifier
                                .size(if (i == pagerState.currentPage) 8.dp else 5.dp)
                                .background(
                                    if (i == pagerState.currentPage) GoldPharaoh
                                    else Color.White.copy(alpha = 0.4f),
                                    CircleShape
                                )
                        )
                    }
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    "Pellizca para zoom  •  Desliza para navegar",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White.copy(alpha = 0.5f)
                )
            }
        }
    }
}

@Composable
private fun ZoomableImage(
    pageIndex: Int,
    description: String,
    imageUrl: String,
    onTap: () -> Unit,
    onZoomChanged: (Boolean) -> Unit
) {
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    // FIX SWIPE: graphicsLayer aplicado SOLO a la imagen, NO al Box de gestos.
    // Esto evita que el pager externo confunda el pan con swipe.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onTap() },
                    onDoubleTap = {
                        if (scale > 1.5f) {
                            scale = 1f
                            offset = Offset.Zero
                            onZoomChanged(false)
                        } else {
                            scale = 2.5f
                            onZoomChanged(true)
                        }
                    }
                )
            }
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    val newScale = (scale * zoom).coerceIn(1f, 5f)
                    scale = newScale
                    if (newScale > 1f) {
                        offset = Offset(offset.x + pan.x, offset.y + pan.y)
                        onZoomChanged(true)
                    } else {
                        offset = Offset.Zero
                        onZoomChanged(false)
                    }
                }
            }
            .semantics { contentDescription = description },
        contentAlignment = Alignment.Center
    ) {
        // FIX SWIPE: graphicsLayer en la imagen, no en el contenedor de gestos
        if (imageUrl.isNotEmpty()) {
            MuseumAsyncImage(
                imageUrl = imageUrl,
                description = description,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        translationX = offset.x
                        translationY = offset.y
                    },
                contentScale = ContentScale.Fit
            )
        } else {
            Column(
                modifier = Modifier.graphicsLayer {
                    scaleX = scale; scaleY = scale
                    translationX = offset.x; translationY = offset.y
                },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Imagen ${pageIndex + 1}",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }
        if (scale > 1f) {
            Text(
                "Zoom: ${"%.1f".format(scale)}x",
                style = MaterialTheme.typography.labelSmall,
                color = GoldPharaoh.copy(alpha = 0.8f),
                modifier = Modifier.align(Alignment.TopStart).padding(8.dp)
            )
        }
    }
}
