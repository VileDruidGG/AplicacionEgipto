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
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView

/**
 * VideoPlayerView con ExoPlayer.
 * Soporta:
 *  - HLS (.m3u8)
 *  - WebM / OGV de Wikimedia Commons  <-- nuevo
 *  - MP4 directo
 *
 * Wikimedia Commons es la fuente de video verificada:
 * responde 206 con bytes reales en Range requests.
 * Pixabay bloquea hotlinking de video desde apps externas.
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

    val exoPlayer = remember { ExoPlayer.Builder(context).build() }

    LaunchedEffect(videoUrl) {
        val dataSourceFactory = DefaultHttpDataSource.Factory()
            .setUserAgent("Mozilla/5.0 (Android) MuseoEgipto/1.0")
            .setAllowCrossProtocolRedirects(true)

        val uri = Uri.parse(videoUrl)

        // Detectar MIME type por extension de URL
        val mediaSource = when {
            videoUrl.contains(".m3u8") -> {
                val item = MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_M3U8).build()
                HlsMediaSource.Factory(dataSourceFactory).createMediaSource(item)
            }
            videoUrl.contains(".webm") || videoUrl.contains(".ogv") || videoUrl.contains(".ogg") -> {
                // WebM y OGV: usar ProgressiveMediaSource sin forzar MIME
                // ExoPlayer detecta el codec (VP8/VP9/Theora) automaticamente
                ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(MediaItem.fromUri(uri))
            }
            else -> {
                // MP4: forzar MIME type por si el servidor devuelve octet-stream
                val item = MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.VIDEO_MP4).build()
                ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(item)
            }
        }

        exoPlayer.setMediaSource(mediaSource)
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

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE  -> exoPlayer.pause()
                Lifecycle.Event.ON_RESUME -> { }
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }
}
