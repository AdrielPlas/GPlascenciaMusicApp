package com.example.gplascenciamusicapp.components

import androidx.compose.foundation.clickable
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
import com.example.gplascenciamusicapp.ui.theme.gothamFontFamily

@Composable
fun Header() {
    // Botones
    Row(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "back",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable {

                    },
                tint = Color.White
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "favorite",
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                tint = Color.White
            )
        }
    }
    // Textos
    Text(
        text = "Good Morning!",
        modifier = Modifier.padding(start = 15.dp, bottom = 12.dp),
        color = Color.White,
        style = MaterialTheme.typography.titleLarge
    )
    Text(
        text = "Adriel Plascencia",
        modifier = Modifier.padding(start = 15.dp),
        color = Color.White,
        style = MaterialTheme.typography.titleSmall
    )
}