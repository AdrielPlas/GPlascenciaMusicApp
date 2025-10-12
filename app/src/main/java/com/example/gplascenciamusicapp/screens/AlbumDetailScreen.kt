package com.example.gplascenciamusicapp.screens

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.gplascenciamusicapp.Main
import com.example.gplascenciamusicapp.components.AlbumDetailCardRow
import com.example.gplascenciamusicapp.components.DetailAlbumImage
import com.example.gplascenciamusicapp.components.ReproductorCard
import com.example.gplascenciamusicapp.models.Album
import com.example.gplascenciamusicapp.services.AlbumService
import com.example.gplascenciamusicapp.ui.theme.AlbumDetailColor
import com.example.gplascenciamusicapp.ui.theme.AlbumTitleColor
import com.example.gplascenciamusicapp.ui.theme.BackGroundCard
import com.example.gplascenciamusicapp.ui.theme.BackGroundGradient
import com.example.gplascenciamusicapp.ui.theme.BackGroundImageGradient
import com.example.gplascenciamusicapp.ui.theme.ButtonPlayGradient
import com.example.gplascenciamusicapp.ui.theme.GPlascenciaMusicAppTheme
import com.example.gplascenciamusicapp.ui.theme.ReproductorCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AlbumDetailScreen(id: String, navController: NavController) {
    var album by remember {
        mutableStateOf<Album?>(null)
    }
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
        // IMAGEN PRINCIPAL
        DetailAlbumImage(album, navController)
        // Tarjeta de descripcion
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(AlbumDetailColor)
        ) {
            Text(
                text = "About this album",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, bottom = 5.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = album?.description ?: "Descripción no disponible",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 8.dp   ),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        // Artistas
        Column(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(AlbumDetailColor)
        ) {
            Text(
                text = album?.artist ?: "Artista no disponible",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        // Tracks
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(10){ count ->
                    AlbumDetailCardRow(album, count)
                }
            }
            // Reproducir
            Box(
                modifier = Modifier.align(Alignment.BottomCenter)
            ){
                ReproductorCard(album)
            }
        }
    }
}
