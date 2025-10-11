package com.example.gplascenciamusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import coil3.compose.AsyncImage
import com.example.gplascenciamusicapp.screens.HomeScreen
import com.example.gplascenciamusicapp.ui.theme.AlbumDetailScreenRoute
import com.example.gplascenciamusicapp.ui.theme.GPlascenciaMusicAppTheme
import com.example.gplascenciamusicapp.ui.theme.HomeScreenRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GPlascenciaMusicAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreenRoute
                    ){
                        composable<HomeScreenRoute> {
                            HomeScreen(
                                navController
                            )
                        }
                        composable<AlbumDetailScreenRoute> { backStack ->
                            val args = backStack.toRoute<AlbumDetailScreenRoute>()
                            AlbumDetailScreenRoute(args.id)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Main(){
    var newsList = remember {
        mutableListOf("El presidente de EE.UU. no muestra signos de arrepentimiento...", "Bañarse en la piscina del desierto de Cleopatra", " Gigantes tecnológicos", "El rover de Marte envía")
    }
    Column(modifier = Modifier.fillMaxSize().padding(15.dp)) {
        // Header
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(Color.Blue)
        ) {
            // Botones
            Row(
                modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f).fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "back",
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .clickable{

                            },
                        tint = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "favorite",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    )
                }
            }
            // Textos
            Text(
                text = "Good Morning!",
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(
                text = "Adriel Plascencia",
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        // Albums
        Column(modifier = Modifier.weight(4f).padding(horizontal = 5.dp)) {
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = "Albums",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "See more"
                )
            }
            LazyRow(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 7.dp, bottom = 10.dp)
            ) {
                items(newsList){ news ->
                    Box(
                        modifier = Modifier
                            .width(220.dp)
                            .padding(end = 20.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color.Gray)
                    ) {
                        AsyncImage(
                            model = "",
                            contentDescription = "",
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
                                    .background(Color.LightGray)
                                    .padding(10.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text(
                                            text = "nombre de rola"
                                        )
                                        Text(
                                            text = "artista"
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(30.dp)
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
                }

            }
            Row(
                modifier = Modifier

            ) {
                Text(
                    text = "Recently Played",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "See more"
                )
            }

        }
        // Recently Played
        Column(modifier = Modifier
            .weight(5f)
            .padding(top = 10.dp, start = 5.dp, end = 5.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(newsList){ news ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(bottom = 10.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.LightGray)
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
                                text = "nombre del album"
                            )
                            Text(
                                text = "autor + * Popular song"
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Detalles",
                            modifier = Modifier 
                                .align(Alignment.CenterVertically)
                                .padding(end = 10.dp)
                        )
                    }
                }
            }
        }
        // Reproductor
        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.LightGray)
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
                        text = "nombre del album"
                    )
                    Text(
                        text = "autor + * Popular song"
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(30.dp)
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
        Main()
    }
}