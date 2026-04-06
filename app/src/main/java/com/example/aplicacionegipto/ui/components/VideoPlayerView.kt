package com.example.aplicacionegipto.ui.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.ui.PlayerView

/**
 * VideoPlayerView con ExoPlayer.
 * FIX: Usar Uri.parse() en vez de Uri.Builder().encodedPath()
 *      que corrompía la URL completa del stream HLS.
 * FIX: Crear ExoPlayer local en vez del singleton para evitar
 *      conflictos cuando se navega entre pantallas.
 * FIX: Agregar User-Agent al DataSource para evitar 403.
 */
@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun VideoPlayerView(
    videoUrl: String,
    description: String = "Reproductor de video",
    modifier: Modifier = Modifier,
    onFullScreenToggle: ((Boolean) -> Unit)? = null
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // Crear ExoPlayer local para esta pantalla
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
    }

    // Preparar la fuente de medios HLS
    // FIX: Uri.parse() directamente, NO Uri.Builder().encodedPath()
    LaunchedEffect(videoUrl) {
        val dataSourceFactory = DefaultHttpDataSource.Factory()
            .setUserAgent("MuseoEgiptoApp/1.0")
        val uri = Uri.parse(videoUrl)  // FIX: parse directo
        val mediaItem = MediaItem.Builder().setUri(uri).build()
        val hlsSource = HlsMediaSource.Factory(dataSourceFactory)
            .createMediaSource(mediaItem)

        exoPlayer.setMediaSource(hlsSource)
        exoPlayer.prepare()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .background(Color.Black)
            .semantics { contentDescription = description }
    ) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
                    exoPlayer.playWhenReady = false
                    if (onFullScreenToggle != null) {
                        setFullscreenButtonClickListener { isFullScreen ->
                            onFullScreenToggle(isFullScreen)
                        }
                    }
                }
            }
        )
    }

    // Manejar ciclo de vida
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> exoPlayer.pause()
                Lifecycle.Event.ON_RESUME -> { /* no auto-play */ }
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    // Liberar ExoPlayer al salir
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }
}
