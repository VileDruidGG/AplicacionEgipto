package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    // === VIDA COTIDIANA: imagenes que corresponden a cada articulo ===
    // Art.1 Alimentacion y cocina | Art.2 Vestimenta y joyeria | Art.3 Familia
    // Art.4 Juegos y entretenimiento | Art.5 Medicina y salud
    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Panaderia y cerveceria","Modelo de panaderia y cerveceria de la tumba de Meketre"),
        MuseumImage("vc2","vc2","Barco de cocina","Barco con cocineros preparando pan y cerveza para el viaje"),
        MuseumImage("vc3","vc3","Collar menat ceremonial","Collar menat de fayenza usado en ceremonias religiosas"),
        MuseumImage("vc4","vc4","Silla de Hatnefer","Silla de madera del ajuar domestico de una noble egipcia"),
        MuseumImage("vc5","vc5","Portadora de ofrendas","Figura femenina portando canasta con pan y patos"),
        MuseumImage("vc6","vc6","Familia en procesion","Procesion funeraria con hijos de Meketre portando ofrendas"),
        MuseumImage("vc7","vc7","Hipopotamo William","Figurilla de fayenza azul con lotos, amuleto protector"),
        MuseumImage("vc8","vc8","Barco deportivo","Modelo de barco para caza y pesca en los pantanos del Nilo"),
        MuseumImage("vc9","vc9","Granero con escribas","Modelo de granero con escribas contando y midiendo grano"),
        MuseumImage("vc10","vc10","Shabti funerario","Figurilla ushabti que servia al difunto en el mas alla")
    )

    // === ARQUITECTURA: templos, piramides, esfinges, tumbas, obeliscos ===
    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Templo de Dendur","Templo egipcio completo reconstruido en el Metropolitan Museum"),
        MuseumImage("ar2","ar2","Estatua Rey Menkaure","Estatua sedente del constructor de la tercera piramide de Giza"),
        MuseumImage("ar3","ar3","Pedestal del Rey Khafre","Soporte con nombre del constructor de la segunda piramide"),
        MuseumImage("ar4","ar4","Esfinge de Hatshepsut","Esfinge colosal de granito de la faraona Hatshepsut"),
        MuseumImage("ar5","ar5","Esfinge de Senwosret III","Esfinge de gneis del Reino Medio con rasgos realistas"),
        MuseumImage("ar6","ar6","Esfinge de Amenhotep III","Esfinge unica de fayenza azul con manos humanas"),
        MuseumImage("ar7","ar7","Sarcofago de Harkhebit","Sarcofago monumental de un alto oficial de la Dinastia 26"),
        MuseumImage("ar8","ar8","Sarcofago de Khnumhotep","Sarcofago del Reino Medio con ojos wedjat pintados"),
        MuseumImage("ar9","ar9","Hatshepsut arrodillada","Gran estatua de Hatshepsut ofreciendo a los dioses"),
        MuseumImage("ar10","ar10","Hatshepsut sentada","Estatua de la faraona con atributos reales completos")
    )

    // === ARTE: escultura, mascaras, joyas, sarcofagos pintados, escarabajos ===
    private val arteImages = listOf(
        MuseumImage("at1","at1","Santuario con jeroglificos","Santuario de Amenemhat tallado con jeroglificos"),
        MuseumImage("at2","at2","Portadora de ofrendas pintada","Figura de madera pintada con colores originales vibrantes"),
        MuseumImage("at3","at3","Esfinge Senwosret escultura","Obra maestra de escultura del Reino Medio en gneis"),
        MuseumImage("at4","at4","Mascara funeraria dorada","Mascara de oro de Hatnefer con ojos de obsidiana"),
        MuseumImage("at5","at5","Sarcofago pintado Henettawy","Sarcofago con pinturas elaboradas de la cantora de Amun"),
        MuseumImage("at6","at6","Sarcofago decorado Ukhhotep","Sarcofago del tesorero real con escenas del Mas Alla"),
        MuseumImage("at7","at7","Escarabajo corazon de oro","Escarabajo con hechizo del Libro de los Muertos"),
        MuseumImage("at8","at8","Hatshepsut como faraona","Estatua que muestra a Hatshepsut con vestimenta femenina"),
        MuseumImage("at9","at9","Sarcofago Khnumhotep pintado","Sarcofago con jeroglificos y decoracion funeraria"),
        MuseumImage("at10","at10","Mujer nubia","Figura femenina de Nubia mostrando la diversidad del imperio")
    )

    // === URLs IIIF verificadas (extraidas con Chrome de metmuseum.org) ===
    // Cada imagen corresponde tematicamente a los articulos de su seccion

    val imageUrlsVidaCotidiana = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544258/1178720/main-image",  // Panaderia/cerveceria Meketre -> Art.1 Alimentacion
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544212/1220804/main-image",  // Barco cocina Meketre -> Art.1 Alimentacion
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544509/1210644/main-image",  // Collar menat -> Art.2 Vestimenta/joyeria
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543868/1172779/main-image",  // Silla Hatnefer -> Art.2 Vestimenta (ajuar)
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544210/1216908/main-image",  // Portadora ofrendas -> Art.3 Familia
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544125/1428405/main-image",  // Procesion funeraria -> Art.3 Familia
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544227/1216904/main-image",  // Hipopotamo William -> Art.4 Juegos
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544126/1428412/main-image",  // Barco deportivo -> Art.4 Entretenimiento
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545281/1467010/main-image",  // Granero con escribas -> Art.5 Medicina/salud
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544340/1450850/main-image"   // Shabti -> Art.5 Salud/mas alla
    )

    val imageUrlsArquitectura = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/547802/1223802/main-image",  // Templo Dendur -> Art.1 Piramides/templos
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543935/1085207/main-image",  // Rey Menkaure -> Art.1 Piramides
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543910/1172813/main-image",  // Pedestal Khafre -> Art.1 Piramides
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106258/main-image",  // Esfinge Hatshepsut -> Art.3 Esfinge
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",  // Esfinge Senwosret -> Art.3 Esfinge
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1151827/main-image",  // Esfinge Amenhotep -> Art.3 Esfinge
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548211/1220671/main-image",  // Sarcofago Harkhebit -> Art.4 Valle Reyes
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544323/1448856/main-image",  // Sarcofago Khnumhotep -> Art.4 Valle Reyes
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544449/1179859/main-image",  // Hatshepsut arrodillada -> Art.5 Obeliscos
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544450/2105723/main-image"   // Hatshepsut sentada -> Art.5 Obeliscos
    )

    val imageUrlsArte = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544166/1369337/main-image",  // Santuario jeroglificos -> Art.1 Jeroglificos
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544210/1216908/main-image",  // Portadora pintada -> Art.2 Pintura
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",  // Esfinge Senwosret -> Art.3 Escultura
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545147/1086200/main-image",  // Mascara Hatnefer -> Art.4 Mascara
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1359380/main-image",  // Sarcofago Henettawy -> Art.5 Funerario
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/546303/1212836/main-image",  // Sarcofago Ukhhotep -> Art.5 Funerario
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545146/1223831/main-image",  // Escarabajo corazon -> Art.4 Mascara/joyas
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544849/1151822/main-image",  // Hatshepsut faraona -> Art.3 Escultura
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544323/1448856/main-image",  // Sarcofago pintado -> Art.5 Funerario
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544218/1297278/main-image"   // Mujer nubia -> Art.2 Pintura
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
