package com.example.gplascenciamusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gplascenciamusicapp.components.AlbumDetailCardRow
import com.example.gplascenciamusicapp.components.DetailAlbumImage
import com.example.gplascenciamusicapp.components.ReproductorCard
import com.example.gplascenciamusicapp.models.Album
import com.example.gplascenciamusicapp.services.AlbumService
import com.example.gplascenciamusicapp.ui.theme.AlbumDetailColor
import com.example.gplascenciamusicapp.ui.theme.BackGroundGradient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AlbumDetailScreen(id: String, navController: NavController) {
    // Objeto clickeado y accedido mediante su id
    var album by remember {
        mutableStateOf<Album?>(null)
    }
    // Variable para estado en lo que se consume la API
    var loading by remember {
        mutableStateOf(true)
    }
    // DEBUG: Verificar el ID que llega
    Log.i("AlbumDetailScreen", "ID recibido: '$id'")
    LaunchedEffect(id) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = withContext(Dispatchers.IO){
                service.getAlbumById(id)
            }
            album = result
            loading = false
            Log.i("AlbumDetailScreen", album.toString())
        }
        catch (e: Exception){
            loading = false
            Log.e("AlbumDetailScreen", e.toString())
        }
    }
    // Animacion mientras carga
    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackGroundGradient),
            contentAlignment = Alignment.Center
        ) {
            Text("Cargando álbum...", color = Color.White)
        }
        return
    }
    if (album == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackGroundGradient),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("No se pudo cargar el álbum", color = Color.White)
                Text("ID: $id", color = Color.White)
            }
        }
        return
    }
    // INICIO UI
    Column(modifier = Modifier
        .fillMaxSize()
        .background(BackGroundGradient)
        .padding(top = 45.dp, start =  15.dp, end = 15.dp, bottom = 15.dp)) {
        // IMAGEN DEL ALBUM PRINCIPAL
        DetailAlbumImage(album, navController)
        // Tarjeta de descripcion
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(AlbumDetailColor)
        ) {
            // Texto sobre el album
            Text(
                text = "About this album",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, bottom = 5.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            // Descripcion del album
            Text(
                text = album?.description ?: "Descripción no disponible",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 8.dp   ),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        // Contenedor para el artista
        Column(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(AlbumDetailColor)
        ) {
            // Artista del album
            Text(
                text = album?.artist ?: "Artista no disponible",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        // Mostrar los Tracks del album, Contenedor principal para un LazyColumn
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            // Se mostraran las tarjetas de cada Track
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(10){ count ->
                    AlbumDetailCardRow(album, count)
                }
            }
            // Contenedor para el reproductor fijo en la parte inferior
            Box(
                modifier = Modifier.align(Alignment.BottomCenter)
            ){
                ReproductorCard(album)
            }
        }
    }
}
