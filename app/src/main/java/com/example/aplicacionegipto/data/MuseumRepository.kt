package com.example.aplicacionegipto.data

import com.example.aplicacionegipto.model.*

object MuseumRepository {

    private val vidaCotidianaImages = listOf(
        MuseumImage("vc1","vc1","Hipopotamo William","Figurilla de fayenza azul decorada con lotos"),
        MuseumImage("vc2","vc2","Esfinge de Senwosret III","Esfinge de gneis del faraon Senwosret III"),
        MuseumImage("vc3","vc3","Esfinge de Amenhotep III","Esfinge de fayenza azul con manos humanas"),
        MuseumImage("vc4","vc4","Esfinge Amenhotep lateral","Vista lateral de la esfinge de fayenza"),
        MuseumImage("vc5","vc5","Esfinge Amenhotep frontal","Vista frontal de la esfinge azul"),
        MuseumImage("vc6","vc6","Esfinge Amenhotep detalle","Detalle de la esfinge de Amenhotep III"),
        MuseumImage("vc7","vc7","Mascara funeraria dorada","Mascara de oro de Hatnefer madre de Senenmut"),
        MuseumImage("vc8","vc8","Esfinge Hatshepsut frontal","Gran esfinge de granito de la faraona"),
        MuseumImage("vc9","vc9","Esfinge Hatshepsut lateral","Vista lateral de la esfinge de Hatshepsut"),
        MuseumImage("vc10","vc10","Esfinge Hatshepsut superior","Vista desde arriba de la esfinge")
    )
    private val arquitecturaImages = listOf(
        MuseumImage("ar1","ar1","Esfinge Hatshepsut angulo","Angulo dramatico de la esfinge"),
        MuseumImage("ar2","ar2","Esfinge Hatshepsut detalle cara","Rostro idealizado de Hatshepsut"),
        MuseumImage("ar3","ar3","Esfinge Hatshepsut restauracion","Vista de la restauracion del monumento"),
        MuseumImage("ar4","ar4","Esfinge Hatshepsut excavacion","Foto historica de la excavacion"),
        MuseumImage("ar5","ar5","Esfinge Hatshepsut completa","Vista completa del monumento restaurado"),
        MuseumImage("ar6","ar6","Sarcofago de Henettawy frontal","Sarcofago pintado de la cantora de Amun"),
        MuseumImage("ar7","ar7","Sarcofago Henettawy detalle","Detalle de las pinturas del sarcofago"),
        MuseumImage("ar8","ar8","Sarcofago Henettawy lateral","Vista lateral del sarcofago decorado"),
        MuseumImage("ar9","ar9","Sarcofago de Ukhhotep","Sarcofago del tesoro real Ukhhotep"),
        MuseumImage("ar10","ar10","Cuchara cosmetica","Cuchara en forma de mujer nadando")
    )
    private val arteImages = listOf(
        MuseumImage("at1","at1","Esfinge Senwosret perfil","Vista de perfil de la esfinge de gneis"),
        MuseumImage("at2","at2","Esfinge Senwosret angulo","Angulo de tres cuartos de la esfinge"),
        MuseumImage("at3","at3","Esfinge Senwosret detalle mane","Detalle de la melena de leon"),
        MuseumImage("at4","at4","Esfinge Senwosret trasera","Vista trasera de la escultura"),
        MuseumImage("at5","at5","Esfinge Senwosret rostro","Primer plano del rostro del faraon"),
        MuseumImage("at6","at6","Esfinge Senwosret completa","Vista general de la pieza completa"),
        MuseumImage("at7","at7","Esfinge Senwosret base","Detalle de la base con jeroglificos"),
        MuseumImage("at8","at8","Hipopotamo William lateral","Vista lateral del hipopotamo de fayenza"),
        MuseumImage("at9","at9","Sarcofago Henettawy arte","Decoracion artistica del sarcofago"),
        MuseumImage("at10","at10","Mascara Hatnefer perfil","Vista de perfil de la mascara dorada")
    )

    // === TODAS URLs del Met Museum IIIF (verificadas del HTML de metmuseum.org) ===
    // Formato: collectionapi.metmuseum.org/api/collection/v1/iiif/{objectID}/{imageID}/main-image

    val imageUrlsVidaCotidiana = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544227/1216904/main-image",  // William hippo
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",  // Senwosret sphinx
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1151827/main-image",  // Amenhotep sphinx 3/4
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1177790/main-image",  // Amenhotep sphinx side
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1081887/main-image",  // Amenhotep sphinx front
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1081899/main-image",  // Amenhotep sphinx detail
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545147/1086200/main-image",  // Hatnefer mask
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106258/main-image",  // Hatshepsut sphinx
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106256/main-image",  // Hatshepsut side
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106259/main-image"   // Hatshepsut angle
    )

    val imageUrlsArquitectura = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106260/main-image",  // Hatshepsut dramatic
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106257/main-image",  // Hatshepsut face
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106255/main-image",  // Hatshepsut restored
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/1228544/main-image",  // Hatshepsut excavation
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/1228545/main-image",  // Hatshepsut complete
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1359380/main-image",  // Henettawy coffin
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1578431/main-image",  // Henettawy detail
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1578434/main-image",  // Henettawy side
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/546303/1192591/main-image",  // Ukhhotep coffin
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548584/preview"              // Cosmetic spoon
    )

    val imageUrlsArte = listOf(
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544186/1216912/main-image",  // Senwosret main
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544227/1216904/main-image",  // William main
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1151827/main-image",  // Amenhotep main
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/545147/1086200/main-image",  // Hatnefer mask
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/1151968/main-image",  // Hatshepsut historic
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1359380/main-image",  // Henettawy art
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106258/main-image",  // Hatshepsut grand
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544498/1177790/main-image",  // Amenhotep art
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/548264/1578431/main-image",  // Henettawy painting
        "https://collectionapi.metmuseum.org/api/collection/v1/iiif/544442/2106255/main-image"   // Hatshepsut closeup
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
