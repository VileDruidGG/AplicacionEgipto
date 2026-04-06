package com.example.aplicacionegipto.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.VolumeUp
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
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.model.AgeGroup
import com.example.aplicacionegipto.ui.components.MuseumAsyncImage
import com.example.aplicacionegipto.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(sectionId: String, articleId: String, onBack: () -> Unit, onImageClick: (Int) -> Unit) {
    var selectedAge by remember { mutableStateOf(AgeGroup.ADULT) }
    val idx = articleId.removePrefix("article_").toIntOrNull() ?: 0
    val urls = MuseumRepository.getImageUrls(sectionId)
    val url = urls.getOrNull(idx) ?: ""
    val title = getTitle(sectionId, idx)
    val content = getContent(sectionId, idx, selectedAge)

    Scaffold(topBar = { TopAppBar(title = { Text(title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), maxLines = 1) },
        navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Regresar") } },
        actions = { IconButton(onClick = {}, modifier = Modifier.semantics { contentDescription = "Reproducir audio descriptivo del articulo" }) { Icon(Icons.Default.VolumeUp, null, tint = MaterialTheme.colorScheme.primary) } },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)) }) { pv ->
        Column(Modifier.fillMaxSize().padding(pv).verticalScroll(rememberScrollState())) {
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp).semantics { contentDescription = "Selector de nivel. Mostrando contenido para ${selectedAge.label}." }, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AgeGroup.entries.forEach { age -> FilterChip(selected = age == selectedAge, onClick = { selectedAge = age }, label = { Text(when(age) { AgeGroup.CHILD -> "Ninos"; AgeGroup.TEEN -> "Adolescentes"; AgeGroup.ADULT -> "Adultos" }) }, colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.primary, selectedLabelColor = MaterialTheme.colorScheme.onPrimary)) }
            }
            Card(Modifier.fillMaxWidth().height(200.dp).padding(horizontal = 16.dp).clickable { onImageClick(0) }.semantics { contentDescription = "Imagen del articulo. Toca para ampliar con zoom." }, shape = RoundedCornerShape(12.dp)) {
                if (url.isNotEmpty()) MuseumAsyncImage(url, "Imagen de $title", Modifier.fillMaxSize())
                else Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(LapisLazuli.copy(alpha = 0.4f), GoldDark.copy(alpha = 0.3f)))), contentAlignment = Alignment.Center) { Text("Toca para ampliar", style = MaterialTheme.typography.bodySmall, color = Color.White) }
            }
            Spacer(Modifier.height(16.dp))
            Column(Modifier.padding(horizontal = 16.dp).semantics { contentDescription = "Articulo: $title. Contenido para ${selectedAge.label}." }) {
                Text(title, style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.primary)
                Spacer(Modifier.height(4.dp)); Text("Contenido para ${selectedAge.label}", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                Box(Modifier.padding(vertical = 12.dp).fillMaxWidth().height(2.dp).background(Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.primary.copy(alpha = 0f)))))
                Text(content, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface, lineHeight = 26.sp)
                Spacer(Modifier.height(16.dp))
                Text("Desliza para ver el articulo anterior o siguiente", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}

private fun getTitle(sid: String, idx: Int) = when(sid) {
    "vida_cotidiana" -> listOf("Alimentacion y cocina","Vestimenta y joyeria","La familia egipcia","Juegos y entretenimiento","Medicina y salud").getOrElse(idx) { "Articulo" }
    "arquitectura" -> listOf("Las Grandes Piramides de Giza","Templos de Karnak y Luxor","La Gran Esfinge","Tumbas del Valle de los Reyes","Obeliscos y columnas").getOrElse(idx) { "Articulo" }
    "arte" -> listOf("Jeroglificos: escritura sagrada","Pintura mural y frescos","Escultura y estatuaria","Mascara de Tutankamon","Arte funerario y sarcofagos").getOrElse(idx) { "Articulo" }
    else -> "Articulo del Museo"
}

private fun getContent(sid: String, idx: Int, age: AgeGroup): String {
    val t = getTitle(sid, idx)
    return when(age) {
        AgeGroup.CHILD -> "Hola pequeno explorador! $t es un tema muy interesante. Imagina que pudieras viajar en el tiempo al Antiguo Egipto... Sabias que los egipcios vivieron hace mas de 3,000 anos? Ellos construyeron cosas increibles y tenian costumbres muy diferentes a las nuestras. Vamos a descubrir juntos los secretos de esta civilizacion fascinante. Los egipcios eran muy creativos y les encantaba decorar todo lo que hacian."
        AgeGroup.TEEN -> "$t\n\nEl Antiguo Egipto fue una de las civilizaciones mas avanzadas de su epoca. Durante mas de 3,000 anos, los egipcios desarrollaron sistemas complejos de gobierno, religion, arte y ciencia que siguen asombrando al mundo actual.\n\nDatos interesantes:\n- La civilizacion egipcia duro mas que cualquier imperio europeo.\n- Desarrollaron uno de los primeros sistemas de escritura.\n- Su conocimiento matematico fue esencial para construir monumentos."
        AgeGroup.ADULT -> "$t\n\nLa civilizacion del Antiguo Egipto, que se extendio desde aproximadamente el 3100 a.C. hasta el 30 a.C., representa uno de los capitulos mas fascinantes de la historia humana. Su contribucion a la arquitectura, el arte, la medicina y la organizacion social ha dejado un legado perdurable.\n\nEl analisis academico de este periodo revela una sociedad notablemente sofisticada, con estructuras jerarquicas bien definidas, un sistema religioso complejo que permeaba todos los aspectos de la vida, y avances tecnologicos que, en muchos casos, no serian igualados durante milenios.\n\nLa investigacion arqueologica moderna continua descubriendo nuevos aspectos de esta civilizacion, utilizando tecnologias como el LIDAR y el analisis de ADN antiguo."
    }
}
