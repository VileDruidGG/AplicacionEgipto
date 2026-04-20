package com.example.aplicacionegipto.ui.components

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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

/**
 * Composable que reproduce videos de YouTube usando AndroidView.
 * Usa la libreria pierfrancescosoffritti/android-youtube-player.
 *
 * @param youtubeId El ID del video de YouTube (ej: "dQw4w9WgXcQ")
 * @param description Descripcion para accesibilidad
 */
@Composable
fun YouTubePlayerComposable(
    youtubeId: String,
    description: String = "Reproductor de video de YouTube",
    modifier: Modifier = Modifier
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    var playerRef by remember { mutableStateOf<YouTubePlayer?>(null) }
    var currentVideoId by remember { mutableStateOf(youtubeId) }

    // Si cambia el youtubeId, cargar el nuevo video
    LaunchedEffect(youtubeId) {
        currentVideoId = youtubeId
        playerRef?.cueVideo(youtubeId, 0f)
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
                YouTubePlayerView(ctx).apply {
                    // Vincular al lifecycle para auto-pause/resume
                    lifecycleOwner.lifecycle.addObserver(this)

                    addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            playerRef = youTubePlayer
                            youTubePlayer.cueVideo(currentVideoId, 0f)
                        }
                    })
                }
            },
            update = { view ->
                // No necesitamos actualizar nada aqui,
                // el LaunchedEffect maneja cambios de youtubeId
            }
        )
    }

    // Limpiar al salir
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> playerRef?.pause()
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
