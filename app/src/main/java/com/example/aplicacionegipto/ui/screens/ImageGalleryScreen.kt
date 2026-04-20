package com.example.aplicacionegipto.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.ui.components.MuseumAsyncImage
import com.example.aplicacionegipto.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageGalleryScreen(sectionId: String, onImageClick: (Int) -> Unit, onBack: () -> Unit) {
    val sectionTitle = when (sectionId) {
        "vida_cotidiana" -> "Vida Cotidiana"
        "arquitectura"   -> "Arquitectura"
        "arte"           -> "Arte"
        else             -> "Galeria"
    }
    val images    = MuseumRepository.getImages(sectionId)
    val imageUrls = MuseumRepository.getImageUrls(sectionId)

    // Color de fondo tematico por seccion (visible mientras carga la imagen)
    val bgColor = when (sectionId) {
        "vida_cotidiana" -> OcreEgypt
        "arquitectura"   -> LapisLazuli
        "arte"           -> RedDesert
        else             -> GoldDark
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Galeria - $sectionTitle", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)) },
            navigationIcon = {
                IconButton(onClick = onBack, modifier = Modifier.semantics { contentDescription = "Regresar" }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
        )
    }) { pv ->
        Column(Modifier.fillMaxSize().padding(pv)) {
            Text(
                "Toca una imagen para verla en detalle.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    .semantics { contentDescription = "Galeria de ${images.size} imagenes." }
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(images.size) { index ->
                    val desc = images.getOrNull(index)?.contentDescription ?: "Imagen ${index + 1}"
                    val url  = imageUrls.getOrNull(index) ?: ""
                    val shape = RoundedCornerShape(8.dp)

                    // FIX GRIS REAL: eliminar Card (que impone su propio containerColor gris)
                    // y reemplazar por Box con clip + elevation via shadow.
                    // El fondo bgColor es siempre visible debajo de la imagen.
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(shape)
                            .background(bgColor.copy(alpha = 0.55f))  // fondo siempre visible
                            .clickable(
                                onClick = { onImageClick(index) },
                                onClickLabel = "Ver imagen ${index + 1}"
                            )
                            .semantics { contentDescription = "Imagen ${index + 1}: $desc. Toca para ampliar." },
                        contentAlignment = Alignment.Center
                    ) {
                        if (url.isNotEmpty()) {
                            MuseumAsyncImage(
                                imageUrl = url,
                                description = desc,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Text("${index + 1}", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
