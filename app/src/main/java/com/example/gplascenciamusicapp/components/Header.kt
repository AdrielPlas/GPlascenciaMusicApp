package com.example.gplascenciamusicapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/*
 Componente en el HomeScreen para mostrar la bienvenida, en el apartado superior, con botones de menu, buscar y textos de bienvenida.
 */
@Composable
fun Header() {
    // Contenedor de los botones superiores
    Row(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Contenedor para el icono de back y de buscar
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Icono de Back
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "back",
                modifier = Modifier
                    .align(Alignment.CenterStart),
                tint = Color.White
            )
            // Icono de buscar
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search",
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                tint = Color.White
            )
        }
    }
    // Textos de bienvenida
    Text(
        text = "Good Morning!",
        modifier = Modifier.padding(start = 15.dp, bottom = 12.dp),
        color = Color.White,
        style = MaterialTheme.typography.titleLarge
    )
    // Nombre del usuario
    Text(
        text = "Adriel Plascencia",
        modifier = Modifier.padding(start = 15.dp),
        color = Color.White,
        style = MaterialTheme.typography.titleSmall
    )
}