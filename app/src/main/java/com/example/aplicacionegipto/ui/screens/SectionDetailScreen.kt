package com.example.aplicacionegipto.ui.screens
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionegipto.data.MuseumRepository
import com.example.aplicacionegipto.ui.components.MuseumAsyncImage
import com.example.aplicacionegipto.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SectionDetailScreen(sectionId:String,onArticleClick:(String)->Unit,onGalleryClick:()->Unit,onAudioClick:()->Unit,onVideoClick:()->Unit,onBack:()->Unit){
    val title=when(sectionId){"vida_cotidiana"->"Vida Cotidiana";"arquitectura"->"Arquitectura";"arte"->"Arte";else->"Seccion"}
    val icon=when(sectionId){"vida_cotidiana"->"\uD83C\uDFFA";"arquitectura"->"\uD83C\uDFDB";"arte"->"\uD83C\uDFA8";else->"\uD83D\uDCD6"}
    val desc=when(sectionId){"vida_cotidiana"->"Sumergete en la vida diaria del Antiguo Egipto.";"arquitectura"->"Explora las imponentes construcciones.";"arte"->"Contempla la expresion artistica milenaria.";else->""}
    val gc=when(sectionId){"vida_cotidiana"->listOf(OcreEgypt,GoldDark);"arquitectura"->listOf(LapisLazuli,TurquoiseEgypt);"arte"->listOf(RedDesert,OcreEgypt);else->listOf(GoldDark,GoldPharaoh)}
    val articles=when(sectionId){
        "vida_cotidiana"->listOf("Alimentacion y cocina" to "Pan, cerveza y pescado del Nilo...","Vestimenta y joyeria" to "Lino y joyas elaboradas...","La familia egipcia" to "Centro de la sociedad...","Juegos y entretenimiento" to "El Senet era el mas popular...","Medicina y salud" to "Medicos reconocidos mundialmente...")
        "arquitectura"->listOf("Las Grandes Piramides" to "Simbolo del Antiguo Egipto...","Templos de Karnak" to "Los complejos mas grandes...","La Gran Esfinge" to "Cuerpo de leon, cabeza humana...","Valle de los Reyes" to "Descanso de los faraones...","Obeliscos" to "Conectaban tierra y dioses...")
        "arte"->listOf("Jeroglificos" to "Escritura mas antigua...","Pintura mural" to "Colores vibrantes...","Escultura" to "Amuletos hasta colosos...","Mascara de Tutankamon" to "Orfebreria magistral...","Arte funerario" to "Ataudes decorados...")
        else->emptyList()}
    Scaffold(topBar={TopAppBar(title={Text(title,style=MaterialTheme.typography.titleLarge.copy(fontWeight=FontWeight.Bold))},navigationIcon={IconButton(onClick=onBack){Icon(Icons.AutoMirrored.Filled.ArrowBack,"Regresar")}})}){
        LazyColumn(Modifier.fillMaxSize().padding(it),contentPadding=PaddingValues(bottom=24.dp),verticalArrangement=Arrangement.spacedBy(16.dp)){
            item{Card(Modifier.fillMaxWidth().padding(horizontal=16.dp),shape=RoundedCornerShape(16.dp)){Box(Modifier.fillMaxWidth().background(Brush.horizontalGradient(gc)).padding(20.dp)){Column{Row(verticalAlignment=Alignment.CenterVertically,horizontalArrangement=Arrangement.spacedBy(12.dp)){Text(icon,fontSize=40.sp);Text(title.uppercase(),style=MaterialTheme.typography.headlineMedium.copy(fontWeight=FontWeight.Bold,letterSpacing=2.sp),color=Color.White)};Spacer(Modifier.height(8.dp));Text(desc,style=MaterialTheme.typography.bodyLarge,color=Color.White.copy(alpha=0.9f))}}}}
            item{Row(Modifier.fillMaxWidth().padding(horizontal=16.dp),horizontalArrangement=Arrangement.spacedBy(12.dp)){
                Card(Modifier.weight(1f).clickable(onClick=onGalleryClick),shape=RoundedCornerShape(12.dp),colors=CardDefaults.cardColors(containerColor=TurquoiseEgypt.copy(alpha=0.15f))){Column(Modifier.fillMaxWidth().padding(12.dp),horizontalAlignment=Alignment.CenterHorizontally){Icon(Icons.Default.PhotoLibrary,null,tint=TurquoiseEgypt,modifier=Modifier.size(28.dp));Text("Galeria",style=MaterialTheme.typography.labelMedium,color=TurquoiseEgypt)}}
                Card(Modifier.weight(1f).clickable(onClick=onAudioClick),shape=RoundedCornerShape(12.dp),colors=CardDefaults.cardColors(containerColor=NileGreen.copy(alpha=0.15f))){Column(Modifier.fillMaxWidth().padding(12.dp),horizontalAlignment=Alignment.CenterHorizontally){Icon(Icons.Default.MusicNote,null,tint=NileGreen,modifier=Modifier.size(28.dp));Text("Audio",style=MaterialTheme.typography.labelMedium,color=NileGreen)}}
                Card(Modifier.weight(1f).clickable(onClick=onVideoClick),shape=RoundedCornerShape(12.dp),colors=CardDefaults.cardColors(containerColor=LapisLazuli.copy(alpha=0.15f))){Column(Modifier.fillMaxWidth().padding(12.dp),horizontalAlignment=Alignment.CenterHorizontally){Icon(Icons.Default.VideoLibrary,null,tint=LapisLazuli,modifier=Modifier.size(28.dp));Text("Video",style=MaterialTheme.typography.labelMedium,color=LapisLazuli)}}
            }}
            item{val urls=MuseumRepository.getImageUrls(sectionId);val imgs=MuseumRepository.getImages(sectionId);Column(Modifier.padding(horizontal=16.dp)){Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween,verticalAlignment=Alignment.CenterVertically){Text("Imagenes",style=MaterialTheme.typography.headlineSmall.copy(fontWeight=FontWeight.Bold),color=MaterialTheme.colorScheme.primary);TextButton(onClick=onGalleryClick){Text("Ver todas")}};Spacer(Modifier.height(8.dp));LazyRow(horizontalArrangement=Arrangement.spacedBy(12.dp)){items(urls.size.coerceAtMost(10)){i->Card(Modifier.size(140.dp,100.dp),shape=RoundedCornerShape(8.dp)){MuseumAsyncImage(urls[i],imgs.getOrNull(i)?.contentDescription?:"Imagen",Modifier.fillMaxSize())}}}}}
            item{Text("Articulos",style=MaterialTheme.typography.headlineSmall.copy(fontWeight=FontWeight.Bold),modifier=Modifier.padding(horizontal=16.dp),color=MaterialTheme.colorScheme.primary)}
            itemsIndexed(articles){idx,(t,p)->Card(Modifier.fillMaxWidth().padding(horizontal=16.dp).clickable{onArticleClick("article_$idx")},shape=RoundedCornerShape(12.dp),elevation=CardDefaults.cardElevation(2.dp)){Row(Modifier.fillMaxWidth().padding(16.dp),verticalAlignment=Alignment.CenterVertically,horizontalArrangement=Arrangement.spacedBy(12.dp)){Box(Modifier.size(44.dp).background(MaterialTheme.colorScheme.primary.copy(alpha=0.15f),CircleShape),contentAlignment=Alignment.Center){Text("${idx+1}",style=MaterialTheme.typography.titleMedium.copy(fontWeight=FontWeight.Bold),color=MaterialTheme.colorScheme.primary)};Column(Modifier.weight(1f)){Text(t,style=MaterialTheme.typography.titleMedium.copy(fontWeight=FontWeight.SemiBold));Spacer(Modifier.height(4.dp));Text(p,style=MaterialTheme.typography.bodySmall,color=MaterialTheme.colorScheme.onSurface.copy(alpha=0.7f),maxLines=2,overflow=TextOverflow.Ellipsis)};Icon(Icons.Default.ChevronRight,null,tint=MaterialTheme.colorScheme.primary.copy(alpha=0.6f))}}}
        }
    }
}
