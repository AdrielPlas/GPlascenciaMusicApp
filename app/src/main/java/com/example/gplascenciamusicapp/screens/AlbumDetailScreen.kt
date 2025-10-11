package com.example.gplascenciamusicapp.screens

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.gplascenciamusicapp.Main
import com.example.gplascenciamusicapp.ui.theme.AlbumDetailColor
import com.example.gplascenciamusicapp.ui.theme.BackGroundCard
import com.example.gplascenciamusicapp.ui.theme.BackGroundGradient
import com.example.gplascenciamusicapp.ui.theme.BackGroundImageGradient
import com.example.gplascenciamusicapp.ui.theme.ButtonPlayGradient
import com.example.gplascenciamusicapp.ui.theme.GPlascenciaMusicAppTheme
import com.example.gplascenciamusicapp.ui.theme.ReproductorCard

@Composable
fun AlbumDetailScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(BackGroundGradient)
        .padding(15.dp)) {
        // IMAGEN PRINCIPAL
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(BackGroundImageGradient)

        ) {
            AsyncImage(
                model = "",
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .align(Alignment.TopStart)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "favorite",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            // Detalles
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(15.dp)
            ) {
                Text(
                    text = "album.title"
                )
                Text(
                    text = "album.artist"
                )
                Row(
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(55.dp)
                            .clip(CircleShape)
                            .background(Color.Black),
                        contentAlignment = Alignment.Center,

                        ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "play",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(55.dp)
                            .clip(CircleShape)
                            .background(Color.Black),
                        contentAlignment = Alignment.Center,

                        ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "reiniciar",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
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
                    .padding(top = 10.dp, start = 10.dp, bottom = 5.dp)
            )
            Text(
                text = "album.description",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 8.dp   )
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
                text = "album.artist",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
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
                items(10){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
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
                                .background(Color.LightGray)
                        ){
                            AsyncImage(
                                model = "album.image",
                                contentDescription = "album.title",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        // Detalles
                        Column(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "${"album.title"} * Track ${"1++"}",
                                color = Color.White,
                            )
                            Text(
                                text = "album.artist",
                                color = Color.White,
                            )
                        }
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
            }
            // Reproducir
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(ReproductorCard)
                    .align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Imagen
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(50.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ){
                    AsyncImage(
                        model = "",
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                // Detalles
                Column(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = "nombre del album",
                        color = Color.White,
                    )
                    Text(
                        text = "autor + * Popular song",
                        color = Color.White,
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(10.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center,

                    ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "play",
                        tint = Color.Black
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GPlascenciaMusicAppTheme {
        AlbumDetailScreen()
    }
}