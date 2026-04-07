package com.example.aplicacionegipto.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.aplicacionegipto.ui.theme.*
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * ImageLoader singleton para toda la app.
 * Configurado con OkHttp que sigue redirects del Met IIIF API.
 */
private var _imageLoader: ImageLoader? = null

private fun getImageLoader(context: android.content.Context): ImageLoader {
    if (_imageLoader == null) {
        val client = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val req = chain.request().newBuilder()
                    .header("User-Agent", "MuseoEgiptoApp/1.0 (Android; educational)")
                    .header("Accept", "image/*,*/*")
                    .build()
                chain.proceed(req)
            }
            .build()

        _imageLoader = ImageLoader.Builder(context.applicationContext)
            .okHttpClient(client)
            .crossfade(true)
            .respectCacheHeaders(false)
            .build()
    }
    return _imageLoader!!
}

@Composable
fun MuseumAsyncImage(
    imageUrl: String,
    description: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    val context = LocalContext.current
    val loader = remember { getImageLoader(context) }

    SubcomposeAsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .allowHardware(false)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .listener(
                onError = { _, result ->
                    Log.e("MuseumImg", "FAIL: $imageUrl | ${result.throwable.message}")
                },
                onSuccess = { _, _ ->
                    Log.d("MuseumImg", "OK: $imageUrl")
                }
            )
            .build(),
        imageLoader = loader,
        contentDescription = description,
        contentScale = contentScale,
        modifier = modifier.semantics { contentDescription = description },
        loading = {
            Box(
                Modifier.fillMaxSize().background(
                    Brush.verticalGradient(listOf(GoldDark.copy(alpha = 0.2f), LapisLazuli.copy(alpha = 0.15f)))
                ),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = GoldPharaoh, strokeWidth = 2.dp, modifier = Modifier.size(24.dp))
            }
        },
        error = {
            Box(
                Modifier.fillMaxSize().background(
                    Brush.verticalGradient(listOf(GoldDark.copy(alpha = 0.3f), LapisLazuli.copy(alpha = 0.2f)))
                ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "E", fontSize = 28.sp)
                    Spacer(Modifier.height(4.dp))
                    Text("Imagen no disponible", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                }
            }
        }
    )
}
