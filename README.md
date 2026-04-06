# Museo Interactivo de Arte del Antiguo Egipto
## Aplicacion Android - Jetpack Compose + Kotlin

Aplicacion interactiva para el Museo del Antiguo Egipto con multimedia, gestos tactiles y accesibilidad.

## Estructura

```
app/src/main/java/com/example/aplicacionegipto/
├── MainActivity.kt
├── data/
│   ├── ExoPlayerManager.kt        (Singleton ExoPlayer)
│   └── MuseumRepository.kt        (30 imagenes + 15 audios + 15 videos)
├── model/
│   └── MuseumModels.kt            (Section, Article, AudioItem, VideoItem)
├── ui/
│   ├── components/
│   │   ├── MuseumImage.kt         (Coil AsyncImage)
│   │   └── VideoPlayerView.kt     (ExoPlayer + HLS + PlayerView)
│   ├── navigation/
│   │   ├── Screen.kt              (Sealed class rutas)
│   │   └── MuseumNavGraph.kt      (NavHost con animaciones)
│   ├── screens/
│   │   ├── SplashScreen.kt        (Bienvenida animada)
│   │   ├── HomeScreen.kt          (3 secciones tematicas)
│   │   ├── SectionDetailScreen.kt (Articulos + multimedia)
│   │   ├── ArticleDetailScreen.kt (Contenido por edad)
│   │   ├── ImageGalleryScreen.kt  (Grid con Coil)
│   │   ├── ImageViewerScreen.kt   (Pinch zoom + swipe)
│   │   ├── AudioPlayerScreen.kt   (Reproductor con vinilo)
│   │   ├── VideoPlayerScreen.kt   (ExoPlayer HLS)
│   │   └── AccessibilityScreen.kt (Texto, contraste, audio)
│   └── theme/
│       ├── Color.kt               (Paleta egipcia)
│       └── Theme.kt               (Material3 + accesibilidad)
```

## Rubrica (100 pts)

| Criterio | Pts | Estado |
|----------|-----|--------|
| Diseno egipcio | 10 | Paleta oro/lapislazuli, tipografia, iconografia |
| Organizacion contenido | 10 | 3 secciones x 5 articulos, selector de edad |
| Imagenes | 20 | 10 por seccion (Wikimedia Commons + Coil) |
| Audio | 20 | 5 por seccion (ambiental + narracion + musica) |
| Video | 20 | 5 por seccion (ExoPlayer HLS streaming) |
| Interactividad | 10 | Tap, swipe, pinch-zoom, double-tap |
| Accesibilidad | 10 | Audio descriptivo, texto escalable, alto contraste |

## Gestos implementados

- **Tap**: clickable en todas las pantallas
- **Double-tap**: zoom rapido en ImageViewer
- **Pinch-to-zoom**: detectTransformGestures en ImageViewer
- **Swipe horizontal**: HorizontalPager entre imagenes
- **Scroll vertical/horizontal**: LazyColumn, LazyRow

## Tecnologias

- Jetpack Compose + Material3
- Navigation Compose
- ExoPlayer/Media3 (audio + video HLS)
- Coil (imagenes desde URL)
- TalkBack + semantics (accesibilidad)

## Compilar

1. Abrir en Android Studio
2. Sincronizar Gradle
3. Agregar audios en `app/src/main/res/raw/` (snake_case)
4. Ejecutar en dispositivo/emulador API 27+
