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
 * Soporta HLS (.m3u8) y MP4 directo (Pixabay CDN).
 * Fuerza MimeTypes.VIDEO_MP4 para evitar que content-type
 * "binary/octet-stream" confunda a ExoPlayer.
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
            .setUserAgent("MuseoEgiptoApp/1.0 (Android)")
            .setAllowCrossProtocolRedirects(true)

        val uri = Uri.parse(videoUrl)

        val mediaSource = if (videoUrl.contains(".m3u8")) {
            // Stream HLS
            val mediaItem = MediaItem.Builder()
                .setUri(uri)
                .setMimeType(MimeTypes.APPLICATION_M3U8)
                .build()
            HlsMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
        } else {
            // MP4 directo — forzar MIME type para evitar problemas con
            // servidores que devuelven binary/octet-stream
            val mediaItem = MediaItem.Builder()
                .setUri(uri)
                .setMimeType(MimeTypes.VIDEO_MP4)
                .build()
            ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
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
                Lifecycle.Event.ON_PAUSE -> exoPlayer.pause()
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
