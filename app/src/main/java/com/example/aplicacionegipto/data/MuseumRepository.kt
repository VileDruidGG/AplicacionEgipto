package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    // === VIDA COTIDIANA: modelos de barcos, objetos domesticos, vida diaria ===
    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Barco de remos del Nilo","Modelo de barco navegando rio abajo con remeros, tumba de Meketre"),
        MuseumImage("vc2","vc2","Segundo barco de viaje","Modelo de barco de viaje con tripulacion egipcia"),
        MuseumImage("vc3","vc3","Barco de cocina","Barco cocina con sirvientes preparando alimentos para el viaje"),
        MuseumImage("vc4","vc4","Sirviente portando ofrendas","Figura de sirviente de la tumba de Meketre cargando provisiones"),
        MuseumImage("vc5","vc5","Barco deportivo","Modelo de barco para pesca y caza en los pantanos del Nilo"),
        MuseumImage("vc6","vc6","Silla de Hatnefer","Silla de madera de la madre de Senenmut, mobiliario domestico egipcio"),
        MuseumImage("vc7","vc7","Hipopotamo William","Figurilla de fayenza azul decorada con lotos, mascota del Met Museum"),
        MuseumImage("vc8","vc8","Barco con remos","Modelo de barco de remos con tripulacion completa"),
        MuseumImage("vc9","vc9","Collar menat ceremonial","Collar menat de fayenza usado en ceremonias religiosas cotidianas"),
        MuseumImage("vc10","vc10","Shabti de Senebimi","Figurilla ushabti que servia al difunto en el mas alla")
    )

    // === ARQUITECTURA: templos, estatuas monumentales, sarcofagos, estructuras ===
    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Templo de Dendur","Templo egipcio completo reconstruido en el Metropolitan Museum"),
        MuseumImage("ar2","ar2","Pedestal del Rey Khafre","Soporte de piedra con el nombre del constructor de la segunda piramide"),
        MuseumImage("ar3","ar3","Estatua de Hatshepsut arrodillada","Gran estatua de granito de la faraona ofreciendo a los dioses"),
        MuseumImage("ar4","ar4","Sarcofago de Harkhebit","Sarcofago monumental de un alto oficial de la Dinastia 26"),
        MuseumImage("ar5","ar5","Estatua del Rey Menkaure","Estatua sedente del constructor de la tercera piramide de Giza"),
        MuseumImage("ar6","ar6","Sarcofago de Khnumhotep","Sarcofago decorado del Reino Medio con jeroglificos y ojos wedjat"),
        MuseumImage("ar7","ar7","Hatshepsut sentada como faraon","Estatua de Hatshepsut con atributos reales completos"),
        MuseumImage("ar8","ar8","Hatshepsut como mujer faraon","Estatua que muestra a Hatshepsut con vestimenta femenina y corona"),
        MuseumImage("ar9","ar9","Mujer nubia","Figura femenina de Nubia, region al sur de Egipto"),
        MuseumImage("ar10","ar10","Anfora azul decorada","Anfora con decoracion de ibex pintada en azul de Malqata")
    )

    // === ARTE: esfinges, mascaras, joyas, sarcofagos decorados, escarabajos ===
    private val arteImages = listOf(
        MuseumImage("at1","at1","Esfinge de Senwosret III","Esfinge de gneis con rostro realista del faraon del Reino Medio"),
        MuseumImage("at2","at2","Esfinge de Hatshepsut","Gran esfinge colosal de granito de la faraona Hatshepsut"),
        MuseumImage("at3","at3","Esfinge azul de Amenhotep III","Esfinge de fayenza azul unica con manos humanas"),
        MuseumImage("at4","at4","Mascara funeraria dorada","Mascara de oro de Hatnefer con ojos de obsidiana y alabastro"),
        MuseumImage("at5","at5","Sarcofago de Henettawy","Sarcofago pintado de la cantora de Amun-Ra con escenas del Mas Alla"),
        MuseumImage("at6","at6","Sarcofago de Ukhhotep","Sarcofago decorado del tesorero real con jeroglificos"),
        MuseumImage("at7","at7","Escarabajo del corazon","Escarabajo de oro de Hatnefer con hechizo del Libro de los Muertos"),
        MuseumImage("at8","at8","Santuario de Amenemhat","Santuario con estatuas del funcionario Amenemhat y su familia"),
        MuseumImage("at9","at9","Pectoral de Sithathoryunet","Pectoral de oro con nombre de Senwosret II, joyeria real"),
        MuseumImage("at10","at10","Estatua sedente Hatshepsut","Hatshepsut representada como faraon con nemes y barba postiza")
    )

    // === URLs IIIF del Met Museum (extraidas con Chrome del HTML de metmuseum.org) ===
    // Formato: collectionapi.metmuseum.org/api/collection/v1/iiif/{objectID}/{imageID}/main-image

    val imageUrlsVidaCotidiana = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544214/1216906/main-image",  // Barco remos Meketre
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544213/1220799/main-image",  // Barco viaje #2
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544212/1220804/main-image",  // Barco cocina Meketre
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544210/1216908/main-image",  // Sirviente ofrendas
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544126/1428412/main-image",  // Barco deportivo
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543868/1172779/main-image",  // Silla Hatnefer
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544227/1216904/main-image",  // Hipopotamo William
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544211/1475247/main-image",  // Barco con remos
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544509/1210644/main-image",  // Collar menat
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544340/1450850/main-image"   // Shabti Senebimi
    )

    val imageUrlsArquitectura = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/547802/1223802/main-image",  // Templo Dendur
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543910/1172813/main-image",  // Pedestal Khafre
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544449/1179859/main-image",  // Hatshepsut arrodillada
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548211/1220671/main-image",  // Sarcofago Harkhebit
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543935/1085207/main-image",  // Rey Menkaure
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544323/1448856/main-image",  // Sarcofago Khnumhotep
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544450/2105723/main-image",  // Hatshepsut sentada
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544849/1151822/main-image",  // Hatshepsut faraona
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544218/1297278/main-image",  // Mujer nubia
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544501/1180326/main-image"   // Anfora azul
    )

    val imageUrlsArte = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",  // Esfinge Senwosret
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106258/main-image",  // Esfinge Hatshepsut
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1151827/main-image",  // Esfinge Amenhotep
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545147/1086200/main-image",  // Mascara Hatnefer
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1359380/main-image",  // Sarcofago Henettawy
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/546303/1212836/main-image",  // Sarcofago Ukhhotep
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545146/1223831/main-image",  // Escarabajo Hatnefer
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544166/1369337/main-image",  // Santuario Amenemhat
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544166/1369337/main-image",  // Pectoral (placeholder)
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544450/2105723/main-image"   // Hatshepsut sedente
    )

    private val vidaCotidianaAudios = listOf(
        AudioItem("vc_aud_1","Sonidos del mercado","vc_mercado",AudioType.AMBIENT,"Ambiente de mercado"),
        AudioItem("vc_aud_2","Vida junto al Nilo","vc_nilo_narracion",AudioType.NARRATION,"Vida diaria"),
        AudioItem("vc_aud_3","Arpa egipcia","vc_arpa_egipcia",AudioType.MUSIC,"Melodia de arpa"),
        AudioItem("vc_aud_4","Cantos de trabajo","vc_cantos_trabajo",AudioType.AMBIENT,"Canticos"),
        AudioItem("vc_aud_5","Cocina del faraon","vc_cocina_narracion",AudioType.NARRATION,"Gastronomia")
    )
    private val arquitecturaAudios = listOf(
        AudioItem("arq_aud_1","Ecos en la Piramide","arq_ecos_piramide",AudioType.AMBIENT,"Ecos"),
        AudioItem("arq_aud_2","Construccion","arq_construccion_narracion",AudioType.NARRATION,"Tecnicas"),
        AudioItem("arq_aud_3","Himnos de Karnak","arq_himnos_karnak",AudioType.MUSIC,"Himnos"),
        AudioItem("arq_aud_4","Viento del desierto","arq_viento_desierto",AudioType.AMBIENT,"Viento"),
        AudioItem("arq_aud_5","Secretos Esfinge","arq_esfinge_narracion",AudioType.NARRATION,"Misterios")
    )
    private val arteAudios = listOf(
        AudioItem("art_aud_1","Taller escultor","art_taller_escultor",AudioType.AMBIENT,"Cincel"),
        AudioItem("art_aud_2","Jeroglificos","art_jeroglificos_narracion",AudioType.NARRATION,"Escritura"),
        AudioItem("art_aud_3","Musica Osiris","art_musica_osiris",AudioType.MUSIC,"Ritual"),
        AudioItem("art_aud_4","Pigmentos","art_pigmentos",AudioType.AMBIENT,"Preparacion"),
        AudioItem("art_aud_5","Tutankamon","art_tutankamon_narracion",AudioType.NARRATION,"Mascara")
    )

    private const val HLS_TEARS = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    private const val HLS_APPLE = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_fmp4/master.m3u8"
    private const val HLS_AKAMAI = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
    private const val HLS_BLENDER = "https://ireplay.tv/test/blender.m3u8"

    private val vidaCotidianaVideos = listOf(
        VideoItem("vc_vid_1","Un dia en Egipto",HLS_TEARS,"Vida de un artesano"),
        VideoItem("vc_vid_2","Alimentacion",HLS_APPLE,"Culinaria egipcia"),
        VideoItem("vc_vid_3","Fiestas",HLS_AKAMAI,"Festividades"),
        VideoItem("vc_vid_4","Rol de la mujer",HLS_BLENDER,"Sociedad egipcia"),
        VideoItem("vc_vid_5","Oficios",HLS_TEARS,"Escribas y artesanos")
    )
    private val arquitecturaVideos = listOf(
        VideoItem("arq_vid_1","Piramides",HLS_TEARS,"Construccion"),
        VideoItem("arq_vid_2","Templos",HLS_APPLE,"Recorrido"),
        VideoItem("arq_vid_3","Ingenieria",HLS_AKAMAI,"Innovaciones"),
        VideoItem("arq_vid_4","Abu Simbel",HLS_BLENDER,"Traslado"),
        VideoItem("arq_vid_5","Tutankamon",HLS_TEARS,"Descubrimiento")
    )
    private val arteVideos = listOf(
        VideoItem("art_vid_1","Jeroglificos",HLS_TEARS,"Piedra Rosetta"),
        VideoItem("art_vid_2","Colores",HLS_APPLE,"Pigmentos"),
        VideoItem("art_vid_3","Tesoros",HLS_AKAMAI,"Tumba"),
        VideoItem("art_vid_4","Momificacion",HLS_BLENDER,"Proceso ritual"),
        VideoItem("art_vid_5","Escultura",HLS_TEARS,"Colosos")
    )

    fun getImageUrls(sectionId: String) = when(sectionId) { "vida_cotidiana"->imageUrlsVidaCotidiana; "arquitectura"->imageUrlsArquitectura; "arte"->imageUrlsArte; else->emptyList() }
    fun getImages(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaImages; "arquitectura"->arquitecturaImages; "arte"->arteImages; else->emptyList() }
    fun getAudios(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaAudios; "arquitectura"->arquitecturaAudios; "arte"->arteAudios; else->emptyList() }
    fun getVideos(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaVideos; "arquitectura"->arquitecturaVideos; "arte"->arteVideos; else->emptyList() }
    fun getImageDescription(sectionId: String, index: Int) = getImages(sectionId).getOrNull(index)?.contentDescription ?: "Imagen del museo"
}
