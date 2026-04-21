package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    // === VIDA COTIDIANA ===
    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Panaderia y cerveceria","Modelo de taller de pan y cerveza de la tumba de Meketre"),
        MuseumImage("vc2","vc2","Estatuilla de Lady Tiye","Mujer noble egipcia con vestido de lino y peluca elaborada"),
        MuseumImage("vc3","vc3","Nikare con esposa e hija","Grupo familiar egipcio: padre, madre e hija juntos"),
        MuseumImage("vc4","vc4","Juego Hounds and Jackals","Tablero de juego de marfil y ebano encontrado en tumba real"),
        MuseumImage("vc5","vc5","Estela magica de Horus","Estela con Horus nino para proteccion magica contra enfermedades"),
        MuseumImage("vc6","vc6","Barco de cocina","Barco con cocineros preparando pan y cerveza para el viaje"),
        MuseumImage("vc7","vc7","Pectoral de Sithathoryunet","Pectoral de oro y piedras semipreciosas de una princesa real"),
        MuseumImage("vc8","vc8","Yuny y su esposa Renenutet","Pareja egipcia abrazada, simbolo de amor conyugal"),
        MuseumImage("vc9","vc9","Caja cosmetica con tapa","Caja de cosmeticos con tapa giratoria para maquillaje y unguentos"),
        MuseumImage("vc10","vc10","Isis con Horus bebe","Diosa Isis amamantando a Horus, simbolo de proteccion maternal")
    )

    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Mastaba de Perneb","Tumba mastaba de piedra caliza del administrador Perneb en Saqqara"),
        MuseumImage("ar2","ar2","Templo de Dendur","Templo egipcio completo reconstruido en el Metropolitan Museum"),
        MuseumImage("ar3","ar3","Esfinge de Hatshepsut","Esfinge colosal de granito de la faraona Hatshepsut"),
        MuseumImage("ar4","ar4","Sarcofago de Harkhebit","Sarcofago monumental de un alto oficial encontrado en Saqqara"),
        MuseumImage("ar5","ar5","Hatshepsut arrodillada","Gran estatua de Hatshepsut que mando construir obeliscos en Karnak"),
        MuseumImage("ar6","ar6","Estatua Rey Menkaure","Estatua sedente del constructor de la tercera piramide de Giza"),
        MuseumImage("ar7","ar7","Pedestal del Rey Khafre","Soporte con nombre del constructor de la segunda piramide"),
        MuseumImage("ar8","ar8","Esfinge de Senwosret III","Esfinge de gneis del Reino Medio con rasgos realistas"),
        MuseumImage("ar9","ar9","Esfinge de Amenhotep III","Esfinge unica de fayenza azul con manos humanas"),
        MuseumImage("ar10","ar10","Sarcofago de Khnumhotep","Sarcofago del Reino Medio con ojos wedjat pintados")
    )

    private val arteImages = listOf(
        MuseumImage("at1","at1","Santuario con jeroglificos","Santuario de Amenemhat con jeroglificos tallados en piedra"),
        MuseumImage("at2","at2","Pintura mural del gato","Pintura de gato matando serpiente de la tumba de Sennedjem"),
        MuseumImage("at3","at3","Hatshepsut como faraona","Escultura de Hatshepsut con vestimenta femenina y corona real"),
        MuseumImage("at4","at4","Mascara funeraria dorada","Mascara de oro de Hatnefer con ojos de obsidiana y alabastro"),
        MuseumImage("at5","at5","Sarcofago pintado Henettawy","Sarcofago con pinturas elaboradas de la cantora de Amun-Ra"),
        MuseumImage("at6","at6","Mujer nubia","Figura femenina de Nubia mostrando la diversidad cultural"),
        MuseumImage("at7","at7","Esfinge Senwosret III","Obra maestra de escultura del Reino Medio tallada en gneis"),
        MuseumImage("at8","at8","Escarabajo corazon de oro","Escarabajo de Hatnefer con hechizo del Libro de los Muertos"),
        MuseumImage("at9","at9","Sarcofago decorado Ukhhotep","Sarcofago del tesorero real con escenas del Mas Alla"),
        MuseumImage("at10","at10","Sarcofago Khnumhotep","Sarcofago decorado con jeroglificos y ojos wedjat")
    )

    // === URLs IIIF del Met Museum ===
    val imageUrlsVidaCotidiana = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544258/1178720/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544524/1793037/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543901/1214210/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543867/1221835/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/546037/2306456/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544212/1220804/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544232/1151819/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544740/1151839/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/547031/1084353/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548310/1214471/main-image"
    )
    val imageUrlsArquitectura = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543937/1082904/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/547802/1223802/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106258/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548211/1220671/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544449/1179859/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543935/1085207/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543910/1172813/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1151827/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544323/1448856/main-image"
    )
    val imageUrlsArte = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544166/1369337/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548564/2311333/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544849/1151822/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545147/1086200/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1359380/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544218/1297278/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545146/1223831/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/546303/1212836/main-image",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544323/1448856/main-image"
    )

    // === AUDIOS: Pixabay CDN (MP3) ===
    private const val PX_MERCADO  = "https://cdn.pixabay.com/download/audio/2025/02/28/audio_9648650449.mp3?filename=forza1903-turkish-market-ambience-307310.mp3"
    private const val PX_RIO      = "https://cdn.pixabay.com/download/audio/2024/02/09/audio_9c2c7a103a.mp3?filename=kamhunt-run-130bpm-190419.mp3"
    private const val PX_ARPA     = "https://cdn.pixabay.com/download/audio/2025/04/20/audio_59ef900d77.mp3?filename=aivion-sinfonia-de-luces-329882.mp3"
    private const val PX_FUEGO    = "https://cdn.pixabay.com/download/audio/2021/08/09/audio_0468be3726.mp3?filename=freesound_community-fire-magic-6947.mp3"
    private const val PX_CUEVA    = "https://cdn.pixabay.com/download/audio/2021/08/09/audio_27330a697b.mp3?filename=freesound_community-leaves-crunching-6954.mp3"
    private const val PX_CALMA    = "https://cdn.pixabay.com/download/audio/2024/03/21/audio_ba480d6d0d.mp3?filename=vicatestudio-chill-clam-short-version-3-197548.mp3"
    private const val PX_MISTERIO = "https://cdn.pixabay.com/download/audio/2025/05/22/audio_1e09545526.mp3?filename=simon-le-grec-simon-le-grec-city-walk-smooth-soulful-chill-music-345421.mp3"
    private const val PX_TALLER   = "https://cdn.pixabay.com/download/audio/2021/08/09/audio_a3c625517b.mp3?filename=freesound_community-factory1-6808.mp3"

    private val vidaCotidianaAudios = listOf(
        AudioItem("vc_aud_1", "Sonidos del mercado",    PX_MERCADO,  AudioType.AMBIENT, "Ambiente de mercado antiguo"),
        AudioItem("vc_aud_2", "Vida junto al Nilo",     PX_RIO,      AudioType.AMBIENT, "Sonidos del rio Nilo"),
        AudioItem("vc_aud_3", "Arpa egipcia",            PX_ARPA,     AudioType.MUSIC,   "Melodia de arpa instrumental"),
        AudioItem("vc_aud_4", "Cantos de trabajo",      PX_MERCADO,  AudioType.AMBIENT, "Voces y canticos de artesanos"),
        AudioItem("vc_aud_5", "Cocina del faraon",      PX_FUEGO,    AudioType.AMBIENT, "Fuego y sonidos de cocina")
    )
    private val arquitecturaAudios = listOf(
        AudioItem("arq_aud_1", "Ecos en la Piramide",   PX_CUEVA,    AudioType.AMBIENT, "Resonancia en camara de piedra"),
        AudioItem("arq_aud_2", "Construccion",           PX_TALLER,   AudioType.AMBIENT, "Trabajo y construccion"),
        AudioItem("arq_aud_3", "Himnos de Karnak",      PX_CALMA,    AudioType.MUSIC,   "Musica calma y ceremonial"),
        AudioItem("arq_aud_4", "Viento del desierto",   PX_MERCADO,  AudioType.AMBIENT, "Viento y ambiente desertico"),
        AudioItem("arq_aud_5", "Secretos de la Esfinge",PX_MISTERIO, AudioType.MUSIC,   "Musica misteriosa y profunda")
    )
    private val arteAudios = listOf(
        AudioItem("art_aud_1", "Taller del escultor",   PX_TALLER,   AudioType.AMBIENT, "Sonidos de taller y herramientas"),
        AudioItem("art_aud_2", "Jeroglificos",           PX_CALMA,    AudioType.MUSIC,   "Musica contemplativa"),
        AudioItem("art_aud_3", "Musica de Osiris",       PX_MISTERIO, AudioType.MUSIC,   "Musica ritual del Mas Alla"),
        AudioItem("art_aud_4", "Pigmentos y colores",    PX_RIO,      AudioType.AMBIENT, "Sonidos suaves de preparacion"),
        AudioItem("art_aud_5", "Tesoros de Tutankamon",  PX_ARPA,     AudioType.MUSIC,   "Melodia solemne y dorada")
    )

    // === VIDEOS: Wikimedia Commons (WebM/OGV, verificados con Range 206) ===
    // Pixabay bloquea hotlinking de video. Wikimedia permite acceso publico.
    private const val WK_GIZA     = "https://upload.wikimedia.org/wikipedia/commons/4/43/Giza_pyramid_complex_3D_flyover.webm"
    private const val WK_PLATEAU  = "https://upload.wikimedia.org/wikipedia/commons/f/fb/View_pyramid_plateau.ogv"
    private const val WK_NILE1    = "https://upload.wikimedia.org/wikipedia/commons/0/04/Nile-River-Cruise.ogv"
    private const val WK_NILE2    = "https://upload.wikimedia.org/wikipedia/commons/0/0b/Nile-River2.ogv"
    private const val WK_NUBIA    = "https://upload.wikimedia.org/wikipedia/commons/f/fe/Nuri_Pyramids_from_top_of_the_Pyramid_of_King_Taharqa.webm"
    private const val WK_MUMMY    = "https://upload.wikimedia.org/wikipedia/commons/7/73/US_Scientists_Get_Closer_Look_at_Egyptian_Mummy.webm"
    private const val WK_EGYPT    = "https://upload.wikimedia.org/wikipedia/commons/5/5c/Dream_Machine_Egypt_animation.webm"
    private const val WK_CAIRO    = "https://upload.wikimedia.org/wikipedia/commons/a/a8/Open_street_maps_zooming_to_Cairo%2C_Egypt.webm"
    private const val WK_COUPLE   = "https://upload.wikimedia.org/wikipedia/commons/e/ee/Royal_couple-MAHG_12440-0001-0250.ogv"
    private const val WK_PYRAMIDS = "https://upload.wikimedia.org/wikipedia/commons/7/7f/Pyramids.ogv"

    private val vidaCotidianaVideos = listOf(
        VideoItem("vc_vid_1", "Vida en el Antiguo Egipto",         WK_EGYPT,   "Animacion sobre la vida en el Antiguo Egipto"),
        VideoItem("vc_vid_2", "Pareja real egipcia",               WK_COUPLE,  "Representacion de una pareja noble del Antiguo Egipto"),
        VideoItem("vc_vid_3", "El Rio Nilo",                       WK_NILE1,   "Crucero por el sagrado Rio Nilo"),
        VideoItem("vc_vid_4", "Vistas del Nilo",                   WK_NILE2,   "Paisajes del Rio Nilo, fuente de vida de Egipto"),
        VideoItem("vc_vid_5", "El Cairo desde el aire",            WK_CAIRO,   "Vista aerea de El Cairo, capital de Egipto")
    )
    private val arquitecturaVideos = listOf(
        VideoItem("arq_vid_1", "Vuelo 3D sobre Giza",              WK_GIZA,    "Recreacion 3D del complejo de piramides de Giza"),
        VideoItem("arq_vid_2", "Meseta de las Piramides",          WK_PLATEAU, "Vista panoramica de la meseta de Giza"),
        VideoItem("arq_vid_3", "Las Piramides de Egipto",          WK_PYRAMIDS,"Las grandes piramides del Antiguo Egipto"),
        VideoItem("arq_vid_4", "Piramides de Nubia",               WK_NUBIA,   "Las piramides nubias del Rey Taharqa"),
        VideoItem("arq_vid_5", "El Nilo y sus monumentos",         WK_NILE2,   "El Rio Nilo y la arquitectura a sus orillas")
    )
    private val arteVideos = listOf(
        VideoItem("art_vid_1", "Arte y momificacion egipcia",      WK_MUMMY,   "Ciencia moderna examina una momia del Antiguo Egipto"),
        VideoItem("art_vid_2", "Animacion del Antiguo Egipto",     WK_EGYPT,   "Recreacion animada de la vida y el arte egipcio"),
        VideoItem("art_vid_3", "Esculturas de la pareja real",     WK_COUPLE,  "Arte escultorico de parejas reales en el Antiguo Egipto"),
        VideoItem("art_vid_4", "Piramides como arte monumental",   WK_GIZA,    "Las piramides de Giza como obra maestra del arte"),
        VideoItem("art_vid_5", "Piramides de Nubia: arte y poder", WK_NUBIA,   "Las piramides nubias como expresion de arte y poder")
    )

    fun getImageUrls(sectionId: String) = when(sectionId) { "vida_cotidiana"->imageUrlsVidaCotidiana; "arquitectura"->imageUrlsArquitectura; "arte"->imageUrlsArte; else->emptyList() }
    fun getImages(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaImages; "arquitectura"->arquitecturaImages; "arte"->arteImages; else->emptyList() }
    fun getAudios(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaAudios; "arquitectura"->arquitecturaAudios; "arte"->arteAudios; else->emptyList() }
    fun getVideos(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaVideos; "arquitectura"->arquitecturaVideos; "arte"->arteVideos; else->emptyList() }
    fun getImageDescription(sectionId: String, index: Int) = getImages(sectionId).getOrNull(index)?.contentDescription ?: "Imagen del museo"
}
