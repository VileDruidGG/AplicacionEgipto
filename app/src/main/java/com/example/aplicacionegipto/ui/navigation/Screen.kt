package com.example.aplicacionegipto.ui.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object Home : Screen("home_screen")
    data object SectionDetail : Screen("section_detail/{sectionId}") {
        fun createRoute(sectionId: String) = "section_detail/$sectionId"
    }
    data object ArticleDetail : Screen("article_detail/{sectionId}/{articleId}") {
        fun createRoute(sectionId: String, articleId: String) =
            "article_detail/$sectionId/$articleId"
    }
    data object ImageGallery : Screen("image_gallery/{sectionId}") {
        fun createRoute(sectionId: String) = "image_gallery/$sectionId"
    }
    data object ImageViewer : Screen("image_viewer/{sectionId}/{imageIndex}") {
        fun createRoute(sectionId: String, imageIndex: Int) =
            "image_viewer/$sectionId/$imageIndex"
    }
    data object AudioPlayer : Screen("audio_player/{sectionId}") {
        fun createRoute(sectionId: String) = "audio_player/$sectionId"
    }
    data object VideoPlayer : Screen("video_player/{sectionId}") {
        fun createRoute(sectionId: String) = "video_player/$sectionId"
    }
    data object Accessibility : Screen("accessibility_settings")
}
