package com.example.gplascenciamusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
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
import com.example.gplascenciamusicapp.ui.theme.BackGroundImageGradient

@Composable
fun AlbumCardsBox(
    album : Album,
    onClick : () -> Unit
) {
    Box(
        modifier = Modifier
            .width(220.dp)
            .padding(end = 20.dp)
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
            .clip(RoundedCornerShape(18.dp))
            .background(Color.Black)
            .clickable{
                onClick()
            }
    ) {
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(BackGroundImageGradient)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = album.title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(bottom = 6.dp),
                            color = Color.White
                        )
                        Text(
                            text = album.artist,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.Black),
                        contentAlignment = Alignment.Center,
                        ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "play",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}