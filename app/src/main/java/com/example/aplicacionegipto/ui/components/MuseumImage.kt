package com.example.aplicacionegipto.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.aplicacionegipto.ui.theme.*

@Composable
fun MuseumAsyncImage(
    imageUrl: String,
    description: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = description,
        contentScale = contentScale,
        modifier = modifier.semantics { contentDescription = description },
        loading = {
            Box(
                modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(GoldDark.copy(alpha = 0.2f), LapisLazuli.copy(alpha = 0.15f)))),
                contentAlignment = Alignment.Center
            ) { CircularProgressIndicator(color = GoldPharaoh, strokeWidth = 2.dp, modifier = Modifier.size(24.dp)) }
        },
        error = {
            Box(
                modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(GoldDark.copy(alpha = 0.3f), LapisLazuli.copy(alpha = 0.2f)))),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "𓂀", fontSize = 28.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Imagen no disponible", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                }
            }
        }
    )
}
