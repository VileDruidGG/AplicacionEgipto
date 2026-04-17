package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    // === VIDA COTIDIANA ===
    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Panaderia y cerveceria","Modelo de taller de pan y cerveza de la tumba de Meketre"),
        MuseumImage("vc2","vc2","Barco de cocina","Barco con cocineros preparando pan y cerveza para el viaje"),
        MuseumImage("vc3","vc3","Estatuilla de Lady Tiye","Mujer noble egipcia con vestido de lino y peluca elaborada"),
        MuseumImage("vc4","vc4","Pectoral de Sithathoryunet","Pectoral de oro y piedras semipreciosas de una princesa real"),
        MuseumImage("vc5","vc5","Nikare con esposa e hija","Grupo familiar egipcio: padre, madre e hija juntos"),
        MuseumImage("vc6","vc6","Yuny y su esposa Renenutet","Pareja egipcia abrazada, simbolo de amor conyugal"),
        MuseumImage("vc7","vc7","Juego Hounds and Jackals","Tablero de juego de marfil y ebano encontrado en tumba real"),
        MuseumImage("vc8","vc8","Caja cosmetica con tapa","Caja de cosmeticos con tapa giratoria para maquillaje y unguentos"),
        MuseumImage("vc9","vc9","Estela magica de Horus","Estela con Horus nino para proteccion magica contra enfermedades"),
        MuseumImage("vc10","vc10","Isis con Horus bebe","Diosa Isis amamantando a Horus, simbolo de proteccion maternal")
    )

    // === ARQUITECTURA ===
    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Templo de Dendur","Templo egipcio completo reconstruido en el Metropolitan Museum"),
        MuseumImage("ar2","ar2","Estatua Rey Menkaure","Estatua sedente del constructor de la tercera piramide de Giza"),
        MuseumImage("ar3","ar3","Pedestal del Rey Khafre","Soporte con nombre del constructor de la segunda piramide"),
        MuseumImage("ar4","ar4","Esfinge de Hatshepsut","Esfinge colosal de granito de la faraona Hatshepsut"),
        MuseumImage("ar5","ar5","Esfinge de Senwosret III","Esfinge de gneis del Reino Medio con rasgos realistas"),
        MuseumImage("ar6","ar6","Esfinge de Amenhotep III","Esfinge unica de fayenza azul con manos humanas"),
        MuseumImage("ar7","ar7","Sarcofago de Harkhebit","Sarcofago monumental de un alto oficial de la Dinastia 26"),
        MuseumImage("ar8","ar8","Sarcofago de Khnumhotep","Sarcofago del Reino Medio con ojos wedjat pintados"),
        MuseumImage("ar9","ar9","Hatshepsut arrodillada","Gran estatua de Hatshepsut ofreciendo vasijas a los dioses"),
        MuseumImage("ar10","ar10","Hatshepsut sentada","Estatua de la faraona con atributos reales completos")
    )

    // === ARTE ===
    private val arteImages = listOf(
        MuseumImage("at1","at1","Santuario con jeroglificos","Santuario de Amenemhat con jeroglificos tallados en piedra"),
        MuseumImage("at2","at2","Pintura mural del gato","Pintura de gato matando serpiente de la tumba de Sennedjem"),
        MuseumImage("at3","at3","Hatshepsut como faraona","Escultura de Hatshepsut con vestimenta femenina y corona real"),
        MuseumImage("at4","at4","Mascara funeraria dorada","Mascara de oro de Hatnefer con ojos de obsidiana y alabastro"),
        MuseumImage("at5","at5","Sarcofago pintado Henettawy","Sarcofago con pinturas elaboradas de la cantora de Amun-Ra"),
        MuseumImage("at6","at6","Sarcofago decorado Ukhhotep","Sarcofago del tesorero real con escenas del Mas Alla"),
        MuseumImage("at7","at7","Escarabajo corazon de oro","Escarabajo de Hatnefer con hechizo del Libro de los Muertos"),
        MuseumImage("at8","at8","Esfinge Senwosret III","Obra maestra de escultura del Reino Medio tallada en gneis"),
        MuseumImage("at9","at9","Sarcofago Khnumhotep","Sarcofago decorado con jeroglificos y ojos wedjat"),
        MuseumImage("at10","at10","Mujer nubia","Figura femenina de Nubia mostrando la diversidad cultural")
    )

    // === URLs IIIF del Met Museum (imageIDs extraidos con Chrome MCP de metmuseum.org) ===

    val imageUrlsVidaCotidiana = listOf(
        // Art.1 Alimentacion y cocina
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544258/1178720/main-image",  // Panaderia/cerveceria Meketre
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544212/1220804/main-image",  // Barco cocina Meketre
        // Art.2 Vestimenta y joyeria
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544524/1793037/main-image",  // Lady Tiye con vestido y peluca
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544232/1151819/main-image",  // Pectoral joya princesa Sithathoryunet
        // Art.3 La familia egipcia
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543901/1214210/main-image",  // Nikare con esposa e hija
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544740/1151839/main-image",  // Yuny y esposa Renenutet
        // Art.4 Juegos y entretenimiento
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543867/1221835/main-image",  // Juego Hounds & Jackals
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/547031/1084353/main-image",  // Caja cosmetica con tapa giratoria
        // Art.5 Medicina y salud
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/546037/2306456/main-image",  // Estela magica Horus nino
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548310/1214471/main-image"   // Isis con Horus bebe
    )

    val imageUrlsArquitectura = listOf(
        // Art.1 Las Grandes Piramides
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/547802/1223802/main-image",  // Templo Dendur
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543935/1085207/main-image",  // Rey Menkaure
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/543910/1172813/main-image",  // Pedestal Khafre
        // Art.3 La Gran Esfinge
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106258/main-image",  // Esfinge Hatshepsut
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",  // Esfinge Senwosret
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1151827/main-image",  // Esfinge Amenhotep
        // Art.4 Valle de los Reyes
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548211/1220671/main-image",  // Sarcofago Harkhebit
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544323/1448856/main-image",  // Sarcofago Khnumhotep
        // Art.5 Obeliscos
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544449/1179859/main-image",  // Hatshepsut arrodillada
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544450/2105723/main-image"   // Hatshepsut sentada
    )

    val imageUrlsArte = listOf(
        // Art.1 Jeroglificos
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544166/1369337/main-image",  // Santuario jeroglificos
        // Art.2 Pintura mural
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548564/2311333/main-image",  // Pintura gato mata serpiente
        // Art.3 Escultura
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544849/1151822/main-image",  // Hatshepsut escultura
        // Art.4 Mascara de Tutankamon
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545147/1086200/main-image",  // Mascara Hatnefer
        // Art.5 Arte funerario
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1359380/main-image",  // Sarcofago Henettawy
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/546303/1212836/main-image",  // Sarcofago Ukhhotep
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545146/1223831/main-image",  // Escarabajo corazon
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",  // Esfinge Senwosret (escultura)
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544323/1448856/main-image",  // Sarcofago Khnumhotep
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544218/1297278/main-image"   // Mujer nubia
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
