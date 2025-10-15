package com.example.gplascenciamusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.gplascenciamusicapp.screens.AlbumDetailScreen
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
                            AlbumDetailScreen(args.id, navController = navController)
                        }
                    }
                }
            }
        }
    }
}