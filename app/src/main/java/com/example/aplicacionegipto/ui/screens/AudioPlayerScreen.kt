package com.example.aplicacionegipto.ui.screens

import android.net.Uri
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.ui.theme.*
import kotlinx.coroutines.delay

@androidx.annotation.OptIn(UnstableApi::class)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioPlayerScreen(sectionId: String, onBack: () -> Unit) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val t = when(sectionId) { "vida_cotidiana"->"Vida Cotidiana"; "arquitectura"->"Arquitectura"; "arte"->"Arte"; else->"Audio" }
    val audios = MuseumRepository.getAudios(sectionId)

    var ci by remember { mutableIntStateOf(0) }
    var isPlaying by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0f) }
    var duration by remember { mutableLongStateOf(0L) }
    var currentMs by remember { mutableLongStateOf(0L) }

    // ExoPlayer para audio MP3
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            repeatMode = Player.REPEAT_MODE_OFF
            playWhenReady = false
        }
    }

    // Carga el audio cuando cambia la pista seleccionada
    fun loadTrack(index: Int) {
        val url = audios.getOrNull(index)?.audioUrl ?: return
        val dataSourceFactory = DefaultHttpDataSource.Factory()
            .setUserAgent("MuseoEgiptoApp/1.0")
        val source = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(Uri.parse(url)))
        exoPlayer.setMediaSource(source)
        exoPlayer.prepare()
        if (isPlaying) exoPlayer.play()
    }

    LaunchedEffect(ci) { loadTrack(ci) }

    // Actualizar progreso cada 500ms
    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            val dur = exoPlayer.duration.takeIf { it > 0 } ?: 1L
            val pos = exoPlayer.currentPosition
            duration = dur
            currentMs = pos
            progress = pos.toFloat() / dur.toFloat()
            if (!exoPlayer.isPlaying && exoPlayer.playbackState == Player.STATE_ENDED) {
                // Auto-siguiente
                if (ci < audios.size - 1) { ci++; progress = 0f } else { isPlaying = false; progress = 0f }
            }
            delay(500L)
        }
    }

    // Lifecycle
    DisposableEffect(lifecycleOwner) {
        val obs = LifecycleEventObserver { _, event ->
            when(event) {
                Lifecycle.Event.ON_PAUSE -> exoPlayer.pause()
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(obs)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(obs)
            exoPlayer.release()
        }
    }

    val inf = rememberInfiniteTransition(label = "vinyl")
    val rot by inf.animateFloat(0f, 360f, infiniteRepeatable(tween(3000, easing = LinearEasing), RepeatMode.Restart), label = "vr")

    fun fmt(ms: Long): String {
        val s = (ms / 1000).toInt()
        return "%d:%02d".format(s / 60, s % 60)
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Audio - $t", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)) },
            navigationIcon = { IconButton(onClick = { exoPlayer.stop(); onBack() }) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Regresar") } },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
        )
    }) { pv ->
        Column(Modifier.fillMaxSize().padding(pv)) {
            Card(Modifier.fillMaxWidth().padding(16.dp), shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))) {
                Column(Modifier.fillMaxWidth().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    // Disco giratorio
                    Box(Modifier.size(160.dp).clip(CircleShape)
                        .background(Brush.sweepGradient(listOf(KohlBlack, GoldDark.copy(0.3f), KohlBlack, GoldPharaoh.copy(0.2f), KohlBlack)))
                        .rotate(if (isPlaying) rot else 0f)
                        .semantics { contentDescription = if (isPlaying) "Disco girando" else "Disco detenido" },
                        contentAlignment = Alignment.Center) {
                        Box(Modifier.size(40.dp).clip(CircleShape).background(GoldPharaoh), contentAlignment = Alignment.Center) {
                            Text("E", fontSize = 16.sp, color = KohlBlack)
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    val cur = audios.getOrNull(ci)
                    Text(cur?.title ?: "Sin audio", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold), textAlign = TextAlign.Center)
                    Spacer(Modifier.height(4.dp))
                    Text(cur?.description ?: "", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(0.6f), textAlign = TextAlign.Center)
                    Spacer(Modifier.height(16.dp))
                    // Barra de progreso interactiva
                    Slider(
                        value = progress,
                        onValueChange = { v ->
                            progress = v
                            val seek = (v * (duration.takeIf { it > 0 } ?: 1L)).toLong()
                            exoPlayer.seekTo(seek)
                        },
                        modifier = Modifier.fillMaxWidth().semantics { contentDescription = "Barra de progreso. Desliza para adelantar." },
                        colors = SliderDefaults.colors(thumbColor = GoldPharaoh, activeTrackColor = GoldPharaoh, inactiveTrackColor = GoldPharaoh.copy(0.2f))
                    )
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(fmt(currentMs), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(0.5f))
                        Text(fmt(duration), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(0.5f))
                    }
                    Spacer(Modifier.height(16.dp))
                    // Controles
                    Row(horizontalArrangement = Arrangement.spacedBy(24.dp), verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (ci > 0) { ci--; progress = 0f } }, modifier = Modifier.semantics { contentDescription = "Audio anterior" }) {
                            Icon(Icons.Default.SkipPrevious, null, Modifier.size(32.dp))
                        }
                        IconButton(
                            onClick = {
                                isPlaying = !isPlaying
                                if (isPlaying) exoPlayer.play() else exoPlayer.pause()
                            },
                            modifier = Modifier.size(64.dp).background(GoldPharaoh, CircleShape)
                                .semantics { contentDescription = if (isPlaying) "Pausar" else "Reproducir" }
                        ) {
                            Icon(if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow, null, Modifier.size(36.dp), tint = KohlBlack)
                        }
                        IconButton(onClick = { if (ci < audios.size - 1) { ci++; progress = 0f } }, modifier = Modifier.semantics { contentDescription = "Siguiente audio" }) {
                            Icon(Icons.Default.SkipNext, null, Modifier.size(32.dp))
                        }
                    }
                }
            }

            Text("Lista de reproduccion", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), color = MaterialTheme.colorScheme.primary)

            LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                itemsIndexed(audios) { i, audio ->
                    val sel = i == ci; val playing = sel && isPlaying
                    Card(
                        Modifier.fillMaxWidth()
                            .clickable {
                                ci = i; progress = 0f
                                isPlaying = true
                                exoPlayer.play()
                            }
                            .semantics { contentDescription = "${audio.title}. ${audio.description}. ${if (playing) "Reproduciendose." else "Toca para reproducir."}" },
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = if (sel) MaterialTheme.colorScheme.primaryContainer.copy(0.3f) else MaterialTheme.colorScheme.surface)
                    ) {
                        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            val icon = when(audio.type) { AudioType.AMBIENT -> "🌿"; AudioType.NARRATION -> "🎙️"; AudioType.MUSIC -> "🎵" }
                            Text(icon, fontSize = 24.sp)
                            Column(Modifier.weight(1f)) {
                                Text(audio.title, style = MaterialTheme.typography.titleSmall.copy(fontWeight = if (sel) FontWeight.Bold else FontWeight.Normal), color = if (sel) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface)
                                Text(audio.description, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(0.5f))
                            }
                            if (playing) Icon(Icons.Default.GraphicEq, "Reproduciendose", tint = GoldPharaoh, modifier = Modifier.size(20.dp))
                        }
                    }
                }
            }
        }
    }
}
