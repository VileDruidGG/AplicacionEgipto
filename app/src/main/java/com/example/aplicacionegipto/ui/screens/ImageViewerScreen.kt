package com.example.aplicacionegipto.ui.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
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
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastAny
import androidx.compose.ui.util.fastForEach
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.ui.components.MuseumAsyncImage
import com.example.aplicacionegipto.ui.theme.*
import java.util.Locale
import kotlin.math.abs

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
    var zoomActive by remember { mutableStateOf(false) }

    // TTS
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    DisposableEffect(Unit) {
        val t = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) tts?.language = Locale("es", "MX")
        }
        tts = t
        onDispose { t.stop(); t.shutdown() }
    }

    LaunchedEffect(pagerState.currentPage, audioDescEnabled) {
        if (audioDescEnabled) {
            val desc = descriptions.getOrElse(pagerState.currentPage) { "" }
            if (desc.isNotEmpty()) { tts?.stop(); tts?.speak(desc, TextToSpeech.QUEUE_FLUSH, null, "img_auto") }
        }
    }

    fun speakCurrent() {
        val desc = descriptions.getOrElse(pagerState.currentPage) { "" }
        if (desc.isNotEmpty()) { tts?.stop(); tts?.speak(desc, TextToSpeech.QUEUE_FLUSH, null, "img_manual") }
    }

    Box(
        Modifier.fillMaxSize().background(Color.Black)
            .semantics { contentDescription = "Visor de imagenes. ${pagerState.currentPage + 1} de $pageCount." }
    ) {
        // FIX SWIPE: userScrollEnabled=true cuando no hay zoom activo
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = !zoomActive
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
            Row(
                Modifier.fillMaxWidth().statusBarsPadding().padding(16.dp).align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack, modifier = Modifier.background(Color.Black.copy(0.5f), CircleShape).semantics { contentDescription = "Cerrar visor" }) {
                    Icon(Icons.Default.Close, null, tint = Color.White)
                }
                IconButton(onClick = { speakCurrent() }, modifier = Modifier.background(Color.Black.copy(0.5f), CircleShape).semantics { contentDescription = "Leer descripcion en voz alta" }) {
                    Icon(Icons.Default.VolumeUp, null, tint = GoldPharaoh)
                }
            }

            Column(
                Modifier.fillMaxWidth().align(Alignment.BottomCenter)
                    .background(Color.Black.copy(0.6f)).navigationBarsPadding().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(descriptions.getOrElse(pagerState.currentPage) { "" }, style = MaterialTheme.typography.bodyMedium, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.semantics { liveRegion = LiveRegionMode.Polite })
                Spacer(Modifier.height(8.dp))
                Text("${pagerState.currentPage + 1} / $pageCount", style = MaterialTheme.typography.labelMedium, color = GoldPharaoh)
                Spacer(Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    repeat(pageCount) { i -> Box(Modifier.size(if (i == pagerState.currentPage) 8.dp else 5.dp).background(if (i == pagerState.currentPage) GoldPharaoh else Color.White.copy(0.4f), CircleShape)) }
                }
                Spacer(Modifier.height(4.dp))
                Text("Pellizca para zoom  •  Desliza para navegar", style = MaterialTheme.typography.labelSmall, color = Color.White.copy(0.5f))
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            // Tap y double-tap: solo consumen click, nunca bloquean swipe
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onTap() },
                    onDoubleTap = {
                        if (scale > 1.5f) {
                            scale = 1f; offset = Offset.Zero; onZoomChanged(false)
                        } else {
                            scale = 2.5f; onZoomChanged(true)
                        }
                    }
                )
            }
            // FIX SWIPE: gesture manual con awaitEachGesture.
            // Solo actua con 2+ dedos (pinch) o cuando ya hay zoom activo (pan).
            // Con 1 dedo y sin zoom, NO consume los eventos -> HorizontalPager recibe el swipe.
            .pointerInput(scale) {
                awaitEachGesture {
                    // Esperar primer dedo
                    val down = awaitFirstDown(requireUnconsumed = false)
                    var zoom = 1f
                    var pan = Offset.Zero
                    var pastTouchSlop = false
                    val touchSlop = viewConfiguration.touchSlop

                    do {
                        val event = awaitPointerEvent()
                        val canceled = event.changes.fastAny { it.isConsumed }
                        if (canceled) break

                        val pointerCount = event.changes.count { it.pressed }

                        if (pointerCount >= 2) {
                            // Hay 2+ dedos: calcular pinch
                            val zoomChange = event.calculateZoom()
                            val panChange = event.calculatePan()
                            if (!pastTouchSlop) {
                                zoom *= zoomChange
                                pan += panChange
                                val centroidSize = event.calculateCentroidSize(useCurrent = false)
                                val zoomMotion = abs(1 - zoom) * centroidSize
                                val panMotion = pan.getDistance()
                                if (zoomMotion > touchSlop || panMotion > touchSlop) pastTouchSlop = true
                            }
                            if (pastTouchSlop) {
                                val newScale = (scale * zoomChange).coerceIn(1f, 5f)
                                scale = newScale
                                if (newScale > 1f) {
                                    offset = Offset(offset.x + panChange.x, offset.y + panChange.y)
                                    onZoomChanged(true)
                                } else {
                                    offset = Offset.Zero; onZoomChanged(false)
                                }
                                event.changes.fastForEach { if (it.positionChanged()) it.consume() }
                            }
                        } else if (pointerCount == 1 && scale > 1f) {
                            // 1 dedo con zoom activo: pan
                            val panChange = event.calculatePan()
                            offset = Offset(offset.x + panChange.x, offset.y + panChange.y)
                            event.changes.fastForEach { if (it.positionChanged()) it.consume() }
                        }
                        // 1 dedo sin zoom: NO consume -> HorizontalPager puede hacer swipe
                    } while (event.changes.fastAny { it.pressed })
                }
            }
            .semantics { contentDescription = description },
        contentAlignment = Alignment.Center
    ) {
        if (imageUrl.isNotEmpty()) {
            MuseumAsyncImage(
                imageUrl = imageUrl,
                description = description,
                modifier = Modifier.fillMaxSize().graphicsLayer {
                    scaleX = scale; scaleY = scale
                    translationX = offset.x; translationY = offset.y
                },
                contentScale = ContentScale.Fit
            )
        } else {
            Text("Imagen ${pageIndex + 1}", style = MaterialTheme.typography.titleLarge, color = Color.White.copy(0.7f),
                modifier = Modifier.graphicsLayer { scaleX = scale; scaleY = scale; translationX = offset.x; translationY = offset.y })
        }
        if (scale > 1f) {
            Text("Zoom: ${"%.1f".format(scale)}x", style = MaterialTheme.typography.labelSmall, color = GoldPharaoh.copy(0.8f),
                modifier = Modifier.align(Alignment.TopStart).padding(8.dp))
        }
    }
}
