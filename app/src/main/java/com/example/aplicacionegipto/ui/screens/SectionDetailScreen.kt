package com.example.aplicacionegipto.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.graphics.vector.ImageVector
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
    data class SI(val id:String,val title:String,val icon:String,val desc:String,val gc:List<Color>)
    val info=when(sectionId){"vida_cotidiana"->SI(sectionId,"Vida Cotidiana","🏺","Sumérgete en la vida diaria del Antiguo Egipto.",listOf(OcreEgypt,GoldDark));"arquitectura"->SI(sectionId,"Arquitectura","🏛️","Explora las imponentes construcciones que desafiaron el tiempo.",listOf(LapisLazuli,TurquoiseEgypt));"arte"->SI(sectionId,"Arte","🎨","Contempla la expresión artística de una civilización milenaria.",listOf(RedDesert,OcreEgypt));else->SI(sectionId,"Sección","📖","",listOf(GoldDark,GoldPharaoh))}
    val articles=when(sectionId){"vida_cotidiana"->listOf("Alimentación y cocina" to "Los egipcios disfrutaban de pan, cerveza, frutas y pescado del Nilo...","Vestimenta y joyería" to "El lino era el tejido principal...","La familia egipcia" to "La familia era el centro de la sociedad...","Juegos y entretenimiento" to "El Senet era el juego más popular...","Medicina y salud" to "Los médicos egipcios eran reconocidos...");"arquitectura"->listOf("Las Grandes Pirámides de Giza" to "Las pirámides son el símbolo más reconocido...","Templos de Karnak y Luxor" to "Los complejos de templos más grandes...","La Gran Esfinge" to "Con cuerpo de león y cabeza humana...","Tumbas del Valle de los Reyes" to "El lugar de descanso eterno de los faraones...","Obeliscos y columnas" to "Monumentos verticales que conectaban la tierra con los dioses...");"arte"->listOf("Jeroglíficos: escritura sagrada" to "El sistema de escritura más antiguo...","Pintura mural y frescos" to "Las paredes de templos cobran vida con colores vibrantes...","Escultura y estatuaria" to "Desde pequeños amuletos hasta colosos de piedra...","Máscara de Tutankamón" to "La obra maestra de la orfebrería egipcia...","Arte funerario y sarcófagos" to "Elaborados ataúdes decorados...");else-> emptyList()}
    var visible by remember{mutableStateOf(false)};LaunchedEffect(Unit){visible=true}
    Scaffold(topBar={TopAppBar(title={Text(info.title,style=MaterialTheme.typography.titleLarge.copy(fontWeight=FontWeight.Bold))},navigationIcon={IconButton(onClick=onBack,modifier=Modifier.semantics{contentDescription="Regresar"}){Icon(Icons.AutoMirrored.Filled.ArrowBack,null)}},colors=TopAppBarDefaults.topAppBarColors(containerColor=MaterialTheme.colorScheme.background))}){pv->
        LazyColumn(Modifier.fillMaxSize().padding(pv),contentPadding=PaddingValues(bottom=24.dp),verticalArrangement=Arrangement.spacedBy(16.dp)){
            item{Card(Modifier.fillMaxWidth().padding(horizontal=16.dp),shape=RoundedCornerShape(16.dp)){Box(Modifier.fillMaxWidth().background(Brush.horizontalGradient(info.gc)).padding(20.dp)){Column{Row(verticalAlignment=Alignment.CenterVertically,horizontalArrangement=Arrangement.spacedBy(12.dp)){Text(info.icon,fontSize=40.sp);Text(info.title.uppercase(),style=MaterialTheme.typography.headlineMedium.copy(fontWeight=FontWeight.Bold,letterSpacing=2.sp),color=Color.White)};Spacer(Modifier.height(8.dp));Text(info.desc,style=MaterialTheme.typography.bodyLarge,color=Color.White.copy(alpha=0.9f))}}}}
            item{Row(Modifier.fillMaxWidth().padding(horizontal=16.dp),horizontalArrangement=Arrangement.spacedBy(12.dp)){
                listOf(Triple(Icons.Default.PhotoLibrary,"Galería",onGalleryClick),Triple(Icons.Default.MusicNote,"Audio",onAudioClick),Triple(Icons.Default.VideoLibrary,"Video",onVideoClick)).forEach{(ic,lb,oc)->Card(Modifier.weight(1f).clickable(onClick=oc),shape=RoundedCornerShape(12.dp),colors=CardDefaults.cardColors(containerColor=MaterialTheme.colorScheme.primaryContainer.copy(alpha=0.3f))){Column(Modifier.fillMaxWidth().padding(12.dp),horizontalAlignment=Alignment.CenterHorizontally){Icon(ic,null,tint=MaterialTheme.colorScheme.primary,modifier=Modifier.size(28.dp));Text(lb,style=MaterialTheme.typography.labelMedium,color=MaterialTheme.colorScheme.primary)}}}}}
            item{val urls=MuseumRepository.getImageUrls(sectionId);val imgs=MuseumRepository.getImages(sectionId);Column(Modifier.padding(horizontal=16.dp)){Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween,verticalAlignment=Alignment.CenterVertically){Text("🖼️ Imágenes",style=MaterialTheme.typography.headlineSmall.copy(fontWeight=FontWeight.Bold),color=MaterialTheme.colorScheme.primary);TextButton(onClick=onGalleryClick){Text("Ver todas →")}};Spacer(Modifier.height(8.dp));LazyRow(horizontalArrangement=Arrangement.spacedBy(12.dp)){items(urls.size.coerceAtMost(10)){i->Card(Modifier.size(140.dp,100.dp),shape=RoundedCornerShape(8.dp)){MuseumAsyncImage(urls[i],imgs.getOrNull(i)?.contentDescription?:"Imagen",Modifier.fillMaxSize())}}}}}
            item{Text("📜 Artículos",style=MaterialTheme.typography.headlineSmall.copy(fontWeight=FontWeight.Bold),modifier=Modifier.padding(horizontal=16.dp),color=MaterialTheme.colorScheme.primary)}
            itemsIndexed(articles){idx,art->Card(Modifier.fillMaxWidth().padding(horizontal=16.dp).clickable(onClick={onArticleClick("article_$idx")}),shape=RoundedCornerShape(12.dp),elevation=CardDefaults.cardElevation(2.dp)){Row(Modifier.fillMaxWidth().padding(16.dp),verticalAlignment=Alignment.CenterVertically,horizontalArrangement=Arrangement.spacedBy(12.dp)){Box(Modifier.size(44.dp).background(MaterialTheme.colorScheme.primary.copy(alpha=0.15f),CircleShape),contentAlignment=Alignment.Center){Text("${idx+1}",style=MaterialTheme.typography.titleMedium.copy(fontWeight=FontWeight.Bold),color=MaterialTheme.colorScheme.primary)};Column(Modifier.weight(1f)){Text(art.first,style=MaterialTheme.typography.titleMedium.copy(fontWeight=FontWeight.SemiBold));Spacer(Modifier.height(4.dp));Text(art.second,style=MaterialTheme.typography.bodySmall,color=MaterialTheme.colorScheme.onSurface.copy(alpha=0.7f),maxLines=2,overflow=TextOverflow.Ellipsis)};Icon(Icons.Default.ChevronRight,null,tint=MaterialTheme.colorScheme.primary.copy(alpha=0.6f))}}}
        }
    }
}
