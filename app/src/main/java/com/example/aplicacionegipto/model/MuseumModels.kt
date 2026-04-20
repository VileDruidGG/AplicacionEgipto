package com.example.aplicacionegipto.model

data class Section(
    val id: String,
    val title: String,
    val description: String,
    val iconResName: String,
    val articles: List<Article>,
    val images: List<MuseumImage>,
    val audioFiles: List<AudioItem>,
    val videos: List<VideoItem>
)

data class Article(
    val id: String,
    val title: String,
    val contentChild: String,
    val contentTeen: String,
    val contentAdult: String,
    val imageResNames: List<String>,
    val audioDescriptionResName: String? = null
)

data class MuseumImage(
    val id: String,
    val resName: String,
    val title: String,
    val contentDescription: String,
    val audioDescResName: String? = null
)

data class AudioItem(
    val id: String,
    val title: String,
    val audioUrl: String,   // URL directa de Pixabay CDN (MP3)
    val type: AudioType,
    val description: String
)

enum class AudioType {
    AMBIENT,
    NARRATION,
    MUSIC
}

data class VideoItem(
    val id: String,
    val title: String,
    val url: String,
    val description: String,
    val thumbnailResName: String? = null,
    val durationMs: Long = 0
)

enum class AgeGroup(val label: String) {
    CHILD("Niños"),
    TEEN("Adolescentes"),
    ADULT("Adultos")
}
