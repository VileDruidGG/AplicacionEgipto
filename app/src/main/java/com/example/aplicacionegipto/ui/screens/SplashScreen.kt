package com.example.aplicacionegipto.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionegipto.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToHome: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim by animateFloatAsState(targetValue = if (startAnimation) 1f else 0f, animationSpec = tween(1500, easing = EaseOutCubic), label = "alpha")
    val scaleAnim by animateFloatAsState(targetValue = if (startAnimation) 1f else 0.8f, animationSpec = tween(1200, easing = EaseOutBack), label = "scale")
    val subtitleAlpha by animateFloatAsState(targetValue = if (startAnimation) 1f else 0f, animationSpec = tween(1000, delayMillis = 800, easing = EaseOut), label = "sub")

    LaunchedEffect(Unit) { startAnimation = true; delay(3000); onNavigateToHome() }

    Box(modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(NightSky, LapisLazuli, GoldDark.copy(alpha = 0.3f), SurfaceDark)))
        .semantics { contentDescription = "Bienvenido al Museo Interactivo de Arte del Antiguo Egipto" }, contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(32.dp).alpha(alphaAnim).scale(scaleAnim)) {
            Text(text = "\u{13080}", fontSize = 72.sp, color = GoldPharaoh, modifier = Modifier.semantics { contentDescription = "Ojo de Horus" })
            Spacer(Modifier.height(24.dp))
            Text("MUSEO INTERACTIVO", style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = 3.sp), color = GoldPharaoh, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text("DEL ANTIGUO EGIPTO", style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Light, letterSpacing = 4.sp), color = GoldLight, textAlign = TextAlign.Center)
            Spacer(Modifier.height(32.dp))
            Box(Modifier.width(120.dp).height(2.dp).background(Brush.horizontalGradient(listOf(GoldPharaoh.copy(alpha = 0f), GoldPharaoh, GoldPharaoh.copy(alpha = 0f)))))
            Spacer(Modifier.height(24.dp))
            Text("Un viaje a trav\u00e9s del tiempo\ny la cultura", style = MaterialTheme.typography.bodyLarge, color = SandPapyrus.copy(alpha = subtitleAlpha), textAlign = TextAlign.Center, modifier = Modifier.alpha(subtitleAlpha))
        }
    }
}
