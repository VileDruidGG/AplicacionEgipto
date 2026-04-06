package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    private val vidaCotidianaImages = listOf(
        MuseumImage("vc_img_1", "vc_img_1", "Escena de banquete egipcio", "Pintura mural de un banquete del Antiguo Egipto mostrando músicos tocando arpa y laúd, con bailarines y sirvientes"),
        MuseumImage("vc_img_2", "vc_img_2", "Agricultores en el Nilo", "Relieve en piedra mostrando granjeros egipcios arando campos de trigo con bueyes junto al río Nilo"),
        MuseumImage("vc_img_3", "vc_img_3", "Familia egipcia", "Estatua de piedra caliza policromada de una familia egipcia: padre, madre e hijos sentados juntos"),
        MuseumImage("vc_img_4", "vc_img_4", "Mercado egipcio", "Pintura mural de un mercado al aire libre egipcio con comerciantes vendiendo frutas, pan, telas y cerámicas"),
        MuseumImage("vc_img_5", "vc_img_5", "Artesanos orfebres", "Relieve mostrando artesanos egipcios en su taller creando joyas de oro con martillos y punzones"),
        MuseumImage("vc_img_6", "vc_img_6", "Pescadores del Nilo", "Pintura en papiro mostrando pescadores egipcios en barcas de junco lanzando redes en el río Nilo"),
        MuseumImage("vc_img_7", "vc_img_7", "Preparación de pan", "Modelo de madera pintada mostrando mujeres egipcias moliendo grano y horneando pan"),
        MuseumImage("vc_img_8", "vc_img_8", "Juego del Senet", "Tablero del juego Senet tallado en marfil, uno de los juegos de mesa más antiguos del mundo"),
        MuseumImage("vc_img_9", "vc_img_9", "Escribas egipcios", "Estatua de un escriba sentado con piernas cruzadas sosteniendo un papiro desplegado"),
        MuseumImage("vc_img_10", "vc_img_10", "Medicina egipcia", "Papiro Ebers con texto jeroglífico mostrando recetas medicinales del Antiguo Egipto")
    )

    private val arquitecturaImages = listOf(
        MuseumImage("arq_img_1", "arq_img_1", "Pirámides de Giza", "Las tres Grandes Pirámides de Giza al atardecer con el cielo dorado"),
        MuseumImage("arq_img_2", "arq_img_2", "Interior de la Gran Pirámide", "La Gran Galería ascendente dentro de la Pirámide de Keops"),
        MuseumImage("arq_img_3", "arq_img_3", "Templo de Karnak", "La Sala Hipóstila del Templo de Karnak con 134 columnas gigantes"),
        MuseumImage("arq_img_4", "arq_img_4", "La Gran Esfinge", "La Gran Esfinge de Giza con cuerpo de león y cabeza humana"),
        MuseumImage("arq_img_5", "arq_img_5", "Templo de Luxor", "Fachada del Templo de Luxor iluminado al anochecer"),
        MuseumImage("arq_img_6", "arq_img_6", "Valle de los Reyes", "Vista panorámica de la entrada al Valle de los Reyes"),
        MuseumImage("arq_img_7", "arq_img_7", "Obelisco de Hatshepsut", "Obelisco de granito rojo de la reina Hatshepsut de 29 metros"),
        MuseumImage("arq_img_8", "arq_img_8", "Abu Simbel", "Fachada del templo de Abu Simbel con los cuatro colosos de Ramsés II"),
        MuseumImage("arq_img_9", "arq_img_9", "Templo de Filae", "El Templo de Isis en la isla de Filae reflejado en las aguas del Nilo"),
        MuseumImage("arq_img_10", "arq_img_10", "Pirámide escalonada de Zoser", "La Pirámide escalonada de Zoser en Saqqara, primera estructura monumental de piedra")
    )

    private val arteImages = listOf(
        MuseumImage("art_img_1", "art_img_1", "Jeroglíficos en piedra", "Panel de jeroglíficos tallados en profundidad en piedra caliza blanca"),
        MuseumImage("art_img_2", "art_img_2", "Pintura de Nefertari", "Pintura mural de la reina Nefertari en su tumba jugando al Senet"),
        MuseumImage("art_img_3", "art_img_3", "Máscara de Tutankamón", "La célebre máscara funeraria de oro macizo del faraón Tutankamón"),
        MuseumImage("art_img_4", "art_img_4", "Busto de Nefertiti", "El famoso busto policromado de la reina Nefertiti con corona azul"),
        MuseumImage("art_img_5", "art_img_5", "Sarcófago dorado", "Sarcófago antropoide de madera dorada con incrustaciones de lapislázuli"),
        MuseumImage("art_img_6", "art_img_6", "Libro de los Muertos", "Papiro ilustrado del Libro de los Muertos mostrando el Juicio de Osiris"),
        MuseumImage("art_img_7", "art_img_7", "Collar usekh", "Collar usekh ceremonial de oro con cuentas de cornalina y turquesa"),
        MuseumImage("art_img_8", "art_img_8", "Estatua de Anubis", "Estatua del dios chacal Anubis recostado sobre un cofre dorado"),
        MuseumImage("art_img_9", "art_img_9", "Relieve batalla de Kadesh", "Relieve mostrando carros de guerra en la batalla de Kadesh"),
        MuseumImage("art_img_10", "art_img_10", "Collar de fayenza", "Collar de cuentas de fayenza azul egipcia con amuletos protectores")
    )

    val imageUrlsVidaCotidiana = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Maler_der_Grabkammer_des_Nacht_001.jpg/800px-Maler_der_Grabkammer_des_Nacht_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Tomb_of_Sennedjem_%281%29.jpg/800px-Tomb_of_Sennedjem_%281%29.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Egyptian_-_Pair_Statue_of_Nebsen_and_Nebet-Ta_-_Walters_2286.jpg/450px-Egyptian_-_Pair_Statue_of_Nebsen_and_Nebet-Ta_-_Walters_2286.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Maler_der_Grabkammer_des_Menna_008.jpg/800px-Maler_der_Grabkammer_des_Menna_008.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Maler_der_Grabkammer_des_Ipui_001.jpg/800px-Maler_der_Grabkammer_des_Ipui_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Fishing_scene%2C_Tomb_of_Menna.jpg/800px-Fishing_scene%2C_Tomb_of_Menna.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Egypte_lobread.jpg/600px-Egypte_lobread.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Gaming_Board_Inscribed_for_Amenhotep_III_MET_DP116866.jpg/800px-Gaming_Board_Inscribed_for_Amenhotep_III_MET_DP116866.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Egyptian_-_The_Seated_Scribe_-_Google_Art_Project.jpg/450px-Egyptian_-_The_Seated_Scribe_-_Google_Art_Project.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Edwin_Smith_Papyrus_v2.jpg/800px-Edwin_Smith_Papyrus_v2.jpg"
    )

    val imageUrlsArquitectura = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Kheops-Pyramid.jpg/1024px-Kheops-Pyramid.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Egypt.KarnakTemple.07.jpg/800px-Egypt.KarnakTemple.07.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Egypt.KarnakTemple.07.jpg/800px-Egypt.KarnakTemple.07.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Great_Sphinx_of_Giza_-_20080716a.jpg/1024px-Great_Sphinx_of_Giza_-_20080716a.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Luxor_Temple_R03.jpg/800px-Luxor_Temple_R03.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/ValleyOfTheKings_2007.jpg/1024px-ValleyOfTheKings_2007.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Obelisk_of_Hatshepsut.jpg/400px-Obelisk_of_Hatshepsut.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Abu_Simbel%2C_Ramesses_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg/1024px-Abu_Simbel%2C_Ramesses_Temple%2C_front%2C_Egypt%2C_Oct_2004.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Philae_Temple_R01.jpg/800px-Philae_Temple_R01.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Saqqara_BW_5.jpg/800px-Saqqara_BW_5.jpg"
    )

    val imageUrlsArte = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Egyptian_hieroglyphs_at_Hatshepsut_temple.jpg/800px-Egyptian_hieroglyphs_at_Hatshepsut_temple.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Maler_der_Grabkammer_der_Nefertari_001.jpg/700px-Maler_der_Grabkammer_der_Nefertari_001.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Nofretete_Neues_Museum.jpg/450px-Nofretete_Neues_Museum.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Nofretete_Neues_Museum.jpg/450px-Nofretete_Neues_Museum.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Innerster_Sarg_des_Tutanchamun.jpg/400px-Innerster_Sarg_des_Tutanchamun.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Book_of_the_Dead_of_Hunefer_sheet_3.jpg/1024px-Book_of_the_Dead_of_Hunefer_sheet_3.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Egyptian_-_Broad_Collar_-_Google_Art_Project.jpg/700px-Egyptian_-_Broad_Collar_-_Google_Art_Project.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Anubis_attending_the_mummy_of_Sennedjem.jpg/600px-Anubis_attending_the_mummy_of_Sennedjem.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Medinet_Habu_Ramses_III._Tempel_30.jpg/800px-Medinet_Habu_Ramses_III._Tempel_30.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Egyptian_-_Broad_Collar_-_Walters_42387_-_View_A.jpg/600px-Egyptian_-_Broad_Collar_-_Walters_42387_-_View_A.jpg"
    )

    private val vidaCotidianaAudios = listOf(
        AudioItem("vc_aud_1", "Sonidos del mercado egipcio", "vc_mercado", AudioType.AMBIENT, "Ambiente sonoro de un mercado del Antiguo Egipto"),
        AudioItem("vc_aud_2", "El día a día junto al Nilo", "vc_nilo_narracion", AudioType.NARRATION, "Narración sobre la vida diaria junto al río Nilo"),
        AudioItem("vc_aud_3", "Melodía del arpa egipcia", "vc_arpa_egipcia", AudioType.MUSIC, "Melodía interpretada con arpa egipcia tradicional"),
        AudioItem("vc_aud_4", "Cantos de los trabajadores", "vc_cantos_trabajo", AudioType.AMBIENT, "Cánticos rítmicos de los trabajadores egipcios"),
        AudioItem("vc_aud_5", "La cocina del faraón", "vc_cocina_narracion", AudioType.NARRATION, "Narración sobre la gastronomía de la corte")
    )

    private val arquitecturaAudios = listOf(
        AudioItem("arq_aud_1", "Ecos en la Gran Pirámide", "arq_ecos_piramide", AudioType.AMBIENT, "Sonidos ambientales del interior de la Gran Pirámide"),
        AudioItem("arq_aud_2", "Construcción de pirámides", "arq_construccion_narracion", AudioType.NARRATION, "Narración sobre técnicas de construcción"),
        AudioItem("arq_aud_3", "Himnos del Templo de Karnak", "arq_himnos_karnak", AudioType.MUSIC, "Recreación de himnos ceremoniales de Karnak"),
        AudioItem("arq_aud_4", "Viento del desierto", "arq_viento_desierto", AudioType.AMBIENT, "Sonido del viento del Sahara en Giza"),
        AudioItem("arq_aud_5", "Secretos de la Esfinge", "arq_esfinge_narracion", AudioType.NARRATION, "Narración sobre los misterios de la Gran Esfinge")
    )

    private val arteAudios = listOf(
        AudioItem("art_aud_1", "El taller del escultor", "art_taller_escultor", AudioType.AMBIENT, "Sonidos de cincel sobre piedra"),
        AudioItem("art_aud_2", "Los jeroglíficos cobran vida", "art_jeroglificos_narracion", AudioType.NARRATION, "Narración sobre la escritura jeroglífica"),
        AudioItem("art_aud_3", "Música ritual de Osiris", "art_musica_osiris", AudioType.MUSIC, "Música ritual funeraria dedicada a Osiris"),
        AudioItem("art_aud_4", "Preparando los pigmentos", "art_pigmentos", AudioType.AMBIENT, "Sonidos de preparación de pigmentos minerales"),
        AudioItem("art_aud_5", "La máscara de Tutankamón", "art_tutankamon_narracion", AudioType.NARRATION, "Narración sobre la máscara dorada de Tutankamón")
    )

    private const val TEST_HLS_URL = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"

    private val vidaCotidianaVideos = listOf(
        VideoItem("vc_vid_1", "Un día en el Antiguo Egipto", TEST_HLS_URL, "Documental que recrea un día típico de un artesano egipcio"),
        VideoItem("vc_vid_2", "La alimentación egipcia", TEST_HLS_URL, "Los alimentos y técnicas culinarias del antiguo Nilo"),
        VideoItem("vc_vid_3", "Fiestas y celebraciones", TEST_HLS_URL, "Las principales festividades del calendario egipcio"),
        VideoItem("vc_vid_4", "El rol de la mujer en Egipto", TEST_HLS_URL, "La importancia de la mujer en la sociedad egipcia"),
        VideoItem("vc_vid_5", "Oficios y artesanías", TEST_HLS_URL, "Los principales oficios: escribas, artesanos, médicos")
    )

    private val arquitecturaVideos = listOf(
        VideoItem("arq_vid_1", "Construyendo las pirámides", TEST_HLS_URL, "Teorías sobre la construcción de las Grandes Pirámides"),
        VideoItem("arq_vid_2", "Templos del Nilo", TEST_HLS_URL, "Recorrido virtual por los templos más impresionantes"),
        VideoItem("arq_vid_3", "Ingeniería del Antiguo Egipto", TEST_HLS_URL, "Las innovaciones técnicas monumentales"),
        VideoItem("arq_vid_4", "Abu Simbel: rescate épico", TEST_HLS_URL, "Cómo se trasladó un templo entero"),
        VideoItem("arq_vid_5", "La tumba de Tutankamón", TEST_HLS_URL, "El descubrimiento arqueológico más famoso")
    )

    private val arteVideos = listOf(
        VideoItem("art_vid_1", "El código de los jeroglíficos", TEST_HLS_URL, "Cómo Champollion descifró la Piedra Rosetta"),
        VideoItem("art_vid_2", "Colores del Antiguo Egipto", TEST_HLS_URL, "Pigmentos y técnicas de las pinturas murales"),
        VideoItem("art_vid_3", "Tesoros de Tutankamón", TEST_HLS_URL, "Las joyas y objetos de la tumba del faraón"),
        VideoItem("art_vid_4", "El arte de la momificación", TEST_HLS_URL, "El proceso ritual de 70 días"),
        VideoItem("art_vid_5", "Escultura monumental", TEST_HLS_URL, "De los colosos de Memnón al busto de Nefertiti")
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
        val images = getImages(sectionId)
        return images.getOrNull(index)?.contentDescription ?: "Imagen del museo"
    }
}
