package com.example.aplicacionegipto.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

val EgyptTypography = Typography(
    displayLarge = TextStyle(fontWeight = FontWeight.Bold, fontSize = 34.sp, letterSpacing = 1.5.sp, lineHeight = 40.sp),
    displayMedium = TextStyle(fontWeight = FontWeight.Bold, fontSize = 28.sp, letterSpacing = 1.sp, lineHeight = 34.sp),
    displaySmall = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp, letterSpacing = 0.5.sp, lineHeight = 30.sp),
    headlineLarge = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 22.sp, lineHeight = 28.sp),
    headlineMedium = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 20.sp, lineHeight = 26.sp),
    headlineSmall = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp, lineHeight = 24.sp),
    titleLarge = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp, lineHeight = 24.sp),
    titleMedium = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 22.sp),
    titleSmall = TextStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),
    bodyLarge = TextStyle(fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.25.sp),
    bodyMedium = TextStyle(fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = TextStyle(fontSize = 12.sp, lineHeight = 16.sp),
    labelLarge = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 14.sp),
    labelMedium = TextStyle(fontWeight = FontWeight.Medium, fontSize = 12.sp),
    labelSmall = TextStyle(fontWeight = FontWeight.Medium, fontSize = 10.sp)
)

private val LightColorScheme = lightColorScheme(
    primary = GoldPharaoh, onPrimary = KohlBlack, primaryContainer = GoldLight,
    secondary = LapisLazuli, onSecondary = SandPapyrus, tertiary = TurquoiseEgypt,
    background = SurfaceLight, onBackground = TextOnLight, surface = SurfaceLight,
    onSurface = TextOnLight, surfaceVariant = SandDark, error = RedDesert, outline = TextMuted
)
private val DarkColorScheme = darkColorScheme(
    primary = GoldLight, onPrimary = KohlBlack, primaryContainer = GoldDark,
    secondary = LapisLight, onSecondary = SandLight, tertiary = TurquoiseLight,
    background = SurfaceDark, onBackground = TextOnDark, surface = SurfaceDark,
    onSurface = TextOnDark, surfaceVariant = CardDark, error = TerraCotta, outline = TextMuted
)
private val HighContrastColorScheme = darkColorScheme(
    primary = HighContrastAccent, onPrimary = HighContrastBg,
    background = HighContrastBg, onBackground = HighContrastText,
    surface = HighContrastBg, onSurface = HighContrastText,
    surfaceVariant = Color(0xFF222222), onSurfaceVariant = HighContrastText
)

val EgyptShapes = Shapes(
    small = androidx.compose.foundation.shape.RoundedCornerShape(4.dp),
    medium = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
    large = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
)

@Composable
fun MuseoEgiptoTheme(darkTheme: Boolean = isSystemInDarkTheme(), highContrast: Boolean = false, textScale: Float = 1.0f, content: @Composable () -> Unit) {
    val colorScheme = when { highContrast -> HighContrastColorScheme; darkTheme -> DarkColorScheme; else -> LightColorScheme }
    val typ = if (textScale != 1.0f) Typography(
        displayLarge = EgyptTypography.displayLarge.copy(fontSize = (34*textScale).sp),
        displayMedium = EgyptTypography.displayMedium.copy(fontSize = (28*textScale).sp),
        displaySmall = EgyptTypography.displaySmall.copy(fontSize = (24*textScale).sp),
        headlineLarge = EgyptTypography.headlineLarge.copy(fontSize = (22*textScale).sp),
        headlineMedium = EgyptTypography.headlineMedium.copy(fontSize = (20*textScale).sp),
        headlineSmall = EgyptTypography.headlineSmall.copy(fontSize = (18*textScale).sp),
        titleLarge = EgyptTypography.titleLarge.copy(fontSize = (18*textScale).sp),
        titleMedium = EgyptTypography.titleMedium.copy(fontSize = (16*textScale).sp),
        titleSmall = EgyptTypography.titleSmall.copy(fontSize = (14*textScale).sp),
        bodyLarge = EgyptTypography.bodyLarge.copy(fontSize = (16*textScale).sp),
        bodyMedium = EgyptTypography.bodyMedium.copy(fontSize = (14*textScale).sp),
        bodySmall = EgyptTypography.bodySmall.copy(fontSize = (12*textScale).sp),
        labelLarge = EgyptTypography.labelLarge.copy(fontSize = (14*textScale).sp),
        labelMedium = EgyptTypography.labelMedium.copy(fontSize = (12*textScale).sp),
        labelSmall = EgyptTypography.labelSmall.copy(fontSize = (10*textScale).sp)
    ) else EgyptTypography
    val view = LocalView.current
    if (!view.isInEditMode) { SideEffect { val w = (view.context as Activity).window; w.statusBarColor = colorScheme.background.toArgb(); WindowCompat.getInsetsController(w, view).isAppearanceLightStatusBars = !darkTheme } }
    MaterialTheme(colorScheme = colorScheme, typography = typ, shapes = EgyptShapes, content = content)
}
