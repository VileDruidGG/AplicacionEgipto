package com.example.aplicacionegipto.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionegipto.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onSectionClick: (String) -> Unit, onAccessibilityClick: () -> Unit) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("MUSEO DEL ANTIGUO EGIPTO", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp), color = MaterialTheme.colorScheme.primary) },
            actions = { IconButton(onClick = onAccessibilityClick, modifier = Modifier.semantics { contentDescription = "Abrir configuracion de accesibilidad" }) { Icon(Icons.Filled.Accessibility, contentDescription = null, tint = MaterialTheme.colorScheme.primary) } },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
        )
    }) { pv ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(pv), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                AnimatedVisibility(visible, enter = fadeIn(tween(600)) + slideInVertically(initialOffsetY = { -40 }, animationSpec = tween(600))) {
                    WelcomeHeader()
                }
            }
            val sections = listOf(
                SectionData("vida_cotidiana", "Vida Cotidiana", "Descubre como vivian los antiguos egipcios", "Explora la vida diaria del Antiguo Egipto: alimentacion, vestimenta, costumbres familiares y organizacion social.", "🏺", listOf(OcreEgypt, GoldDark), "Seccion Vida Cotidiana. Toca para explorar."),
                SectionData("arquitectura", "Arquitectura", "Las maravillas del mundo antiguo", "Admira las piramides, templos y tumbas que desafian el tiempo. Conoce los secretos de construccion.", "🏛️", listOf(LapisLazuli, TurquoiseEgypt), "Seccion Arquitectura. Toca para explorar piramides y templos."),
                SectionData("arte", "Arte", "La expresion artistica de una civilizacion", "Sumergete en el fascinante arte egipcio: jeroglificos, esculturas, pinturas murales y objetos ceremoniales.", "🎨", listOf(RedDesert, OcreEgypt), "Seccion Arte. Toca para explorar jeroglificos, esculturas y pinturas.")
            )
            itemsIndexed(sections) { index, section ->
                AnimatedVisibility(visible, enter = fadeIn(tween(500, delayMillis = 200 + index * 150)) + slideInVertically(initialOffsetY = { 80 }, animationSpec = tween(500, delayMillis = 200 + index * 150))) {
                    SectionCard(section) { onSectionClick(section.id) }
                }
            }
            item {
                Spacer(Modifier.height(8.dp))
                Text("Desliza hacia arriba para ver mas contenido", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

private data class SectionData(val id: String, val title: String, val subtitle: String, val description: String, val icon: String, val gradientColors: List<Color>, val accessibilityLabel: String)

@Composable
private fun WelcomeHeader() {
    Card(
        modifier = Modifier.fillMaxWidth().semantics(mergeDescendants = true) { contentDescription = "Bienvenido al Museo Interactivo de Arte del Antiguo Egipto. Selecciona una seccion tematica." },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Bienvenido, explorador", style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.primary, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text("Elige una sala del museo para comenzar tu viaje a traves de la fascinante civilizacion del Antiguo Egipto.", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface, textAlign = TextAlign.Center)
        }
    }
}

@Composable
private fun SectionCard(data: SectionData, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick, onClickLabel = "Abrir seccion ${data.title}").semantics { contentDescription = data.accessibilityLabel },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            Box(Modifier.fillMaxWidth().height(180.dp).background(Brush.horizontalGradient(data.gradientColors + data.gradientColors.last().copy(alpha = 0.7f))))
            Column(Modifier.fillMaxWidth().padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(data.icon, fontSize = 36.sp, modifier = Modifier.background(Color.White.copy(alpha = 0.15f), CircleShape).padding(8.dp))
                    Column {
                        Text(data.title.uppercase(), style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold, letterSpacing = 2.sp), color = Color.White)
                        Text(data.subtitle, style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.85f))
                    }
                }
                Spacer(Modifier.height(12.dp))
                Text(data.description, style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.9f), lineHeight = 20.sp)
            }
        }
    }
}
