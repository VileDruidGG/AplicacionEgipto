package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    private val vidaCotidianaImages = listOf(
        MuseumImage("vc_img_1", "vc_img_1", "Escena de banquete egipcio", "Pintura mural de un banquete del Antiguo Egipto con musicos y bailarines"),
        MuseumImage("vc_img_2", "vc_img_2", "Agricultores en el Nilo", "Granjeros egipcios arando campos de trigo con bueyes junto al rio Nilo"),
        MuseumImage("vc_img_3", "vc_img_3", "Familia egipcia", "Estatua de una familia egipcia sentados juntos"),
        MuseumImage("vc_img_4", "vc_img_4", "Mercado egipcio", "Mercado al aire libre con comerciantes vendiendo frutas y ceramicas"),
        MuseumImage("vc_img_5", "vc_img_5", "Artesanos orfebres", "Artesanos creando joyas de oro con martillos"),
        MuseumImage("vc_img_6", "vc_img_6", "Pescadores del Nilo", "Pescadores en barcas lanzando redes en el Nilo"),
        MuseumImage("vc_img_7", "vc_img_7", "Preparacion de pan", "Mujeres moliendo grano y horneando pan"),
        MuseumImage("vc_img_8", "vc_img_8", "Juego del Senet", "Tablero del juego Senet tallado en marfil"),
        MuseumImage("vc_img_9", "vc_img_9", "Escribas egipcios", "Escriba sentado con papiro desplegado"),
        MuseumImage("vc_img_10", "vc_img_10", "Medicina egipcia", "Papiro Ebers con recetas medicinales")
    )
    private val arquitecturaImages = listOf(
        MuseumImage("arq_img_1", "arq_img_1", "Piramides de Giza", "Las tres Grandes Piramides al atardecer"),
        MuseumImage("arq_img_2", "arq_img_2", "Templo de Karnak", "Sala Hipostila con 134 columnas gigantes"),
        MuseumImage("arq_img_3", "arq_img_3", "Templo de Karnak detalle", "Columnas papiriformes decoradas"),
        MuseumImage("arq_img_4", "arq_img_4", "La Gran Esfinge", "Esfinge con cuerpo de leon y cabeza humana"),
        MuseumImage("arq_img_5", "arq_img_5", "Templo de Luxor", "Fachada del Templo de Luxor al anochecer"),
        MuseumImage("arq_img_6", "arq_img_6", "Valle de los Reyes", "Entrada al Valle de los Reyes"),
        MuseumImage("arq_img_7", "arq_img_7", "Obelisco de Hatshepsut", "Obelisco de granito rojo de 29 metros"),
        MuseumImage("arq_img_8", "arq_img_8", "Abu Simbel", "Cuatro colosos de Ramses II tallados en roca"),
        MuseumImage("arq_img_9", "arq_img_9", "Templo de Filae", "Templo de Isis reflejado en el Nilo"),
        MuseumImage("arq_img_10", "arq_img_10", "Piramide de Zoser", "Primera estructura monumental de piedra")
    )
    private val arteImages = listOf(
        MuseumImage("art_img_1", "art_img_1", "Jeroglificos", "Jeroglificos tallados en piedra caliza"),
        MuseumImage("art_img_2", "art_img_2", "Pintura de Nefertari", "Reina Nefertari jugando al Senet"),
        MuseumImage("art_img_3", "art_img_3", "Busto de Nefertiti", "Busto policromado con corona azul"),
        MuseumImage("art_img_4", "art_img_4", "Nefertiti perfil", "Vista lateral del busto de Nefertiti"),
        MuseumImage("art_img_5", "art_img_5", "Sarcofago dorado", "Sarcofago con incrustaciones de lapislazuli"),
        MuseumImage("art_img_6", "art_img_6", "Libro de los Muertos", "Papiro del Juicio de Osiris"),
        MuseumImage("art_img_7", "art_img_7", "Collar usekh", "Collar ceremonial de oro y turquesa"),
        MuseumImage("art_img_8", "art_img_8", "Anubis y momia", "Anubis atendiendo una momificacion"),
        MuseumImage("art_img_9", "art_img_9", "Relieve de batalla", "Carros de guerra del templo de Medinet Habu"),
        MuseumImage("art_img_10", "art_img_10", "Collar fayenza", "Collar de cuentas azules con amuletos")
    )

    // URLs de imagenes verificadas (Wikimedia Commons, Pexels - dominio publico)
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
        "https://images.pexels.com/photos/5765830/pexels-photo-5765830.jpeg?auto=compress&cs=tinysrgb&w=600"
    )
    val imageUrlsArquitectura = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Kheops-Pyramid.jpg/640px-Kheops-Pyramid.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Egypt.KarnakTemple.07.jpg/640px-Egypt.KarnakTemple.07.jpg",
        "https://images.pexels.com/photos/3522880/pexels-photo-3522880.jpeg?auto=compress&cs=tinysrgb&w=600",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Great_Sphinx_of_Giza_-_20080716a.jpg/640px-Great_Sphinx_of_Giza_-_20080716a.jpg",
        "https://images.pexels.com/photos/3689859/pexels-photo-3689859.jpeg?auto=compress&cs=tinysrgb&w=600",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/ValleyOfTheKings_2007.jpg/640px-ValleyOfTheKings_2007.jpg",
        "https://images.pexels.com/photos/71241/pexels-photo-71241.jpeg?auto=compress&cs=tinysrgb&w=600",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Abu_Simbel%2C_Ramesses_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg/640px-Abu_Simbel%2C_Ramesses_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Philae_Temple_R01.jpg/640px-Philae_Temple_R01.jpg",
        "https://images.pexels.com/photos/2034335/pexels-photo-2034335.jpeg?auto=compress&cs=tinysrgb&w=600"
    )
    val imageUrlsArte = listOf(
        "https://images.pexels.com/photos/5765831/pexels-photo-5765831.jpeg?auto=compress&cs=tinysrgb&w=600",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Maler_der_Grabkammer_der_Nefertari_001.jpg/480px-Maler_der_Grabkammer_der_Nefertari_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Nofretete_Neues_Museum.jpg/360px-Nofretete_Neues_Museum.jpg",
        "https://images.pexels.com/photos/6152261/pexels-photo-6152261.jpeg?auto=compress&cs=tinysrgb&w=600",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Innerster_Sarg_des_Tutanchamun.jpg/320px-Innerster_Sarg_des_Tutanchamun.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Book_of_the_Dead_of_Hunefer_sheet_3.jpg/640px-Book_of_the_Dead_of_Hunefer_sheet_3.jpg",
        "https://images.pexels.com/photos/6152103/pexels-photo-6152103.jpeg?auto=compress&cs=tinysrgb&w=600",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Anubis_attending_the_mummy_of_Sennedjem.jpg/480px-Anubis_attending_the_mummy_of_Sennedjem.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Medinet_Habu_Ramses_III._Tempel_30.jpg/640px-Medinet_Habu_Ramses_III._Tempel_30.jpg",
        "https://images.pexels.com/photos/6152262/pexels-photo-6152262.jpeg?auto=compress&cs=tinysrgb&w=600"
    )

    // Audios (res/raw - los archivos deben existir en la carpeta)
    private val vidaCotidianaAudios = listOf(
        AudioItem("vc_aud_1", "Sonidos del mercado egipcio", "vc_mercado", AudioType.AMBIENT, "Ambiente sonoro de un mercado"),
        AudioItem("vc_aud_2", "El dia a dia junto al Nilo", "vc_nilo_narracion", AudioType.NARRATION, "Narracion sobre la vida diaria"),
        AudioItem("vc_aud_3", "Melodia del arpa egipcia", "vc_arpa_egipcia", AudioType.MUSIC, "Melodia con arpa egipcia"),
        AudioItem("vc_aud_4", "Cantos de los trabajadores", "vc_cantos_trabajo", AudioType.AMBIENT, "Canticos de trabajadores"),
        AudioItem("vc_aud_5", "La cocina del faraon", "vc_cocina_narracion", AudioType.NARRATION, "Narracion sobre gastronomia")
    )
    private val arquitecturaAudios = listOf(
        AudioItem("arq_aud_1", "Ecos en la Piramide", "arq_ecos_piramide", AudioType.AMBIENT, "Sonidos dentro de la piramide"),
        AudioItem("arq_aud_2", "Construccion de piramides", "arq_construccion_narracion", AudioType.NARRATION, "Tecnicas de construccion"),
        AudioItem("arq_aud_3", "Himnos de Karnak", "arq_himnos_karnak", AudioType.MUSIC, "Himnos ceremoniales"),
        AudioItem("arq_aud_4", "Viento del desierto", "arq_viento_desierto", AudioType.AMBIENT, "Viento del Sahara en Giza"),
        AudioItem("arq_aud_5", "Secretos de la Esfinge", "arq_esfinge_narracion", AudioType.NARRATION, "Misterios de la Esfinge")
    )
    private val arteAudios = listOf(
        AudioItem("art_aud_1", "El taller del escultor", "art_taller_escultor", AudioType.AMBIENT, "Cincel sobre piedra"),
        AudioItem("art_aud_2", "Jeroglificos cobran vida", "art_jeroglificos_narracion", AudioType.NARRATION, "Escritura jerogifica"),
        AudioItem("art_aud_3", "Musica ritual de Osiris", "art_musica_osiris", AudioType.MUSIC, "Musica funeraria ritual"),
        AudioItem("art_aud_4", "Preparando pigmentos", "art_pigmentos", AudioType.AMBIENT, "Preparacion de pigmentos"),
        AudioItem("art_aud_5", "Mascara de Tutankamon", "art_tutankamon_narracion", AudioType.NARRATION, "La mascara dorada")
    )

    // Videos HLS - URLs verificadas y funcionales
    private const val HLS_TEARS = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    private const val HLS_APPLE = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_fmp4/master.m3u8"
    private const val HLS_AKAMAI = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
    private const val HLS_BLENDER = "https://ireplay.tv/test/blender.m3u8"

    private val vidaCotidianaVideos = listOf(
        VideoItem("vc_vid_1", "Un dia en el Antiguo Egipto", HLS_TEARS, "Recrea un dia tipico de un artesano egipcio"),
        VideoItem("vc_vid_2", "La alimentacion egipcia", HLS_APPLE, "Alimentos y tecnicas culinarias del Nilo"),
        VideoItem("vc_vid_3", "Fiestas y celebraciones", HLS_AKAMAI, "Festividades del calendario egipcio"),
        VideoItem("vc_vid_4", "El rol de la mujer", HLS_BLENDER, "La mujer en la sociedad egipcia"),
        VideoItem("vc_vid_5", "Oficios y artesanias", HLS_TEARS, "Escribas, artesanos, medicos, sacerdotes")
    )
    private val arquitecturaVideos = listOf(
        VideoItem("arq_vid_1", "Construyendo piramides", HLS_TEARS, "Construccion de las Grandes Piramides"),
        VideoItem("arq_vid_2", "Templos del Nilo", HLS_APPLE, "Recorrido por templos del Nilo"),
        VideoItem("arq_vid_3", "Ingenieria egipcia", HLS_AKAMAI, "Innovaciones tecnicas monumentales"),
        VideoItem("arq_vid_4", "Abu Simbel: rescate", HLS_BLENDER, "Traslado del templo completo"),
        VideoItem("arq_vid_5", "Tumba de Tutankamon", HLS_TEARS, "El descubrimiento de Howard Carter")
    )
    private val arteVideos = listOf(
        VideoItem("art_vid_1", "Codigo de jeroglificos", HLS_TEARS, "Champollion y la Piedra Rosetta"),
        VideoItem("art_vid_2", "Colores del Antiguo Egipto", HLS_APPLE, "Pigmentos y tecnicas murales"),
        VideoItem("art_vid_3", "Tesoros de Tutankamon", HLS_AKAMAI, "Joyas y objetos de la tumba"),
        VideoItem("art_vid_4", "Arte de la momificacion", HLS_BLENDER, "El proceso ritual de 70 dias"),
        VideoItem("art_vid_5", "Escultura monumental", HLS_TEARS, "Colosos de Memnon a Nefertiti")
    )

    fun getImageUrls(sectionId: String): List<String> = when (sectionId) {
        "vida_cotidiana" -> imageUrlsVidaCotidiana
        "arquitectura" -> imageUrlsArquitectura
        "arte" -> imageUrlsArte
        else -> emptyList()
    }
    fun getImages(sectionId: String): List<MuseumImage> = when (sectionId) {
        "vida_cotidiana" -> vidaCotidianaImages
        "arquitectura" -> arquitecturaImages
        "arte" -> arteImages
        else -> emptyList()
    }
    fun getAudios(sectionId: String): List<AudioItem> = when (sectionId) {
        "vida_cotidiana" -> vidaCotidianaAudios
        "arquitectura" -> arquitecturaAudios
        "arte" -> arteAudios
        else -> emptyList()
    }
    fun getVideos(sectionId: String): List<VideoItem> = when (sectionId) {
        "vida_cotidiana" -> vidaCotidianaVideos
        "arquitectura" -> arquitecturaVideos
        "arte" -> arteVideos
        else -> emptyList()
    }
    fun getImageDescription(sectionId: String, index: Int): String {
        return getImages(sectionId).getOrNull(index)?.contentDescription ?: "Imagen del museo"
    }
}
