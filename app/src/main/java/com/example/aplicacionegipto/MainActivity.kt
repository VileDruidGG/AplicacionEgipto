package com.example.aplicacionegipto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.aplicacionegipto.ui.navigation.MuseumNavGraph
import com.example.aplicacionegipto.ui.theme.MuseoEgiptoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var textScale by remember { mutableFloatStateOf(1.0f) }
            var highContrast by remember { mutableStateOf(false) }

            MuseoEgiptoTheme(
                highContrast = highContrast,
                textScale = textScale
            ) {
                val navController = rememberNavController()

                MuseumNavGraph(
                    navController = navController,
                    textScale = textScale,
                    highContrast = highContrast,
                    onTextScaleChange = { textScale = it },
                    onHighContrastChange = { highContrast = it }
                )
            }
        }
    }
}
