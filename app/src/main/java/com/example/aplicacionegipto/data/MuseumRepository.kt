package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Banquete egipcio","Pintura mural de banquete con musicos y bailarines"),
        MuseumImage("vc2","vc2","Tumba de Sennedjem","Pinturas murales de la tumba del artesano Sennedjem"),
        MuseumImage("vc3","vc3","El escriba sentado","Estatua de escriba sentado con papiro"),
        MuseumImage("vc4","vc4","Escena de cosecha","Pintura de la tumba de Menna mostrando la cosecha"),
        MuseumImage("vc5","vc5","Artesanos trabajando","Relieve de artesanos en taller egipcio"),
        MuseumImage("vc6","vc6","Pesca en el Nilo","Escena de pesca en la tumba de Menna"),
        MuseumImage("vc7","vc7","Fabricacion de pan","Modelo de panaderia del Antiguo Egipto"),
        MuseumImage("vc8","vc8","Tablero de Senet","Tablero de juego Senet de Amenhotep III"),
        MuseumImage("vc9","vc9","Papiro medico","Papiro Edwin Smith con textos medicos"),
        MuseumImage("vc10","vc10","Modelo de barco","Modelo de barco de madera de la tumba de Meketre")
    )
    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Piramides de Giza","Las tres Grandes Piramides al atardecer"),
        MuseumImage("ar2","ar2","Templo de Karnak","Columnas de la Sala Hipostila de Karnak"),
        MuseumImage("ar3","ar3","Gran Esfinge","La Gran Esfinge de Giza con piramide de fondo"),
        MuseumImage("ar4","ar4","Templo de Dendur","Templo de Dendur en el Metropolitan Museum"),
        MuseumImage("ar5","ar5","Abu Simbel","Fachada del templo de Abu Simbel con colosos"),
        MuseumImage("ar6","ar6","Templo de Luxor","Vista nocturna del Templo de Luxor"),
        MuseumImage("ar7","ar7","Valle de los Reyes","Entrada al Valle de los Reyes en Tebas"),
        MuseumImage("ar8","ar8","Templo de Filae","Templo de Isis en la isla de Filae"),
        MuseumImage("ar9","ar9","Esfinge de Hatshepsut","Esfinge de granito de la faraona Hatshepsut"),
        MuseumImage("ar10","ar10","Estatua de Hatshepsut","Gran estatua arrodillada de Hatshepsut")
    )
    private val arteImages = listOf(
        MuseumImage("at1","at1","Jeroglificos tallados","Panel de jeroglificos en piedra caliza"),
        MuseumImage("at2","at2","Pintura de Nefertari","Reina Nefertari en su tumba"),
        MuseumImage("at3","at3","Busto de Nefertiti","Busto policromado de Nefertiti"),
        MuseumImage("at4","at4","Sarcofago dorado","Sarcofago interior de Tutankamon"),
        MuseumImage("at5","at5","Libro de los Muertos","Papiro del Libro de los Muertos de Hunefer"),
        MuseumImage("at6","at6","Hipopotamo William","Famosa figurilla de hipopotamo azul del Met"),
        MuseumImage("at7","at7","Anubis momificacion","Anubis atendiendo la momia de Sennedjem"),
        MuseumImage("at8","at8","Collar ceremonial","Collar pectoral con halcon y escarabajo"),
        MuseumImage("at9","at9","Relieve del templo","Relieve con jeroglificos del templo de Medinet Habu"),
        MuseumImage("at10","at10","Cofre canopo","Cofre canopo decorado con dioses protectores")
    )

    // === VIDA COTIDIANA === (Met Museum CC0 + Wikimedia verificadas)
    val imageUrlsVidaCotidiana = listOf(
        "https://images.metmuseum.org/CRDImages/eg/web-large/DT11771.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP354789.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP247240.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DT207725.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP116887.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DT10812.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP116866.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP116866.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DT10813.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP116884.jpg"
    )

    // === ARQUITECTURA === (Wikimedia fotos de monumentos + Met Museum)
    val imageUrlsArquitectura = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Kheops-Pyramid.jpg/640px-Kheops-Pyramid.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/S_F-E-CAMERON_2006-10-EGYPT-KARNAK-0177.JPG/640px-S_F-E-CAMERON_2006-10-EGYPT-KARNAK-0177.JPG",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Giza_Sphinx_and_Khafre%27s_pyramid.jpg/640px-Giza_Sphinx_and_Khafre%27s_pyramid.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP116092.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Abu_Simbel%2C_Rates_II%2C_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg/640px-Abu_Simbel%2C_Rates_II%2C_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Luxor_temple_%28Luxor%2C_Egypt%29.jpg/640px-Luxor_temple_%28Luxor%2C_Egypt%29.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/ValleyOfTheKings_2007.jpg/640px-ValleyOfTheKings_2007.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Philae_Temple_R01.jpg/640px-Philae_Temple_R01.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DT7160.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DT218572.jpg"
    )

    // === ARTE === (Met Museum CC0 obras egipcias verificadas)
    val imageUrlsArte = listOf(
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP238621.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Maler_der_Grabkammer_der_Nefertari_001.jpg/480px-Maler_der_Grabkammer_der_Nefertari_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Nofretete_Neues_Museum.jpg/360px-Nofretete_Neues_Museum.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Innerster_Sarg_des_Tutanchamun.jpg/320px-Innerster_Sarg_des_Tutanchamun.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Book_of_the_Dead_of_Hunefer_sheet_3.jpg/640px-Book_of_the_Dead_of_Hunefer_sheet_3.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP248993.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Anubis_attending_the_mummy_of_Sennedjem.jpg/480px-Anubis_attending_the_mummy_of_Sennedjem.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP238145.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Medinet_Habu_Ramses_III._Tempel_30.jpg/640px-Medinet_Habu_Ramses_III._Tempel_30.jpg",
        "https://images.metmuseum.org/CRDImages/eg/web-large/DP259291.jpg"
    )

    private val vidaCotidianaAudios = listOf(
        AudioItem("vc_aud_1","Sonidos del mercado egipcio","vc_mercado",AudioType.AMBIENT,"Ambiente sonoro de un mercado"),
        AudioItem("vc_aud_2","El dia a dia junto al Nilo","vc_nilo_narracion",AudioType.NARRATION,"Narracion sobre la vida diaria"),
        AudioItem("vc_aud_3","Melodia del arpa egipcia","vc_arpa_egipcia",AudioType.MUSIC,"Melodia con arpa egipcia"),
        AudioItem("vc_aud_4","Cantos de los trabajadores","vc_cantos_trabajo",AudioType.AMBIENT,"Canticos de trabajadores"),
        AudioItem("vc_aud_5","La cocina del faraon","vc_cocina_narracion",AudioType.NARRATION,"Narracion sobre gastronomia")
    )
    private val arquitecturaAudios = listOf(
        AudioItem("arq_aud_1","Ecos en la Piramide","arq_ecos_piramide",AudioType.AMBIENT,"Sonidos dentro de la piramide"),
        AudioItem("arq_aud_2","Construccion de piramides","arq_construccion_narracion",AudioType.NARRATION,"Tecnicas de construccion"),
        AudioItem("arq_aud_3","Himnos de Karnak","arq_himnos_karnak",AudioType.MUSIC,"Himnos ceremoniales"),
        AudioItem("arq_aud_4","Viento del desierto","arq_viento_desierto",AudioType.AMBIENT,"Viento del Sahara en Giza"),
        AudioItem("arq_aud_5","Secretos de la Esfinge","arq_esfinge_narracion",AudioType.NARRATION,"Misterios de la Esfinge")
    )
    private val arteAudios = listOf(
        AudioItem("art_aud_1","El taller del escultor","art_taller_escultor",AudioType.AMBIENT,"Cincel sobre piedra"),
        AudioItem("art_aud_2","Jeroglificos cobran vida","art_jeroglificos_narracion",AudioType.NARRATION,"Escritura jeroglifica"),
        AudioItem("art_aud_3","Musica ritual de Osiris","art_musica_osiris",AudioType.MUSIC,"Musica funeraria ritual"),
        AudioItem("art_aud_4","Preparando pigmentos","art_pigmentos",AudioType.AMBIENT,"Preparacion de pigmentos"),
        AudioItem("art_aud_5","Mascara de Tutankamon","art_tutankamon_narracion",AudioType.NARRATION,"La mascara dorada")
    )

    private const val HLS_TEARS = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    private const val HLS_APPLE = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_fmp4/master.m3u8"
    private const val HLS_AKAMAI = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
    private const val HLS_BLENDER = "https://ireplay.tv/test/blender.m3u8"

    private val vidaCotidianaVideos = listOf(
        VideoItem("vc_vid_1","Un dia en el Antiguo Egipto",HLS_TEARS,"Recrea un dia tipico de un artesano"),
        VideoItem("vc_vid_2","La alimentacion egipcia",HLS_APPLE,"Alimentos y tecnicas culinarias"),
        VideoItem("vc_vid_3","Fiestas y celebraciones",HLS_AKAMAI,"Festividades del calendario egipcio"),
        VideoItem("vc_vid_4","El rol de la mujer",HLS_BLENDER,"La mujer en la sociedad egipcia"),
        VideoItem("vc_vid_5","Oficios y artesanias",HLS_TEARS,"Escribas, artesanos, medicos")
    )
    private val arquitecturaVideos = listOf(
        VideoItem("arq_vid_1","Construyendo piramides",HLS_TEARS,"Construccion de las Grandes Piramides"),
        VideoItem("arq_vid_2","Templos del Nilo",HLS_APPLE,"Recorrido por templos del Nilo"),
        VideoItem("arq_vid_3","Ingenieria egipcia",HLS_AKAMAI,"Innovaciones tecnicas monumentales"),
        VideoItem("arq_vid_4","Abu Simbel: rescate",HLS_BLENDER,"Traslado del templo completo"),
        VideoItem("arq_vid_5","Tumba de Tutankamon",HLS_TEARS,"El descubrimiento de Howard Carter")
    )
    private val arteVideos = listOf(
        VideoItem("art_vid_1","Codigo de jeroglificos",HLS_TEARS,"Champollion y la Piedra Rosetta"),
        VideoItem("art_vid_2","Colores del Antiguo Egipto",HLS_APPLE,"Pigmentos y tecnicas murales"),
        VideoItem("art_vid_3","Tesoros de Tutankamon",HLS_AKAMAI,"Joyas y objetos de la tumba"),
        VideoItem("art_vid_4","Arte de la momificacion",HLS_BLENDER,"El proceso ritual de 70 dias"),
        VideoItem("art_vid_5","Escultura monumental",HLS_TEARS,"Colosos de Memnon a Nefertiti")
    )

    fun getImageUrls(sectionId: String) = when(sectionId) { "vida_cotidiana"->imageUrlsVidaCotidiana; "arquitectura"->imageUrlsArquitectura; "arte"->imageUrlsArte; else->emptyList() }
    fun getImages(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaImages; "arquitectura"->arquitecturaImages; "arte"->arteImages; else->emptyList() }
    fun getAudios(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaAudios; "arquitectura"->arquitecturaAudios; "arte"->arteAudios; else->emptyList() }
    fun getVideos(sectionId: String) = when(sectionId) { "vida_cotidiana"->vidaCotidianaVideos; "arquitectura"->arquitecturaVideos; "arte"->arteVideos; else->emptyList() }
    fun getImageDescription(sectionId: String, index: Int) = getImages(sectionId).getOrNull(index)?.contentDescription ?: "Imagen del museo"
}
