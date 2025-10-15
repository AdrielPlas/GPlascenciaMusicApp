package com.example.gplascenciamusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.gplascenciamusicapp.models.Album
import com.example.gplascenciamusicapp.ui.theme.AlbumTitleColor

/*
 Componentes en el AlbumDetailScreen, parte superior (principal), que muestran los icionos de regresar, corazon, la portada del album, su nombre, artista y los simbolos de play y shuffle
 */
@Composable
fun DetailAlbumImage(
    album : Album?,
    navController : NavController
){
    // Contenedor principal
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black)
    ) {
        // Portada del album
        AsyncImage(
            model = album?.image ?: "",
            contentDescription = album?.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Seccion de botones de regresar y favoritos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Alignment.TopStart)
        ) {
            // Contenedor de icono de regresar <-
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(Color.Black)
                    .clickable{
                        navController.popBackStack()
                    },
                contentAlignment = Alignment.Center
            ) {
                // Icono de regresar <-
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    tint = Color.White
                )
            }
            // Espacio para separar los 2 iconos
            Spacer(modifier = Modifier.weight(1f))
            // Contenedor para el icono de favorito
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                // Icono de favorito/corazon
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favorite",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        // Detalles con cuidado si el objeto es null
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(15.dp)
        ) {
            // Titulo del album
            Text(
                text = album?.title ?: "Título no disponible",
                color = AlbumTitleColor,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            // Nombre del artista del album
            Text(
                text = album?.artist ?: "Artista no disponible",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp)
            )
            // Contenedor para los botones de play y Shuffle
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                // Contendero para el icono de play
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(55.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center,
                    ) {
                    // Icono de PLAY
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "play",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
                // Espaciador entre los 2 iconos
                Spacer(modifier = Modifier.width(10.dp))
                // Contenedor para el icono de Shuffle
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(55.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center,
                    ) {
                    // Icono de Shuffle
                    Icon(
                        imageVector = Icons.Default.Shuffle,
                        contentDescription = "reiniciar",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}
