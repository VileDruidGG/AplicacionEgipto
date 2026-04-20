package com.example.aplicacionegipto.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.ui.components.YouTubePlayerComposable
import com.example.aplicacionegipto.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoPlayerScreen(sectionId: String, onBack: () -> Unit) {
    val t = when(sectionId) { "vida_cotidiana"->"Vida Cotidiana"; "arquitectura"->"Arquitectura"; "arte"->"Arte"; else->"Video" }
    val videos = MuseumRepository.getVideos(sectionId)
    var ci by remember { mutableIntStateOf(0) }
    Scaffold(topBar = { TopAppBar(title = { Text("Videos - $t", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)) }, navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Regresar") } }, colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)) }) { pv ->
        LazyColumn(Modifier.fillMaxSize().padding(pv), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                val videoId = videos.getOrNull(ci)?.youtubeId ?: ""
                if (videoId.isNotEmpty()) {
                    YouTubePlayerComposable(
                        youtubeId = videoId,
                        description = "Video: ${videos.getOrNull(ci)?.title ?: ""}"
                    )
                }
            }
            item { val v = videos.getOrNull(ci); if (v != null) Column(modifier = Modifier.semantics { contentDescription = "Video: ${v.title}. ${v.description}" }) { Text(v.title, style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)); Spacer(Modifier.height(4.dp)); Text(v.description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)) } }
            item { Text("Mas videos sobre Egipto", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.primary) }
            itemsIndexed(videos) { i, v ->
                Card(Modifier.fillMaxWidth().clickable { ci = i }.semantics { contentDescription = "Video ${i+1}: ${v.title}. ${v.description}" }, shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(containerColor = if (i == ci) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f) else MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(if (i == ci) 4.dp else 1.dp)) {
                    Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Box(Modifier.size(80.dp, 50.dp).background(Brush.horizontalGradient(listOf(LapisLazuli.copy(alpha = 0.4f), GoldDark.copy(alpha = 0.3f))), RoundedCornerShape(6.dp)), contentAlignment = Alignment.Center) { Icon(Icons.Default.PlayCircleOutline, null, tint = Color.White, modifier = Modifier.size(24.dp)) }
                        Column(Modifier.weight(1f)) { Text(v.title, style = MaterialTheme.typography.titleSmall.copy(fontWeight = if (i == ci) FontWeight.Bold else FontWeight.Normal), color = if (i == ci) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface, maxLines = 1, overflow = TextOverflow.Ellipsis); Text(v.description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f), maxLines = 2, overflow = TextOverflow.Ellipsis) }
                        if (i == ci) Icon(Icons.Default.GraphicEq, "Seleccionado", tint = GoldPharaoh, modifier = Modifier.size(20.dp))
                    }
                }
            }
        }
    }
}
