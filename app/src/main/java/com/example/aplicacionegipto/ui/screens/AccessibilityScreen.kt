package com.example.aplicacionegipto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionegipto.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessibilityScreen(
    currentTextScale: Float,
    currentHighContrast: Boolean,
    onTextScaleChange: (Float) -> Unit,
    onHighContrastChange: (Boolean) -> Unit,
    audioDescEnabled: Boolean,
    onAudioDescChange: (Boolean) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Accesibilidad", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) },
            navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Regresar") } },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
        )
    }) { pv ->
        Column(
            Modifier.fillMaxSize().padding(pv).verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                Modifier.fillMaxWidth().semantics { contentDescription = "Configuracion de accesibilidad del museo." },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f))
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Opciones de accesibilidad", style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(4.dp))
                    Text("Personaliza la aplicacion para una experiencia mas comoda.", style = MaterialTheme.typography.bodyMedium)
                }
            }

            // Tamaño de texto
            AS(Icons.Default.TextFields, "Tamano de texto", "Ajusta el tamano de todo el texto.") {
                Column {
                    Text(
                        "Texto de ejemplo - Antiguo Egipto",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = (16 * currentTextScale).sp),
                        modifier = Modifier.semantics { contentDescription = "Vista previa: ${(currentTextScale * 100).toInt()}%" }
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("A", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                        Slider(
                            currentTextScale, onTextScaleChange, valueRange = 0.8f..2.0f, steps = 5,
                            modifier = Modifier.weight(1f).semantics { contentDescription = "Escala de texto: ${(currentTextScale * 100).toInt()}%. Desliza para ajustar." },
                            colors = SliderDefaults.colors(thumbColor = GoldPharaoh, activeTrackColor = GoldPharaoh)
                        )
                        Text("A", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                    }
                    Text(
                        "Escala: ${(currentTextScale * 100).toInt()}%",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }

            // Alto contraste
            AS(Icons.Default.Contrast, "Alto contraste", "Aumenta el contraste para mejorar legibilidad.") {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(if (currentHighContrast) "Activado" else "Desactivado", style = MaterialTheme.typography.bodyLarge)
                    Switch(
                        currentHighContrast, onHighContrastChange,
                        modifier = Modifier.semantics { contentDescription = "Alto contraste ${if (currentHighContrast) "activado" else "desactivado"}" },
                        colors = SwitchDefaults.colors(checkedThumbColor = GoldPharaoh, checkedTrackColor = GoldPharaoh.copy(alpha = 0.5f))
                    )
                }
            }

            // Audio descriptivo
            AS(Icons.Default.RecordVoiceOver, "Audio descriptivo", "Reproduce la descripcion de cada imagen automaticamente al abrirla.") {
                Column {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text(if (audioDescEnabled) "Activado" else "Desactivado", style = MaterialTheme.typography.bodyLarge)
                        Switch(
                            checked = audioDescEnabled,
                            onCheckedChange = onAudioDescChange,
                            modifier = Modifier.semantics { contentDescription = "Audio descriptivo ${if (audioDescEnabled) "activado" else "desactivado"}" },
                            colors = SwitchDefaults.colors(checkedThumbColor = GoldPharaoh, checkedTrackColor = GoldPharaoh.copy(alpha = 0.5f))
                        )
                    }
                    if (audioDescEnabled) {
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "Al abrir o cambiar de imagen el sistema lera en voz alta su descripcion. Tambien puedes tocar el icono de audio en cualquier momento.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }
                }
            }

            // Nota TalkBack
            Card(
                Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
            ) {
                Column(Modifier.padding(16.dp).semantics { contentDescription = "Compatible con TalkBack y lectores de pantalla." }) {
                    Text("Compatibilidad con lectores de pantalla", style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Esta aplicacion es compatible con TalkBack y otros servicios de accesibilidad de Android. Todos los botones, imagenes y gestos incluyen descripciones detalladas.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            }
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun AS(icon: ImageVector, title: String, description: String, content: @Composable () -> Unit) {
    Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), elevation = CardDefaults.cardElevation(2.dp)) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Icon(icon, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(28.dp))
                Column {
                    Text(title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                    Text(description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                }
            }
            Spacer(Modifier.height(12.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
            Spacer(Modifier.height(12.dp))
            content()
        }
    }
}
