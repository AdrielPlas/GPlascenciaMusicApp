package com.example.gplascenciamusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.gplascenciamusicapp.models.Album
import com.example.gplascenciamusicapp.ui.theme.BackGroundCard

/*
 Componentes en el AlbumDetailScreen, parte inferior, que muestran el album, su nombre + N Track, artista y los 3 puntos, respecto a un LazyColumn
 */
@Composable
fun AlbumDetailCardRow(
    album : Album?,
    count : Int
) {
    // Card principal
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(18.dp),
                clip = false,
                ambientColor = Color.Black.copy(alpha = 0.1f)
            )
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(18.dp),
                clip = false
            )
            .padding(bottom = 10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(BackGroundCard)
    ) {
        // Imagen
        Box(
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black)
        ){
            AsyncImage(
                model = album?.image ?: "",
                contentDescription = "Track ${count + 1}",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        // Detalles
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .weight(1f)
        ) {
            // Nombre de album + Track N
            Text(
                text = "${album?.title} - Track ${count + 1}",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            // Nombre del artista
            Text(
                text = album?.artist ?: "Artista",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Medium
            )
        }
        // 3 puntos para mas detalles
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Detalles",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 10.dp),
            tint = Color.White
        )
    }
}
