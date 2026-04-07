package com.example.aplicacionegipto.ui.components

import android.util.Log
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
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.aplicacionegipto.ui.theme.*
import okhttp3.OkHttpClient
import coil.ImageLoader

/**
 * Componente de imagen con Coil + OkHttp configurado.
 *
 * El Met IIIF API hace redirects (302) a la imagen final.
 * Coil por defecto usa OkHttp que sigue redirects, pero
 * necesitamos:
 * 1. User-Agent valido (sin el, algunos CDN rechazan)
 * 2. followRedirects = true (para IIIF -> imagen final)
 * 3. memoryCachePolicy ENABLED (cache agresivo)
 * 4. diskCachePolicy ENABLED (no re-descargar)
 * 5. networkCachePolicy ENABLED
 */
@Composable
fun MuseumAsyncImage(
    imageUrl: String,
    description: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    val context = LocalContext.current

    // OkHttpClient con User-Agent y redirects
    val okHttpClient = OkHttpClient.Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header("User-Agent", "MuseoEgiptoApp/1.0 (Android; educational)")
                .header("Accept", "image/*")
                .build()
            chain.proceed(request)
        }
        .build()

    // ImageLoader personalizado con OkHttp
    val imageLoader = ImageLoader.Builder(context)
        .okHttpClient(okHttpClient)
        .crossfade(true)
        .build()

    SubcomposeAsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .allowHardware(false)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .listener(
                onError = { _, result ->
                    Log.e("MuseumImage", "Error cargando: $imageUrl -> ${result.throwable.message}")
                },
                onSuccess = { _, _ ->
                    Log.d("MuseumImage", "OK: $imageUrl")
                }
            )
            .build(),
        imageLoader = imageLoader,
        contentDescription = description,
        contentScale = contentScale,
        modifier = modifier.semantics { contentDescription = description },
        loading = {
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(listOf(GoldDark.copy(alpha = 0.2f), LapisLazuli.copy(alpha = 0.15f)))
                ),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = GoldPharaoh, strokeWidth = 2.dp, modifier = Modifier.size(24.dp))
            }
        },
        error = {
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(listOf(GoldDark.copy(alpha = 0.3f), LapisLazuli.copy(alpha = 0.2f)))
                ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "E", fontSize = 28.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Imagen no disponible",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            }
        }
    )
}
