package com.example.gplascenciamusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.gplascenciamusicapp.models.Album
import com.example.gplascenciamusicapp.ui.theme.ReproductorCard

/*
Componente fijo en el HomeScreen y AlbumDetailScreen en la parte inferior, el cual muestra el album seleccionado, su nombre, artista y un boton que cambia de Play y Pause
 */
@Composable
fun ReproductorCard(
    album : Album?
) {
    // Variable de estado playing o pause
    var isPlaying by remember { mutableStateOf(false) }
    // Contenedor General para alinear hasta abajo de otro Box (componente padre)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(ReproductorCard)
    ) {
        // Contenedor para organizar los componentes horizontalmente
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Contenedor para la portada del album
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black)
            ) {
                // Portada del album
                AsyncImage(
                    model = album?.image ?: "",
                    contentDescription = album?.title ?: "no encontrado",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            // Detalles del album vertical
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 10.dp)
                    .weight(1f)
            ) {
                // Titulo del album
                Text(
                    text = album?.title ?: "Titulo no encontrado",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                // Artista del album
                Text(
                    text = album?.artist ?: "Artista no encontrado",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }
            // Botón de play / pause
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable{
                        isPlaying = !isPlaying
                              },
                contentAlignment = Alignment.Center,)
            {
                // Icono que cambia al ser presionado (inicialmente es muestra play)
                Icon(
                    imageVector = if(isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow, // Accion de mostrar segun el estado
                    contentDescription = if (isPlaying) "pause" else "play",
                    tint = Color.Black
                )
            }
        }
    }
}