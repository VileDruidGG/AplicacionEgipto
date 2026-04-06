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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.ui.PlayerView
import com.example.aplicacionegipto.data.ExoPlayerManager

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
    val exoPlayer = remember { ExoPlayerManager.getExoPlayer(context) }

    LaunchedEffect(videoUrl) {
        val dataSourceFactory = DefaultHttpDataSource.Factory()
        val uri = Uri.Builder().encodedPath(videoUrl).build()
        val mediaItem = MediaItem.Builder().setUri(uri).build()
        val internetVideoSource = HlsMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)
        exoPlayer.setMediaSource(internetVideoSource)
        exoPlayer.prepare()
    }

    Box(modifier = modifier.fillMaxWidth().aspectRatio(16f / 9f).background(Color.Black).semantics { contentDescription = description }) {
        AndroidView(modifier = Modifier.fillMaxSize(), factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
                exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
                exoPlayer.playWhenReady = false
                if (onFullScreenToggle != null) {
                    setFullscreenButtonClickListener { isFullScreen -> onFullScreenToggle(isFullScreen) }
                }
            }
        })
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> exoPlayer.playWhenReady = true
                Lifecycle.Event.ON_PAUSE -> exoPlayer.playWhenReady = false
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    DisposableEffect(Unit) { onDispose { ExoPlayerManager.releaseExoPlayer() } }
}

@Composable
fun AudioExoPlayer(
    audioResIds: List<Int>,
    packageName: String,
    onPlayerReady: (androidx.media3.exoplayer.ExoPlayer) -> Unit
) {
    val context = LocalContext.current
    val exoPlayer = remember { ExoPlayerManager.getExoPlayer(context) }
    LaunchedEffect(audioResIds) {
        exoPlayer.clearMediaItems()
        audioResIds.forEach { resId ->
            val path = "android.resource://$packageName/$resId"
            val mediaItem = MediaItem.fromUri(Uri.parse(path))
            exoPlayer.addMediaItem(mediaItem)
        }
        exoPlayer.prepare()
        onPlayerReady(exoPlayer)
    }
    DisposableEffect(Unit) { onDispose { ExoPlayerManager.releaseExoPlayer() } }
}
