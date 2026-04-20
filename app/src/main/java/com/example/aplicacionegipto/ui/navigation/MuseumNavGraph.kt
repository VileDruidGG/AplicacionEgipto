package com.example.aplicacionegipto.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aplicacionegipto.ui.screens.*

@Composable
fun MuseumNavGraph(
    navController: NavHostController,
    textScale: Float,
    highContrast: Boolean,
    onTextScaleChange: (Float) -> Unit,
    onHighContrastChange: (Boolean) -> Unit
) {
    // Estado global del audio descriptivo, compartido entre AccessibilityScreen
    // e ImageViewerScreen via hoisting en el NavGraph
    var audioDescEnabled by remember { mutableStateOf(true) }

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route, exitTransition = { fadeOut(tween(500)) }) {
            SplashScreen(onNavigateToHome = {
                navController.navigate(Screen.Home.route) { popUpTo(Screen.Splash.route) { inclusive = true } }
            })
        }
        composable(Screen.Home.route,
            enterTransition = { fadeIn(tween(600)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it / 3 }, animationSpec = tween(400)) + fadeOut(tween(400)) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it / 3 }, animationSpec = tween(400)) + fadeIn(tween(400)) }
        ) {
            HomeScreen(
                onSectionClick = { navController.navigate(Screen.SectionDetail.createRoute(it)) },
                onAccessibilityClick = { navController.navigate(Screen.Accessibility.route) }
            )
        }
        composable(Screen.SectionDetail.route, arguments = listOf(navArgument("sectionId") { type = NavType.StringType }),
            enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(400)) + fadeIn(tween(400)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it / 3 }, animationSpec = tween(400)) + fadeOut(tween(300)) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it / 3 }, animationSpec = tween(400)) + fadeIn(tween(400)) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(400)) + fadeOut(tween(300)) }
        ) { entry ->
            val sectionId = entry.arguments?.getString("sectionId") ?: return@composable
            SectionDetailScreen(sectionId = sectionId,
                onArticleClick = { navController.navigate(Screen.ArticleDetail.createRoute(sectionId, it)) },
                onGalleryClick = { navController.navigate(Screen.ImageGallery.createRoute(sectionId)) },
                onAudioClick = { navController.navigate(Screen.AudioPlayer.createRoute(sectionId)) },
                onVideoClick = { navController.navigate(Screen.VideoPlayer.createRoute(sectionId)) },
                onBack = { navController.popBackStack() })
        }
        composable(Screen.ArticleDetail.route, arguments = listOf(navArgument("sectionId") { type = NavType.StringType }, navArgument("articleId") { type = NavType.StringType }),
            enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(400)) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(400)) }
        ) { entry ->
            val sectionId = entry.arguments?.getString("sectionId") ?: return@composable
            val articleId = entry.arguments?.getString("articleId") ?: return@composable
            ArticleDetailScreen(sectionId = sectionId, articleId = articleId,
                onBack = { navController.popBackStack() },
                onImageClick = { navController.navigate(Screen.ImageViewer.createRoute(sectionId, it)) })
        }
        composable(Screen.ImageGallery.route, arguments = listOf(navArgument("sectionId") { type = NavType.StringType }),
            enterTransition = { fadeIn(tween(400)) + scaleIn(initialScale = 0.92f) },
            popExitTransition = { fadeOut(tween(300)) + scaleOut(targetScale = 0.92f) }
        ) { entry ->
            val sectionId = entry.arguments?.getString("sectionId") ?: return@composable
            ImageGalleryScreen(sectionId = sectionId,
                onImageClick = { navController.navigate(Screen.ImageViewer.createRoute(sectionId, it)) },
                onBack = { navController.popBackStack() })
        }
        composable(Screen.ImageViewer.route, arguments = listOf(navArgument("sectionId") { type = NavType.StringType }, navArgument("imageIndex") { type = NavType.IntType }),
            enterTransition = { fadeIn(tween(300)) }, popExitTransition = { fadeOut(tween(300)) }
        ) { entry ->
            val sectionId = entry.arguments?.getString("sectionId") ?: return@composable
            val imageIndex = entry.arguments?.getInt("imageIndex") ?: 0
            ImageViewerScreen(
                sectionId = sectionId,
                initialIndex = imageIndex,
                audioDescEnabled = audioDescEnabled,   // <-- estado global conectado
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.AudioPlayer.route, arguments = listOf(navArgument("sectionId") { type = NavType.StringType }),
            enterTransition = { slideInVertically(initialOffsetY = { it }, animationSpec = tween(500)) },
            popExitTransition = { slideOutVertically(targetOffsetY = { it }, animationSpec = tween(400)) }
        ) { entry ->
            val sectionId = entry.arguments?.getString("sectionId") ?: return@composable
            AudioPlayerScreen(sectionId = sectionId, onBack = { navController.popBackStack() })
        }
        composable(Screen.VideoPlayer.route, arguments = listOf(navArgument("sectionId") { type = NavType.StringType }),
            enterTransition = { slideInVertically(initialOffsetY = { it }, animationSpec = tween(500)) },
            popExitTransition = { slideOutVertically(targetOffsetY = { it }, animationSpec = tween(400)) }
        ) { entry ->
            val sectionId = entry.arguments?.getString("sectionId") ?: return@composable
            VideoPlayerScreen(sectionId = sectionId, onBack = { navController.popBackStack() })
        }
        composable(Screen.Accessibility.route,
            enterTransition = { slideInVertically(initialOffsetY = { it / 2 }, animationSpec = tween(400)) },
            popExitTransition = { slideOutVertically(targetOffsetY = { it / 2 }, animationSpec = tween(300)) }
        ) {
            AccessibilityScreen(
                currentTextScale = textScale,
                currentHighContrast = highContrast,
                onTextScaleChange = onTextScaleChange,
                onHighContrastChange = onHighContrastChange,
                audioDescEnabled = audioDescEnabled,               // <-- pasar estado
                onAudioDescChange = { audioDescEnabled = it },     // <-- recibir cambios
                onBack = { navController.popBackStack() }
            )
        }
    }
}
