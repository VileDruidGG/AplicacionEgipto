package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Modelo de barco del Nilo","Barco de madera pintada de la tumba de Meketre navegando el Nilo"),
        MuseumImage("vc2","vc2","Modelo de jardin","Jardin en miniatura con arboles de la tumba de Meketre"),
        MuseumImage("vc3","vc3","Esfinge de Senwosret III","Esfinge del faraon Senwosret III en gneis"),
        MuseumImage("vc4","vc4","Esfinge azul de Amenhotep","Esfinge de fayenza azul del faraon Amenhotep III"),
        MuseumImage("vc5","vc5","Escriba sentado","Estatua de escriba sentado con papiro desplegado"),
        MuseumImage("vc6","vc6","Tumba de Perneb","Capilla funeraria de la mastaba de Perneb"),
        MuseumImage("vc7","vc7","Modelo de panaderia","Modelo de madera mostrando fabricacion de pan y cerveza"),
        MuseumImage("vc8","vc8","Collar de princesa","Pectoral de oro de la princesa Sithathoryunet"),
        MuseumImage("vc9","vc9","Cabeza de faraon","Cabeza de estatua real del Reino Medio"),
        MuseumImage("vc10","vc10","Hipopotamo William","Figurilla de hipopotamo de fayenza azul, mascota del Met")
    )
    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Piramides de Giza","Las tres Grandes Piramides de Giza"),
        MuseumImage("ar2","ar2","Templo de Karnak","Columnas de la Sala Hipostila de Karnak"),
        MuseumImage("ar3","ar3","Gran Esfinge de Giza","Esfinge con piramide de Khafre de fondo"),
        MuseumImage("ar4","ar4","Templo de Dendur","Templo egipcio completo en el Metropolitan Museum"),
        MuseumImage("ar5","ar5","Abu Simbel","Colosos de Ramses II tallados en la roca"),
        MuseumImage("ar6","ar6","Templo de Luxor","Fachada del Templo de Luxor al anochecer"),
        MuseumImage("ar7","ar7","Valle de los Reyes","Entrada al Valle de los Reyes en Tebas"),
        MuseumImage("ar8","ar8","Templo de Filae","Templo de Isis reflejado en las aguas del Nilo"),
        MuseumImage("ar9","ar9","Esfinge de Hatshepsut","Esfinge colosal de la faraona Hatshepsut"),
        MuseumImage("ar10","ar10","Estatua de Hatshepsut","Gran estatua arrodillada de Hatshepsut")
    )
    private val arteImages = listOf(
        MuseumImage("at1","at1","Esfinge de Senwosret detalle","Detalle del rostro de la esfinge de Senwosret III"),
        MuseumImage("at2","at2","Pintura de Nefertari","Reina Nefertari en su tumba del Valle de las Reinas"),
        MuseumImage("at3","at3","Busto de Nefertiti","Busto policromado de la reina Nefertiti"),
        MuseumImage("at4","at4","Sarcofago de Tutankamon","Sarcofago interior dorado de Tutankamon"),
        MuseumImage("at5","at5","Libro de los Muertos","Papiro del Juicio de Osiris de Hunefer"),
        MuseumImage("at6","at6","Esfinge de Amenhotep detalle","Detalle lateral de la esfinge de fayenza"),
        MuseumImage("at7","at7","Anubis momificacion","Anubis atendiendo la momia de Sennedjem"),
        MuseumImage("at8","at8","Esfinge guardian","Vista posterior de la esfinge de Senwosret III"),
        MuseumImage("at9","at9","Relieve de Medinet Habu","Relieves de batalla del templo de Ramses III"),
        MuseumImage("at10","at10","Esfinge de Hatshepsut perfil","Vista lateral de la esfinge de Hatshepsut")
    )

    // === URLS VERIFICADAS ===
    // Met Museum IIIF API (mismo CDN que usa metmuseum.org, siempre funciona)
    // Formato: collectionapi.metmuseum.org/api/collection/v1/iiif/{objectID}/{imageID}/main-image
    // Met Museum web-additional (imagenes extra de alta calidad)
    // Formato: images.metmuseum.org/CRDImages/eg/web-additional/{filename}.jpg
    // Wikimedia Commons (fotos de monumentos, dominio publico)

    val imageUrlsVidaCotidiana = listOf(
        // Met IIIF - objetos de vida cotidiana del antiguo Egipto
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",   // Esfinge Senwosret III
        "https://images.metmuseum.org/CRDImages/eg/web-additional/DP247658.jpg",                   // Esfinge Senwosret detalle
        "https://images.metmuseum.org/CRDImages/eg/web-additional/DP248998.jpg",                   // Esfinge Senwosret lateral
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106258/main-image",   // Esfinge Hatshepsut
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106256/main-image",   // Esfinge Hatshepsut lateral
        "https://images.metmuseum.org/CRDImages/eg/web-additional/LC-17_9_2_EGDP026313.jpg",      // Senwosret frontal
        "https://images.metmuseum.org/CRDImages/eg/web-additional/LC-17_9_2_EGDP026312.jpg",      // Senwosret angulo
        "https://images.metmuseum.org/CRDImages/eg/web-additional/DP157707.jpg",                   // Senwosret primer plano
        "https://images.metmuseum.org/CRDImages/eg/web-additional/DP323880.jpg",                   // Senwosret detalle mane
        "https://images.metmuseum.org/CRDImages/eg/web-additional/DP323878.jpg"                    // Senwosret vista trasera
    )

    val imageUrlsArquitectura = listOf(
        // Wikimedia - monumentos egipcios (fotos de exteriores, siempre disponibles)
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Kheops-Pyramid.jpg/640px-Kheops-Pyramid.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Great_Sphinx_of_Giza_-_20080716a.jpg/640px-Great_Sphinx_of_Giza_-_20080716a.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/ValleyOfTheKings_2007.jpg/640px-ValleyOfTheKings_2007.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Philae_Temple_R01.jpg/640px-Philae_Temple_R01.jpg",
        // Met IIIF - esfinges y estatuas arquitectonicas
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106259/main-image",   // Hatshepsut esfinge angulo
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106260/main-image",   // Hatshepsut esfinge detalle
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106257/main-image",   // Hatshepsut esfinge superior
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106255/main-image",   // Hatshepsut esfinge cara
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/1228544/main-image",   // Hatshepsut esfinge historica
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/1228545/main-image"    // Hatshepsut esfinge excavacion
    )

    val imageUrlsArte = listOf(
        // Met IIIF + web-additional - arte egipcio
        "https://images.metmuseum.org/CRDImages/eg/web-additional/LC-17_9_2_EGDP026315.jpg",      // Senwosret escultura detalle
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Maler_der_Grabkammer_der_Nefertari_001.jpg/480px-Maler_der_Grabkammer_der_Nefertari_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Nofretete_Neues_Museum.jpg/360px-Nofretete_Neues_Museum.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Innerster_Sarg_des_Tutanchamun.jpg/320px-Innerster_Sarg_des_Tutanchamun.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Book_of_the_Dead_of_Hunefer_sheet_3.jpg/640px-Book_of_the_Dead_of_Hunefer_sheet_3.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-additional/LC-17_9_2_EGDP026314.jpg",      // Senwosret arte detalle
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Anubis_attending_the_mummy_of_Sennedjem.jpg/480px-Anubis_attending_the_mummy_of_Sennedjem.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-additional/LC-17_9_2_EGDP026316.jpg",      // Senwosret arte angulo
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Medinet_Habu_Ramses_III._Tempel_30.jpg/640px-Medinet_Habu_Ramses_III._Tempel_30.jpg",
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/1151968/main-image"    // Hatshepsut esfinge restaurada
    )

    private val vidaCotidianaAudios = listOf(
        AudioItem("vc_aud_1","Sonidos del mercado","vc_mercado",AudioType.AMBIENT,"Ambiente de mercado egipcio"),
        AudioItem("vc_aud_2","Vida junto al Nilo","vc_nilo_narracion",AudioType.NARRATION,"Narracion sobre vida diaria"),
        AudioItem("vc_aud_3","Arpa egipcia","vc_arpa_egipcia",AudioType.MUSIC,"Melodia de arpa egipcia"),
        AudioItem("vc_aud_4","Cantos de trabajo","vc_cantos_trabajo",AudioType.AMBIENT,"Canticos de trabajadores"),
        AudioItem("vc_aud_5","Cocina del faraon","vc_cocina_narracion",AudioType.NARRATION,"Gastronomia de la corte")
    )
    private val arquitecturaAudios = listOf(
        AudioItem("arq_aud_1","Ecos en la Piramide","arq_ecos_piramide",AudioType.AMBIENT,"Ecos dentro de la piramide"),
        AudioItem("arq_aud_2","Construccion","arq_construccion_narracion",AudioType.NARRATION,"Tecnicas de construccion"),
        AudioItem("arq_aud_3","Himnos de Karnak","arq_himnos_karnak",AudioType.MUSIC,"Himnos ceremoniales"),
        AudioItem("arq_aud_4","Viento del desierto","arq_viento_desierto",AudioType.AMBIENT,"Viento del Sahara"),
        AudioItem("arq_aud_5","Secretos de la Esfinge","arq_esfinge_narracion",AudioType.NARRATION,"Misterios de la Esfinge")
    )
    private val arteAudios = listOf(
        AudioItem("art_aud_1","Taller del escultor","art_taller_escultor",AudioType.AMBIENT,"Cincel sobre piedra"),
        AudioItem("art_aud_2","Jeroglificos","art_jeroglificos_narracion",AudioType.NARRATION,"Escritura jeroglifica"),
        AudioItem("art_aud_3","Musica de Osiris","art_musica_osiris",AudioType.MUSIC,"Musica funeraria"),
        AudioItem("art_aud_4","Pigmentos","art_pigmentos",AudioType.AMBIENT,"Preparacion de pigmentos"),
        AudioItem("art_aud_5","Tutankamon","art_tutankamon_narracion",AudioType.NARRATION,"La mascara dorada")
    )

    private const val HLS_TEARS = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    private const val HLS_APPLE = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_fmp4/master.m3u8"
    private const val HLS_AKAMAI = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
    private const val HLS_BLENDER = "https://ireplay.tv/test/blender.m3u8"

    private val vidaCotidianaVideos = listOf(
        VideoItem("vc_vid_1","Un dia en el Antiguo Egipto",HLS_TEARS,"Recrea un dia tipico"),
        VideoItem("vc_vid_2","Alimentacion egipcia",HLS_APPLE,"Alimentos y culinaria"),
        VideoItem("vc_vid_3","Fiestas egipcias",HLS_AKAMAI,"Festividades del calendario"),
        VideoItem("vc_vid_4","Rol de la mujer",HLS_BLENDER,"La mujer en Egipto"),
        VideoItem("vc_vid_5","Oficios egipcios",HLS_TEARS,"Escribas, artesanos, medicos")
    )
    private val arquitecturaVideos = listOf(
        VideoItem("arq_vid_1","Piramides",HLS_TEARS,"Construccion de piramides"),
        VideoItem("arq_vid_2","Templos del Nilo",HLS_APPLE,"Recorrido por templos"),
        VideoItem("arq_vid_3","Ingenieria",HLS_AKAMAI,"Innovaciones tecnicas"),
        VideoItem("arq_vid_4","Abu Simbel",HLS_BLENDER,"Traslado del templo"),
        VideoItem("arq_vid_5","Tutankamon",HLS_TEARS,"Descubrimiento de Carter")
    )
    private val arteVideos = listOf(
        VideoItem("art_vid_1","Jeroglificos",HLS_TEARS,"Champollion y Rosetta"),
        VideoItem("art_vid_2","Colores de Egipto",HLS_APPLE,"Pigmentos y murales"),
        VideoItem("art_vid_3","Tesoros",HLS_AKAMAI,"Joyas de la tumba"),
        VideoItem("art_vid_4","Momificacion",HLS_BLENDER,"Proceso ritual"),
        VideoItem("art_vid_5","Escultura",HLS_TEARS,"Colosos y bustos")
    )

    fun getImageUrls(sectionId: String) = when(sectionId) { "vida_cotidiana"->imageUrlsVidaCotidiana; "arquitectura"->imageUrlsArquitectura; "arte"->imageUrlsArte; else->emptyList() }
    fun getImages(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaImages; "arquitectura"->arquitecturaImages; "arte"->arteImages; else->emptyList() }
    fun getAudios(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaAudios; "arquitectura"->arquitecturaAudios; "arte"->arteAudios; else->emptyList() }
    fun getVideos(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaVideos; "arquitectura"->arquitecturaVideos; "arte"->arteVideos; else->emptyList() }
    fun getImageDescription(sectionId: String, index: Int) = getImages(sectionId).getOrNull(index)?.contentDescription ?: "Imagen del museo"
}
