package com.example.aplicacionegipto.ui.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.model.AgeGroup
import com.example.aplicacionegipto.ui.components.MuseumAsyncImage
import com.example.aplicacionegipto.ui.theme.*
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(sectionId: String, articleId: String, onBack: () -> Unit, onImageClick: (Int) -> Unit) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var selectedAge by remember { mutableStateOf(AgeGroup.ADULT) }
    var isSpeaking by remember { mutableStateOf(false) }

    val idx = articleId.removePrefix("article_").toIntOrNull() ?: 0
    val urls = MuseumRepository.getImageUrls(sectionId)
    val url = urls.getOrNull(idx) ?: ""
    val title = getTitle(sectionId, idx)
    val content = getContent(sectionId, idx, selectedAge)

    // TTS — iniciado una sola vez, liberado al salir
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }

    DisposableEffect(lifecycleOwner) {
        val engine = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale("es", "MX")
            }
        }
        tts = engine

        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> {
                    engine.stop()
                    isSpeaking = false
                }
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            engine.stop()
            engine.shutdown()
        }
    }

    // Cuando cambia el contenido (edad o articulo) detener la voz
    LaunchedEffect(content) {
        tts?.stop()
        isSpeaking = false
    }

    fun speak() {
        val engine = tts ?: return
        if (isSpeaking) {
            engine.stop()
            isSpeaking = false
        } else {
            val texto = "$title. $content"
            engine.speak(texto, TextToSpeech.QUEUE_FLUSH, null, "article_tts")
            isSpeaking = true
        }
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), maxLines = 1) },
            navigationIcon = { IconButton(onClick = { tts?.stop(); onBack() }) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Regresar") } },
            actions = {
                IconButton(
                    onClick = { speak() },
                    modifier = Modifier.semantics {
                        contentDescription = if (isSpeaking) "Detener lectura" else "Leer articulo en voz alta"
                    }
                ) {
                    Icon(
                        if (isSpeaking) Icons.Default.VolumeOff else Icons.Default.VolumeUp,
                        contentDescription = null,
                        tint = if (isSpeaking) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
        )
    }) { pv ->
        Column(Modifier.fillMaxSize().padding(pv).verticalScroll(rememberScrollState())) {

            // Selector de nivel de edad
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .semantics { contentDescription = "Selector de nivel. Mostrando contenido para ${selectedAge.label}." },
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AgeGroup.entries.forEach { age ->
                    FilterChip(
                        selected = age == selectedAge,
                        onClick = { selectedAge = age },
                        label = {
                            Text(when (age) {
                                AgeGroup.CHILD -> "Ninos"
                                AgeGroup.TEEN  -> "Adolescentes"
                                AgeGroup.ADULT -> "Adultos"
                            })
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
            }

            // Imagen del articulo
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
                    .clickable { onImageClick(0) }
                    .semantics { contentDescription = "Imagen del articulo. Toca para ampliar con zoom." },
                shape = RoundedCornerShape(12.dp)
            ) {
                if (url.isNotEmpty()) MuseumAsyncImage(url, "Imagen de $title", Modifier.fillMaxSize())
                else Box(
                    Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(LapisLazuli.copy(alpha = 0.4f), GoldDark.copy(alpha = 0.3f)))),
                    contentAlignment = Alignment.Center
                ) { Text("Toca para ampliar", style = MaterialTheme.typography.bodySmall, color = Color.White) }
            }

            Spacer(Modifier.height(16.dp))

            // Contenido del articulo
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .semantics { contentDescription = "Articulo: $title. Contenido para ${selectedAge.label}." }
            ) {
                Text(
                    title,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Contenido para ${selectedAge.label}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                )
                Box(
                    Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Brush.horizontalGradient(listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primary.copy(alpha = 0f)
                        )))
                )
                Text(
                    content,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 26.sp
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    "Desliza para ver el articulo anterior o siguiente",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}

private fun getTitle(sid: String, idx: Int) = when(sid) {
    "vida_cotidiana" -> listOf("Alimentacion y cocina","Vestimenta y joyeria","La familia egipcia","Juegos y entretenimiento","Medicina y salud").getOrElse(idx) { "Articulo" }
    "arquitectura"   -> listOf("Las Grandes Piramides de Giza","Templos de Karnak y Luxor","La Gran Esfinge","Tumbas del Valle de los Reyes","Obeliscos y columnas").getOrElse(idx) { "Articulo" }
    "arte"           -> listOf("Jeroglificos: escritura sagrada","Pintura mural y frescos","Escultura y estatuaria","Mascara de Tutankamon","Arte funerario y sarcofagos").getOrElse(idx) { "Articulo" }
    else -> "Articulo del Museo"
}

private fun getContent(sid: String, idx: Int, age: AgeGroup): String = when(sid) {

    "vida_cotidiana" -> when(idx) {
        0 -> when(age) {
            AgeGroup.CHILD  -> "En el Antiguo Egipto, el pan y la cerveza eran los alimentos mas importantes. Todos los dias, hombres y mujeres molian trigo para hacer harina. Con esa harina hacian mas de 40 tipos de pan de diferentes formas: redondos, triangulares o en forma de animales. La cerveza era la bebida favorita de ninos y adultos porque el agua del Nilo no siempre era limpia. Tambien comian pescado, cebollas, ajos, lentejas, higos y datiles. El modelo de panaderia que ves en la imagen viene de la tumba de un funcionario llamado Meketre, quien queria tener pan y cerveza para siempre en la otra vida."
            AgeGroup.TEEN   -> "La dieta egipcia giraba en torno al pan y la cerveza, los dos pilares de la alimentacion para todas las clases sociales. El pan se elaboraba con trigo emmer molido en piedras de cuarzo, lo que dejo huellas de desgaste en los dientes de las momias estudiadas. Se conocen mas de 40 variedades de pan. La cerveza, elaborada por fermentacion de pan de cebada, tenia un alto valor nutritivo y se usaba incluso como moneda de pago para los obreros que construyeron las piramides. El modelo de panaderia de la tumba de Meketre ilustra el proceso: muestra figurillas de cocineras amasando, horneando y preparando cerveza."
            AgeGroup.ADULT  -> "La alimentacion del Antiguo Egipto refleja una sociedad agricola altamente organizada. El pan y la cerveza constituian la base de la dieta de todas las clases sociales; el papiro Anastasi IV registra raciones diarias de dos jarras de cerveza y tres panes para trabajadores del Estado. El trigo emmer y la cebada eran los cultivos principales, aprovechando las crecidas anuales del Nilo. El modelo de panaderia de la tumba de Meketre, fechado hacia 2009-1998 a.C., ofrece una reconstruccion tridimensional del proceso productivo con figuras articuladas que amasan, hornean y filtran cerveza. Los analisis bioquimicos de residuos en vasijas confirman tecnicas de fermentacion controlada."
        }
        1 -> when(age) {
            AgeGroup.CHILD  -> "Los egipcios usaban ropa hecha de lino, una planta que crecia junto al Nilo. El lino era blanco, fresco y comodo para el calor del desierto. Los ninos pequenos muchas veces jugaban sin ropa. Las mujeres llevaban vestidos largos y los hombres faldas cortas llamadas shendyt. Para protegerse del sol, se pintaban los ojos con kohl negro. Las joyas eran muy importantes: usaban collares, pulseras y aros hechos de oro, plata y piedras coloridas. La estatuilla muestra a una dama noble con una peluca elaborada y un vestido de lino fino."
            AgeGroup.TEEN   -> "El lino era el tejido principal en Egipto gracias a su frescura en el clima desertico. Existian diferentes calidades: el lino grueso para obreros y el lino real, tan fino que era casi transparente, reservado para la nobleza. La vestimenta masculina tipica era el shendyt. Las pelucas de pelo humano o fibras vegetales eran simbolo de estatus. El kohl, elaborado de galena o malaquita, protegia los ojos del sol y tenia propiedades antisepticas. La estatuilla de Lady Tiye muestra la elegancia del Imperio Nuevo: lino plisado de alta calidad y joyeria de lapislazuli, cornalina y oro."
            AgeGroup.ADULT  -> "El lino era el textil exclusivo del Antiguo Egipto; la lana se consideraba ritualmente impura. Los tejedores dominaron tecnicas de torsion en S y torsion en Z, produciendo desde telas de 200 hilos por centimetro para el vestido real hasta tejidos bastos para uso cotidiano. La estatuilla de Lady Tiye ilustra la moda de la elite del Imperio Nuevo: vestido de lino plisado con mangas acampanadas, peluca tripartita y collar usekh con cuentas de fayenza azul, cornalina y oro. El kohl posee propiedades bacteriostaticas comprobadas; el aceite de ricino y la mirra hidrataban la piel."
        }
        2 -> when(age) {
            AgeGroup.CHILD  -> "En el Antiguo Egipto, la familia era lo mas importante. El papa trabajaba en el campo, en talleres o para el faraon. La mama cuidaba la casa, cocinaba y ensenaba a los hijos. Los ninos ayudaban en casa y aprendian el oficio de sus padres. La estatua muestra a un hombre llamado Nikare con su esposa y su hija. Sus brazos rodeandolas significa que los amaba y los protegia. En Egipto, las mujeres podian tener propiedades, ir a juicio y divorciarse, algo muy avanzado para aquella epoca."
            AgeGroup.TEEN   -> "La familia egipcia era la unidad fundamental de la sociedad. El matrimonio no tenia ceremonia religiosa formal: la pareja simplemente comenzaba a vivir junta. Las mujeres tenian derechos legales notables: podian poseer tierra, heredar bienes, hacer contratos y divorciarse. El grupo familiar esculpido de Nikare es un ejemplo del ideal de familia egipcia: el hombre con postura frontal de autoridad, la esposa abrazandolo y la hija a sus pies. Esta iconografia se repite en miles de estatuas funerarias, pues representar a la familia aseguraba su reunion en el Mas Alla."
            AgeGroup.ADULT  -> "La estructura familiar egipcia combinaba normas patriarcales con derechos femeninos sorprendentemente amplios. Los documentos legales muestran a mujeres actuando como partes independientes en contratos de prestamo, compraventa y divorcio. El contrato matrimonial establecia los bienes aportados y la compensacion en caso de repudio. El grupo estatuario de Nikare con su esposa e hija, tallado en caliza pintada hacia 2381-2323 a.C., encarna el ideal iconografico de la familia cohesionada. El tamano relativo de las figuras refleja jerarquia: la colocacion de estatuas familiares en la tumba garantizaba la perpetuacion del vinculo en la eternidad."
        }
        3 -> when(age) {
            AgeGroup.CHILD  -> "A los ninos egipcios les encantaba jugar! Tenian munecas de madera, pelotas de cuero rellenas de semillas y trompos. El juego de mesa mas famoso se llamaba Senet. Tambien habia un juego llamado Perros y Chacales: es un tablero con agujeros y fichas en forma de cabezas de perro y de chacal. Los adultos jugaban al Senet como si fuera un viaje al Mas Alla. El deporte favorito era la lucha libre, y tambien hacian carreras, lanzamiento de jabalina y natacion en el Nilo."
            AgeGroup.TEEN   -> "El ocio egipcio era rico y variado. El Senet, el juego de mesa mas antiguo conocido (ca. 3100 a.C.), era tan popular que los faraones lo llevaban a sus tumbas. El tablero Hounds and Jackals es un juego de carreras con 58 agujeros en un tablero de marfil con fichas de cabeza zoomorfa. Los deportes incluian lucha, natacion, remo y tiro con arco. La musica acompanaba celebraciones: arpa, flauta, oboe doble y sistro formaban parte del repertorio. Los banquetes de la elite incluian actuaciones de acrobatas y danzarinas."
            AgeGroup.ADULT  -> "El Senet, documentado desde el periodo Predinastico, evoluciono de juego de azar a metafora del viaje del alma a traves del Duat. El Libro de los Muertos muestra al difunto jugando al Senet como prueba de su idoneidad para el Mas Alla. El juego Hounds and Jackals, elaborado en marfil, madera de ebano y cobre hacia 1814-1805 a.C., es uno de los 23 ejemplares conocidos mundialmente. Los analisis iconograficos de tumbas documentan actividades atleticas: lucha codificada, salto, natacion y juegos de pelota que prefiguran deportes modernos."
        }
        4 -> when(age) {
            AgeGroup.CHILD  -> "Los medicos egipcios eran muy listos! Sabian curar heridas, fijar huesos rotos y hacer operaciones sencillas. Usaban plantas como el ajo y la cebolla para combatir enfermedades. Tambien hacian pociones con miel, porque la miel mata los germenes. La estela muestra al dios Horus nino de pie sobre cocodrilos. La gente la colocaba cerca del agua y la mojaba: el agua que la tocaba se volvia magica y curaba mordeduras de animales y enfermedades."
            AgeGroup.TEEN   -> "La medicina egipcia combinaba conocimiento empirico y ritual magico-religioso. El Papiro Edwin Smith es el primer texto medico-quirurgico conocido: describe 48 casos de traumatismo con diagnostico y pronostico, incluyendo la primera descripcion del cerebro y el pulso. El Papiro Ebers cataloga mas de 700 remedios a base de plantas y minerales. La miel, el aceite de ricino y el ajo tenian propiedades antibacterianas comprobadas. La estela magica de Horus era un objeto terapeutico: el agua vertida sobre ella se bebia como antidoto contra venenos."
            AgeGroup.ADULT  -> "La medicina egipcia representa el primer sistema medico documentado de la historia. El Papiro Edwin Smith introduce el metodo de observacion, palpacion, diagnostico diferencial y pronostico en 48 casos de trauma. Los analisis de momias evidencian arteriosclerosis, tuberculosis, malaria y parasitosis intestinal, asi como intervenciones quirurgicas exitosas con vendajes de lino impregnados de miel y resina. La estela magica de Horus sintetiza la terapeutica egipcia: el contacto del agua con los relieves de Horus conquistando serpientes y cocodrilos transferia poder apotropaico al liquido consumido como antidoto."
        }
        else -> "Contenido no disponible."
    }

    "arquitectura" -> when(idx) {
        0 -> when(age) {
            AgeGroup.CHILD  -> "Las piramides son las construcciones mas famosas del mundo! Fueron construidas hace mas de 4,500 anos como tumbas para los faraones. La mas grande es la Gran Piramide de Keops en Giza: mide casi 140 metros de alto y tiene mas de 2 millones de bloques de piedra. Antes de las piramides existian las mastabas, que son tumbas con forma de rectangulo achatado. La mastaba de Perneb fue construida en Saqqara hace unos 4,400 anos para un funcionario importante. Por dentro tiene capillas decoradas con relieves de ofrendas."
            AgeGroup.TEEN   -> "Las piramides evolucionaron a partir de las mastabas, tumbas rectangulares de adobe o piedra caliza. El arquitecto Imhotep disenno la primera piramide escalonada para el faraon Djoser en Saqqara (ca. 2667 a.C.), apilando seis mastabas decrecientes. La piramide perfecta de cuatro caras lisas se logro bajo el faraon Sneferu. La Gran Piramide de Keops, con 138.8 m de altura actual, permanecio como el edificio mas alto del mundo durante 3,800 anos. La mastaba de Perneb representa la forma arquitectonica que precedio a las piramides."
            AgeGroup.ADULT  -> "La arquitectura funeraria egipcia sigue una linea evolutiva documentada arqueologicamente: desde la tumba en pozo predinastica hasta la mastaba de adobe del periodo Tinita, la piramide escalonada de Djoser y la piramide perfecta a partir de Sneferu. La mastaba de Perneb, desmontada en Saqqara en 1913 y reconstruida en el Metropolitan Museum, data de la Dinastia V (ca. 2381-2323 a.C.). El complejo piramidal de Giza es el resultado de una organizacion estatal capaz de movilizar entre 20,000 y 30,000 trabajadores estacionales, segun los registros del puerto de Wadi al-Jarf."
        }
        1 -> when(age) {
            AgeGroup.CHILD  -> "Los templos egipcios eran la casa de los dioses! Solo los sacerdotes podian entrar a las partes mas internas. El Templo de Dendur fue construido hace mas de 2,000 anos cerca del rio Nilo. Tiene una puerta gigante llamada pilono, un patio abierto y una sala oscura donde vivian las estatuas de los dioses. El gobierno de Egipto lo regalo a los Estados Unidos en 1965 para salvarlo de una inundacion. Hoy puedes verlo completo dentro del Museo Metropolitano de Nueva York."
            AgeGroup.TEEN   -> "El templo egipcio no era un lugar de culto publico: era la residencia sagrada de la deidad. Solo el faraon y los sacerdotes podian acceder al naos. La arquitectura tipica incluye: pilono, patio hipetro, sala hipostila y santuario. El Templo de Dendur (ca. 15 a.C.), erigido por el emperador romano Augusto para honrar a Isis, es el unico templo egipcio completo fuera de Africa. Sus muros muestran a Augusto vestido como faraon, estrategia politica de legitimacion del poder romano en Egipto."
            AgeGroup.ADULT  -> "El templo egipcio es la materializacion arquitectonica del mito de la creacion: el naos representa el montaculo primordial, la sala hipostila el pantano primigenio y las columnas papiriformes la vegetacion que surgio del caos. El Templo de Dendur, construido entre 15 a.C. y 10 a.C. por orden de Augusto, ilustra la continuidad iconografica bajo el dominio romano: las escenas de ofrenda muestran al emperador con doble corona y nomenclatura faraonica. Su traslado al Metropolitan Museum entre 1963 y 1968 representa uno de los proyectos de conservacion mas complejos del siglo XX."
        }
        2 -> when(age) {
            AgeGroup.CHILD  -> "La Esfinge es una escultura con cuerpo de leon y cabeza de persona. El leon representaba fuerza y poder. La Gran Esfinge de Giza fue tallada directamente en la roca hace unos 4,500 anos y mide 73 metros de largo. La esfinge de la imagen es de la faraona Hatshepsut, una mujer que goberno Egipto como si fuera un rey. Ella se hizo representar como esfinge para mostrar que tenia el mismo poder que cualquier faraon. Fue una de las gobernadoras mas importantes de Egipto."
            AgeGroup.TEEN   -> "Las esfinges egipcias simbolizaban la fusion del poder del faraon con la ferocidad del leon, guardian del horizonte solar. La Gran Esfinge de Giza (ca. 2558-2532 a.C.) fue tallada en un afloramiento de caliza en el complejo funerario de Khafre y mide 73 m de largo. La esfinge de Hatshepsut es uno de los mas de 200 ejemplares que ella encargo. Hatshepsut adopto la iconografia masculina para reforzar su legitimidad. Tras su muerte, Tutmosis III ordeno borrar su nombre e imagen de los monumentos."
            AgeGroup.ADULT  -> "La esfinge es un hibrido iconografico: el cuerpo leonino aporta la cualidad solar-apotropaica mientras el rostro real identifica al gobernante con Ra-Horakhty. La Gran Esfinge de Giza, tallada en la caliza del Muqqatam in situ, es nombrada como Hor-em-akhet en la Estela del Sueno de Tutmosis IV. La esfinge de Hatshepsut pertenece a una serie producida para el corredor procesional del templo de Deir el-Bahari en Luxor. El programa damnatio memoriae de Tutmosis III implico su enterramiento bajo el piso del templo, lo que paradojicamente las conservo hasta las excavaciones del Metropolitan Museum (1926-1928)."
        }
        3 -> when(age) {
            AgeGroup.CHILD  -> "El Valle de los Reyes es un lugar secreto en Egipto donde los faraones escondian sus tumbas bajo la tierra. Las tumbas tienen largos pasillos, trampas y camaras llenas de muebles, joyas y comida para la otra vida. El sarcofago que ves es el ataud de piedra de un funcionario importante, con inscripciones magicas del Libro de los Muertos. En 1922, el arqueologo Howard Carter descubrio la tumba casi intacta del faraon Tutankamon, llena de miles de objetos de oro."
            AgeGroup.TEEN   -> "El Valle de los Reyes fue el cementerio real del Imperio Nuevo (ca. 1550-1070 a.C.), elegido por su aislamiento y la montana natural con forma piramidal. Se conocen 63 tumbas numeradas. El sarcofago monolitico de Harkhebit, del periodo Tardio (Dinastia 26), esta cubierto de inscripciones del Libro de los Muertos. El descubrimiento de KV62 (Tutankamon) por Howard Carter en 1922 es el hallazgo arqueologico mas meditico del siglo XX: la camara del tesoro contenia mas de 5,000 objetos."
            AgeGroup.ADULT  -> "La eleccion del Valle de los Reyes como necropolis real desde Tutmosis I responde a una estrategia defensiva y teologica: la montana piramidal natural consagraba el lugar a Meretseger, diosa cobra protectora. El sarcofago de Harkhebit es un ejemplo del renacimiento arcaizante de la Dinastia 26, que copiaba formulas del Imperio Antiguo. La topografia geomorfica del valle, estudiada con LiDAR y tomografia de resistividad electrica, sugiere la existencia de camaras no excavadas, avalando hipotesis de nuevas tumbas por descubrir."
        }
        4 -> when(age) {
            AgeGroup.CHILD  -> "Los obeliscos son como lapices de piedra gigantes que los egipcios construyeron para honrar al dios Sol. Estan cubiertos de jeroglificos que cuentan las hazanas del faraon. La punta, llamada piramidion, estaba cubierta de oro para que brillara con el sol. La faraona Hatshepsut mando construir los obeliscos mas altos de su epoca en el templo de Karnak: median casi 30 metros de alto! La estatua muestra a Hatshepsut arrodillada ofreciendo vasijas a los dioses."
            AgeGroup.TEEN   -> "Los obeliscos eran monolitos de granito rosa de Asuan, considerados manifestaciones del benben, la piedra sagrada primordial. Su piramidion de electrum captaba el primer rayo de sol del amanecer. Los dos obeliscos de Hatshepsut en Karnak, erigidos en su ano 16 de reinado, median originalmente 28 y 29.5 metros. Los obeliscos egipcios fueron tan admirados que emperadores romanos trasladaron 13 a Roma; hoy hay mas obeliscos egipcios en Roma que en Egipto."
            AgeGroup.ADULT  -> "El obelisco reproduce la piedra benben del templo de Ra en Heliopolis, la cual segun el mito de la creacion emergio del caos primordial y recibio el primer rayo solar. El piramidion de electrum actuaba como heliostato, proyectando reflejos luminosos sobre el patio del templo durante el amanecer. Los obeliscos de Hatshepsut en Karnak, los mas altos que permanecen en Egipto (29.56 m el superviviente), fueron trasladados desde las canteras de Asuan en barcazas especiales segun modelos hidraulicos modernos."
        }
        else -> "Contenido no disponible."
    }

    "arte" -> when(idx) {
        0 -> when(age) {
            AgeGroup.CHILD  -> "Los jeroglificos son los dibujos que usaban los egipcios para escribir. Hay mas de 700 simbolos diferentes: algunos representan letras, otros palabras enteras. Dibujaban pajaros, serpientes, ojos, personas y muchas cosas mas. Solo los escribas sabian leer y escribir jeroglificos. Durante mas de 1,400 anos nadie entendio los jeroglificos hasta que en 1822 un frances llamado Jean-Francois Champollion descifro su secreto usando la Piedra Rosetta, que tiene el mismo texto en tres idiomas."
            AgeGroup.TEEN   -> "El sistema de escritura jeroglifica combina logogramas, fonogramas y determinativos. Se usaba para textos religiosos y monumentales, mientras que el hieratico y el demotico se usaban para textos administrativos cotidianos. El santuario de Amenemhat muestra como los textos sagrados organizaban el espacio arquitectonico. El descifrado de Champollion en 1822 se baso en la Piedra Rosetta (196 a.C.), que contiene el mismo decreto real en jeroglificos, demotico y griego."
            AgeGroup.ADULT  -> "La escritura jeroglifica es un sistema logofonografico con aproximadamente 750 grafemas en el Imperio Antiguo, ampliados a mas de 6,000 en el periodo ptolemaico. Su estructura tripartita confiere una redundancia semantica que facilita el descifrado. El descifrado de Champollion (1822) establece la correspondencia fonologica del cartucho de Ptolomeo con su forma griega. La epigrafia computacional moderna aplica reconocimiento optico de caracteres para catalogar los 5 millones de inscripciones estimadas."
        }
        1 -> when(age) {
            AgeGroup.CHILD  -> "Los egipcios eran pintores increibles! Decoraban las paredes de las tumbas con colores muy brillantes. Usaban seis colores principales: rojo, amarillo, verde, azul, blanco y negro, todos hechos de minerales. Una de las pinturas mas famosas muestra a un gato, que representa al dios Ra, cortandole la cabeza a una serpiente maligna llamada Apofis. En Egipto, los gatos eran animales sagrados protegidos por ley. Matar uno era un delito muy grave."
            AgeGroup.TEEN   -> "La pintura mural egipcia siguio convenciones rigidas durante mas de 3,000 anos: la figura humana se representa con cabeza y piernas de perfil pero ojo y torso de frente. La paleta incluia seis pigmentos minerales, entre ellos el azul egipcio, el primer pigmento sintetico de la historia. La escena del gato bajo el persea decapitando a la serpiente Apofis ilustra el capitulo 17 del Libro de los Muertos: Ra en forma felina destruye cada noche a Apofis, garantizando el amanecer."
            AgeGroup.ADULT  -> "La pintura mural egipcia opera bajo un codigo de representacion aspektiv: cada elemento se dibuja desde su angulo mas reconocible, garantizando la identificabilidad de cada parte del cuerpo para asegurar la integridad magica de la imagen. La paleta sexcromatica incluyo el azul egipcio, producido calcinando cuarzo, malaquita y calcita a novecientos grados, siendo el primer pigmento sintetico de la historia. El analisis por espectroscopia confirma la presencia de goethita, hematita y cuprorivaita con aglutinante de polisacaridos."
        }
        2 -> when(age) {
            AgeGroup.CHILD  -> "Los escultores egipcios tallaban estatuas de piedra, madera y bronce. Las estatuas servian para que el espiritu del muerto pudiera habitarlas y recibir ofrendas. La escultura muestra a la faraona Hatshepsut sentada, con peluca y corona. Su cara es serena y perfecta. Los escultores empezaban dibujando una cuadricula en la piedra para asegurarse de que las proporciones fueran correctas. Las estatuas mas grandes, los colosos, podian medir 20 metros de alto!"
            AgeGroup.TEEN   -> "La escultura egipcia se rige por el canon de proporciones: el cuerpo humano se divide en 18 cuadros desde la planta del pie hasta la linea del cabello. Los materiales mas valorados eran la caliza blanca, el granito rosa de Asuan y el esquisto verde. La escultura de Hatshepsut sentada muestra la convencion real: postura frontal rigida, manos sobre las rodillas, mirada al frente. Tras la damnatio memoriae de Tutmosis III, estas estatuas fueron fragmentadas y enterradas en una fosa, descubierta en las excavaciones de 1926-1928."
            AgeGroup.ADULT  -> "La escultura egipcia articula una relacion dialectica entre tridimensionalidad formal y bidimensionalidad ritual: la estatua de culto es ante todo un soporte para el ka del difunto. El canon de proporciones, 18 cuadros en el Imperio Antiguo y Medio y 21 en el Tardio, garantiza la integridad magica de la figura independientemente de su escala. La fractura intencional de la escultura de Hatshepsut y el enterramiento posterior paradojicamente conservaron el pigmento rojo original en la piel de la faraona, identificado por fluorescencia de rayos X como hematita."
        }
        3 -> when(age) {
            AgeGroup.CHILD  -> "Las mascaras funerarias cubrian el rostro de los muertos para que los dioses los reconocieran en la otra vida. La mas famosa es la mascara de oro de Tutankamon que pesa 11 kilos! La mascara de Hatnefer esta hecha de capas de lino pegadas con yeso y luego pintada de dorado. Los ojos estan hechos de obsidiana negra y alabastro blanco. Las mascaras tenian inscripciones del Libro de los Muertos que protegian al difunto y le daban el poder de ver y hablar en el otro mundo."
            AgeGroup.TEEN   -> "La mascara funeraria garantizaba una identidad permanente al ka, o espiritu vital, del difunto. La mascara de Hatnefer, madre del arquitecto Senenmut, data de alrededor de 1492 a 1473 antes de Cristo. Esta construida en cartonaje con incrustaciones de obsidiana, alabastro y pasta de vidrio. La mascara de Tutankamon pesa mas de 10 kilos de oro con incrustaciones de lapislazuli, cornalina y turquesa. Sus inscripciones corresponden al capitulo 151 del Libro de los Muertos: un sortilegio para proteger al difunto."
            AgeGroup.ADULT  -> "La mascara funeraria es el punto de convergencia entre tecnologia artesanal, teologia del ka y estetica de la eternidad. El cartonaje se obtiene superponiendo tiras de lino o papiro sobre una forma provisional, impregnandolas con yeso calcinado y poliendolas antes de la decoracion policroma. Los ojos de obsidiana y alabastro reproducen la convencion del ojo sagrado, el wedjat. Los estudios de fluorescencia de rayos X identifican oro de alta pureza en las areas faciales y plata en los surcos de la peluca, reflejando la cosmologia estelar donde el oro representa al sol y la plata a la luna."
        }
        4 -> when(age) {
            AgeGroup.CHILD  -> "Los sarcofagos son los atades decorados donde los egipcios guardaban a sus muertos. A veces habia hasta tres o cuatro cajas una dentro de la otra. Por fuera estaban llenos de pinturas y jeroglificos con oraciones para proteger al muerto. El sarcofago de Henettawy es de una cantora que cantaba para el dios Amun-Ra. Dentro del sarcofago ponian figuras llamadas ushebtis que actuarian como sirvientes en la otra vida, y vasos canopicos con los organos del muerto."
            AgeGroup.TEEN   -> "El sarcofago egipcio es un sistema de proteccion progresiva: la momia en su envoltura de lino, dentro de una o varias cajas de madera decorada, dentro de un sarcofago de piedra. El sarcofago de Henettawy, cantora de Amun-Ra del Tercer Periodo Intermedio, es un ejemplar del estilo tebano tardio: fondo amarillo simbolizando el oro de la eternidad y escenas del Libro de los Muertos en bandas horizontales. Los ushebtis de fayenza azul eran sustitutos magicos del difunto para realizar las corveas agricolas en el Mas Alla."
            AgeGroup.ADULT  -> "El sarcofago egipcio articula en un mismo objeto la funcion contenedora, la proteccion magica, la identificacion del difunto y la narracion escatologica. El sarcofago de Henettawy pertenece al estilo tebano de fondo amarillo con policromia en rojo, azul, verde y blanco. El programa iconografico integra escenas del Libro de los Muertos, representacion de los cuatro hijos de Horus y la diosa Nut en el interior de la tapa con las alas desplegadas. El analisis dendrocronologico identifica Ficus sycomorus como madera utilizada, arbol funerario por excelencia en el Antiguo Egipto."
        }
        else -> "Contenido no disponible."
    }

    else -> "Selecciona una seccion para ver su contenido."
}
