package com.example.gplascenciamusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gplascenciamusicapp.components.AlbumCardRow
import com.example.gplascenciamusicapp.components.AlbumCardsBox
import com.example.gplascenciamusicapp.components.Header
import com.example.gplascenciamusicapp.components.ReproductorCard
import com.example.gplascenciamusicapp.models.Album
import com.example.gplascenciamusicapp.services.AlbumService
import com.example.gplascenciamusicapp.ui.theme.AlbumDetailScreenRoute
import com.example.gplascenciamusicapp.ui.theme.BackGroundGradient
import com.example.gplascenciamusicapp.ui.theme.ButtonPlayGradient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(
    navController: NavController
){
    // Lista de los albumes de la API
    var albums by remember {
        mutableStateOf(listOf<Album>())
    }
    // Variable para el estado mientras se consume la API
    var loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) {
        try{
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = async(Dispatchers.IO) {
                service.getAllAlbums()
            }
            Log.i("HomeScreen", "${result.await()}")
            albums = result.await()
            loading = false
        }
        catch (e: Exception) {
            loading = false
            Log.e("HomeScreen", e.toString())
        }
    }
    // Animacion mientras carga la API
    if(loading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else{
        // Inicio del UI, Columna principal (alinear los componentes verticalmente)
        Column(modifier = Modifier
            .fillMaxSize()
            .background(BackGroundGradient)
            .padding(top = 40.dp, start = 15.dp, end = 15.dp, bottom = 20.dp)
        ) {
            // Contenedor del Header
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(ButtonPlayGradient)
            ) {
                // Componente Header
                Header()
            }
            // Contenedor para Textos y el LazyRow de los albumes
            Column(modifier = Modifier
                .weight(4f)
                .padding(horizontal = 5.dp)) {
                // Contenedor para textos superiores
                Row(
                    modifier = Modifier
                        .padding(top = 15.dp)
                ) {
                    // Texto ALBUMS
                    Text(
                        text = "Albums",
                        modifier = Modifier.weight(1f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    // Boton de See more
                    Text(
                        text = "See more",
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                // Contenedor para los AlbumCardBox iterando la lista de albums
                LazyRow(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 7.dp, bottom = 10.dp)
                ) {
                    items(albums){ album ->
                        // Componente que cambia segun cada item de la lista
                        AlbumCardsBox(
                            album = album,
                            onClick = {
                                navController.navigate(AlbumDetailScreenRoute(album.id))
                            }
                        )
                    }
                }
                // Contenedor para los textos inferiores
                Row(
                    modifier = Modifier
                ) {
                    // Texto de RECENTLY PLAYES
                    Text(
                        text = "Recently Played",
                        modifier = Modifier.weight(1f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    // Texto de SEE MORE
                    Text(
                        text = "See more",
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
            // Contenedor para los albumes listados y el reproductor fijo
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(6f)
            ) {
                // Contenedor con un estilo
                Column(modifier = Modifier
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp)
                ) {
                    // Contenedor de los cards Horizontales
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(albums){ album ->
                            // Componente que muestra cada item de la lista
                            AlbumCardRow(
                                album = album,
                                onClick = {
                                    navController.navigate(AlbumDetailScreenRoute(album.id))
                                }
                            )
                        }
                    }
                }
                // Contenedor para fijar el REproductor hasta el fondo
                Box(
                    modifier = Modifier.align(Alignment.BottomCenter)
                ){
                    // Componente con un valor hardcodeado
                    ReproductorCard(albums[0])
                }
            }
        }
    }
}