package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Banquete tumba de Nakht","Musicos y bailarines en banquete egipcio"),
        MuseumImage("vc2","vc2","Tumba de Sennedjem","Pinturas de la tumba del artesano Sennedjem"),
        MuseumImage("vc3","vc3","El escriba sentado","Estatua de escriba con papiro del Louvre"),
        MuseumImage("vc4","vc4","Cosecha tumba de Menna","Escenas agricolas de la tumba de Menna"),
        MuseumImage("vc5","vc5","Artesanos de Ipui","Artesanos trabajando en la tumba de Ipui"),
        MuseumImage("vc6","vc6","Pesca en el Nilo","Escena de pesca con arpones en el Nilo"),
        MuseumImage("vc7","vc7","Panaderia egipcia","Modelo de fabricacion de pan egipcio"),
        MuseumImage("vc8","vc8","Tablero de Senet","Tablero del juego Senet de Amenhotep III"),
        MuseumImage("vc9","vc9","Papiro medico","Papiro Edwin Smith con recetas medicas"),
        MuseumImage("vc10","vc10","Familia de Nebsen","Estatua de pareja Nebsen y Nebet-Ta")
    )
    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Piramides de Giza","Las tres Grandes Piramides al atardecer"),
        MuseumImage("ar2","ar2","Gran Esfinge","Esfinge de Giza con piramide de Khafre"),
        MuseumImage("ar3","ar3","Valle de los Reyes","Entrada al Valle de los Reyes"),
        MuseumImage("ar4","ar4","Templo de Filae","Templo de Isis en la isla de Filae"),
        MuseumImage("ar5","ar5","Templo de Karnak","Sala Hipostila con columnas gigantes"),
        MuseumImage("ar6","ar6","Abu Simbel","Colosos de Ramses II en Abu Simbel"),
        MuseumImage("ar7","ar7","Templo de Luxor","Entrada del Templo de Luxor"),
        MuseumImage("ar8","ar8","Piramide escalonada","Piramide de Zoser en Saqqara"),
        MuseumImage("ar9","ar9","Obelisco de Hatshepsut","Obelisco en el Templo de Karnak"),
        MuseumImage("ar10","ar10","Interior piramide","Pasillo dentro de la Gran Piramide")
    )
    private val arteImages = listOf(
        MuseumImage("at1","at1","Jeroglificos Hatshepsut","Jeroglificos tallados en templo de Hatshepsut"),
        MuseumImage("at2","at2","Pintura de Nefertari","Reina Nefertari en su tumba"),
        MuseumImage("at3","at3","Busto de Nefertiti","Famoso busto policromado de Nefertiti"),
        MuseumImage("at4","at4","Sarcofago de Tutankamon","Sarcofago interior dorado"),
        MuseumImage("at5","at5","Libro de los Muertos","Papiro del Juicio de Osiris de Hunefer"),
        MuseumImage("at6","at6","Collar ceremonial","Collar pectoral con halcon de Google Art"),
        MuseumImage("at7","at7","Anubis momificacion","Anubis atendiendo momia de Sennedjem"),
        MuseumImage("at8","at8","Nebamun cazando","Pintura de caza en los pantanos del Nilo"),
        MuseumImage("at9","at9","Relieve Medinet Habu","Relieves de batalla de Ramses III"),
        MuseumImage("at10","at10","Pintura tumba Tutankamon","Escena de la tumba de Tutankamon")
    )

    // === TODAS LAS URLs SON WIKIMEDIA COMMONS (verificado que funcionan) ===

    val imageUrlsVidaCotidiana = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Maler_der_Grabkammer_des_Nacht_001.jpg/640px-Maler_der_Grabkammer_des_Nacht_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Tomb_of_Sennedjem_%281%29.jpg/640px-Tomb_of_Sennedjem_%281%29.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Egyptian_-_The_Seated_Scribe_-_Google_Art_Project.jpg/400px-Egyptian_-_The_Seated_Scribe_-_Google_Art_Project.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Maler_der_Grabkammer_des_Menna_008.jpg/640px-Maler_der_Grabkammer_des_Menna_008.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Maler_der_Grabkammer_des_Ipui_001.jpg/640px-Maler_der_Grabkammer_des_Ipui_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Fishing_scene%2C_Tomb_of_Menna.jpg/640px-Fishing_scene%2C_Tomb_of_Menna.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Egypte_lobread.jpg/480px-Egypte_lobread.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Gaming_Board_Inscribed_for_Amenhotep_III_MET_DP116866.jpg/640px-Gaming_Board_Inscribed_for_Amenhotep_III_MET_DP116866.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Edwin_Smith_Papyrus_v2.jpg/640px-Edwin_Smith_Papyrus_v2.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Egyptian_-_Pair_Statue_of_Nebsen_and_Nebet-Ta_-_Walters_2286.jpg/400px-Egyptian_-_Pair_Statue_of_Nebsen_and_Nebet-Ta_-_Walters_2286.jpg"
    )

    val imageUrlsArquitectura = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Kheops-Pyramid.jpg/640px-Kheops-Pyramid.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Great_Sphinx_of_Giza_-_20080716a.jpg/640px-Great_Sphinx_of_Giza_-_20080716a.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/ValleyOfTheKings_2007.jpg/640px-ValleyOfTheKings_2007.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Philae_Temple_R01.jpg/640px-Philae_Temple_R01.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/S_F-E-CAMERON_2006-10-EGYPT-KARNAK-0177.JPG/640px-S_F-E-CAMERON_2006-10-EGYPT-KARNAK-0177.JPG",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Abu_Simbel%2C_Ramesses_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg/640px-Abu_Simbel%2C_Ramesses_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Luxor_Temple_R03.jpg/640px-Luxor_Temple_R03.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Saqqara_BW_5.jpg/640px-Saqqara_BW_5.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Obelisk_of_Hatshepsut.jpg/320px-Obelisk_of_Hatshepsut.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Great_Pyramid_Passages.jpg/400px-Great_Pyramid_Passages.jpg"
    )

    val imageUrlsArte = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Egyptian_hieroglyphs_at_Hatshepsut_temple.jpg/640px-Egyptian_hieroglyphs_at_Hatshepsut_temple.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Maler_der_Grabkammer_der_Nefertari_001.jpg/480px-Maler_der_Grabkammer_der_Nefertari_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Nofretete_Neues_Museum.jpg/360px-Nofretete_Neues_Museum.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Innerster_Sarg_des_Tutanchamun.jpg/320px-Innerster_Sarg_des_Tutanchamun.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Book_of_the_Dead_of_Hunefer_sheet_3.jpg/640px-Book_of_the_Dead_of_Hunefer_sheet_3.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Egyptian_-_Broad_Collar_-_Google_Art_Project.jpg/600px-Egyptian_-_Broad_Collar_-_Google_Art_Project.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Anubis_attending_the_mummy_of_Sennedjem.jpg/480px-Anubis_attending_the_mummy_of_Sennedjem.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Nebamun_Hunting_in_the_Marshes%2C_British_Museum.jpg/640px-Nebamun_Hunting_in_the_Marshes%2C_British_Museum.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Medinet_Habu_Ramses_III._Tempel_30.jpg/640px-Medinet_Habu_Ramses_III._Tempel_30.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Tomb_of_Tutankhamun_%28KV62%29%2C_Wall_painting%2C_Valley_of_the_Kings%2C_Egypt.jpg/640px-Tomb_of_Tutankhamun_%28KV62%29%2C_Wall_painting%2C_Valley_of_the_Kings%2C_Egypt.jpg"
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
