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

    // === AUDIOS: Pixabay CDN — tematica Egipto / mundo antiguo ===
    // Todos verificados: URLs reales extraidas de paginas individuales de Pixabay

    // Musica egipcia directa
    private const val PX_EGYPT1   = "https://cdn.pixabay.com/download/audio/2025/04/09/audio_ce23d66371.mp3?filename=elijah_k-ancient-egypt-324680.mp3"
    private const val PX_EGYPT2   = "https://cdn.pixabay.com/download/audio/2026/03/14/audio_eaea69c7fa.mp3?filename=hitslab-egyptian-egypt-desert-music-502005.mp3"
    private const val PX_EGYPT3   = "https://cdn.pixabay.com/download/audio/2026/02/22/audio_b9393c4b40.mp3?filename=hitslab-egypt-egyptian-desert-music-489227.mp3"

    // Ambiente / naturaleza del mundo antiguo
    private const val PX_MERCADO  = "https://cdn.pixabay.com/download/audio/2025/02/28/audio_9648650449.mp3?filename=forza1903-turkish-market-ambience-307310.mp3"
    private const val PX_FUEGO    = "https://cdn.pixabay.com/download/audio/2025/10/28/audio_a61f2bf9d0.mp3?filename=dragon-studio-fire-crackling-sounds-427410.mp3"
    private const val PX_VIENTO   = "https://cdn.pixabay.com/download/audio/2025/05/28/audio_91c1b0fb3c.mp3?filename=tanweraman-desert-wind-1-350398.mp3"

    // Instrumentos del mundo antiguo
    private const val PX_OUD      = "https://cdn.pixabay.com/download/audio/2026/02/13/audio_dfa6f23cc3.mp3?filename=alec_koff-oud-arabic-oud-484611.mp3"
    private const val PX_FLAUTA   = "https://cdn.pixabay.com/download/audio/2025/12/22/audio_42904b46c0.mp3?filename=miromaxmusic-meditation-flute-455457.mp3"
    private const val PX_PIEDRA   = "https://cdn.pixabay.com/download/audio/2022/03/15/audio_61b7340aae.mp3?filename=freesound_community-tiny-hammer-on-stone-79954.mp3"
    private const val PX_ANCIENT  = "https://cdn.pixabay.com/download/audio/2023/04/01/audio_ae1cf2de91.mp3?filename=samuelfjohanns-ancient-ambient-144655.mp3"

    private val vidaCotidianaAudios = listOf(
        AudioItem("vc_aud_1", "Sonidos del mercado",    PX_MERCADO, AudioType.AMBIENT, "Ambiente de mercado del mundo antiguo"),
        AudioItem("vc_aud_2", "Musica egipcia",          PX_EGYPT1,  AudioType.MUSIC,   "Musica del Antiguo Egipto"),
        AudioItem("vc_aud_3", "Oud: instrumento antiguo",PX_OUD,     AudioType.MUSIC,   "Oud, instrumento de cuerda del mundo antiguo"),
        AudioItem("vc_aud_4", "Fuego en la cocina",      PX_FUEGO,   AudioType.AMBIENT, "Crepitar del fuego en la cocina del faraon"),
        AudioItem("vc_aud_5", "Flauta del desierto",     PX_FLAUTA,  AudioType.MUSIC,   "Flauta meditativa del mundo antiguo")
    )
    private val arquitecturaAudios = listOf(
        AudioItem("arq_aud_1", "Viento del desierto",    PX_VIENTO,  AudioType.AMBIENT, "Viento en las arenas del desierto egipcio"),
        AudioItem("arq_aud_2", "Cincel sobre piedra",    PX_PIEDRA,  AudioType.AMBIENT, "Martillo y cincel en la construccion"),
        AudioItem("arq_aud_3", "Musica de Egipto",       PX_EGYPT2,  AudioType.MUSIC,   "Musica egipcia y del desierto"),
        AudioItem("arq_aud_4", "Ambiente del mundo antiguo", PX_ANCIENT, AudioType.AMBIENT, "Atmosfera del mundo antiguo"),
        AudioItem("arq_aud_5", "Melodia del desierto",   PX_EGYPT3,  AudioType.MUSIC,   "Musica del desierto egipcio")
    )
    private val arteAudios = listOf(
        AudioItem("art_aud_1", "Oud ceremonial",         PX_OUD,     AudioType.MUSIC,   "Instrumento de cuerda en rituales antiguos"),
        AudioItem("art_aud_2", "Musica sagrada egipcia", PX_EGYPT1,  AudioType.MUSIC,   "Musica del Antiguo Egipto"),
        AudioItem("art_aud_3", "Flauta ritual",          PX_FLAUTA,  AudioType.MUSIC,   "Flauta en rituales del Mas Alla"),
        AudioItem("art_aud_4", "Taller del escultor",    PX_PIEDRA,  AudioType.AMBIENT, "Cincel y martillo tallando piedra"),
        AudioItem("art_aud_5", "Musica de las piramides",PX_EGYPT2,  AudioType.MUSIC,   "Musica epica del Antiguo Egipto")
    )

    // === VIDEOS ===
    private const val WK_EGYPT   = "https://upload.wikimedia.org/wikipedia/commons/5/5c/Dream_Machine_Egypt_animation.webm"
    private const val WK_CAPITAL = "https://upload.wikimedia.org/wikipedia/commons/3/3b/Constructing_Egypt%E2%80%99s_New_Capital_%28153237%29.webm"
    private const val PX_FARAON     = "https://cdn.pixabay.com/video/2023/07/15/171704-845775857_tiny.mp4"
    private const val PX_ANUBIS     = "https://cdn.pixabay.com/video/2024/03/11/203845-922675645_tiny.mp4"
    private const val PX_CAMELLO    = "https://cdn.pixabay.com/video/2023/11/24/190550-888131763_tiny.mp4"
    private const val PX_PIRAMIDE   = "https://cdn.pixabay.com/video/2024/03/24/205415-926967131_tiny.mp4"
    private const val PX_ESFINGE    = "https://cdn.pixabay.com/video/2021/06/13/77540-562572367_tiny.mp4"
    private const val PX_TEMPLO     = "https://cdn.pixabay.com/video/2024/05/13/211847_tiny.mp4"
    private const val PX_HIEROGLYPH = "https://cdn.pixabay.com/video/2019/04/26/23073-332665413_tiny.mp4"
    private const val PX_MOMIA      = "https://cdn.pixabay.com/video/2024/05/13/211846_tiny.mp4"
    private const val PX_FARAON2    = "https://cdn.pixabay.com/video/2024/06/06/215544_tiny.mp4"
    private const val PX_CAIRO      = "https://cdn.pixabay.com/video/2015/12/04/1565-148219771_tiny.mp4"

    private val vidaCotidianaVideos = listOf(
        VideoItem("vc_vid_1", "Vida en el Antiguo Egipto",      WK_EGYPT,    "Animacion del Antiguo Egipto"),
        VideoItem("vc_vid_2", "Nueva capital de Egipto",        WK_CAPITAL,  "Construccion de la nueva capital"),
        VideoItem("vc_vid_3", "Un dia con el faraon",           PX_FARAON,   "Vida cotidiana bajo los faraones"),
        VideoItem("vc_vid_4", "Caravanas en el desierto",       PX_CAMELLO,  "Camellos y comercio en el desierto"),
        VideoItem("vc_vid_5", "Dioses y rituales de Egipto",    PX_ANUBIS,   "Anubis y la religion egipcia")
    )
    private val arquitecturaVideos = listOf(
        VideoItem("arq_vid_1", "Animacion del Antiguo Egipto",  WK_EGYPT,    "Arte y arquitectura del Antiguo Egipto"),
        VideoItem("arq_vid_2", "Las Piramides de Giza",         PX_PIRAMIDE, "Las maravillas de Giza"),
        VideoItem("arq_vid_3", "La Gran Esfinge",               PX_ESFINGE,  "Guardian de la meseta de Giza"),
        VideoItem("arq_vid_4", "Templos del Nilo",              PX_TEMPLO,   "Los grandes templos egipcios"),
        VideoItem("arq_vid_5", "El Cairo: ciudad faraonica",    PX_CAIRO,    "La capital historica de Egipto")
    )
    private val arteVideos = listOf(
        VideoItem("art_vid_1", "Arte del Antiguo Egipto",        WK_EGYPT,     "Animacion sobre el arte egipcio"),
        VideoItem("art_vid_2", "Jeroglificos: escritura sagrada", PX_HIEROGLYPH,"El sistema de escritura de Egipto"),
        VideoItem("art_vid_3", "El faraon en el arte egipcio",   PX_FARAON2,   "Representacion del faraon"),
        VideoItem("art_vid_4", "Momias y arte funerario",        PX_MOMIA,     "El arte de preservar para la eternidad"),
        VideoItem("art_vid_5", "Nueva Egipto: arte y ciudad",    WK_CAPITAL,   "La nueva capital egipcia")
    )

    fun getImageUrls(sectionId: String) = when(sectionId) { "vida_cotidiana"->imageUrlsVidaCotidiana; "arquitectura"->imageUrlsArquitectura; "arte"->imageUrlsArte; else->emptyList() }
    fun getImages(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaImages; "arquitectura"->arquitecturaImages; "arte"->arteImages; else->emptyList() }
    fun getAudios(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaAudios; "arquitectura"->arquitecturaAudios; "arte"->arteAudios; else->emptyList() }
    fun getVideos(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaVideos; "arquitectura"->arquitecturaVideos; "arte"->arteVideos; else->emptyList() }
    fun getImageDescription(sectionId: String, index: Int) = getImages(sectionId).getOrNull(index)?.contentDescription ?: "Imagen del museo"
}
