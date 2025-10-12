package com.example.gplascenciamusicapp.ui.theme

import android.graphics.Color.rgb
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val BackGroundGradient = Brush.verticalGradient(
    colors = listOf(
        Color(rgb(0, 139, 24)),
        Color(rgb(7, 27, 10))
    )
)

val BackGroundImageGradient = Brush.verticalGradient(
    colors = listOf(
        Color(rgb(46, 182, 70)),
        Color(rgb(0, 139, 24))
    )
)

val ButtonPlayGradient = Brush.horizontalGradient(
    colors = listOf(
        Color(rgb(4, 14, 5)),
        Color(rgb(7, 27, 10))
    )
)

val ReproductorCard = Color(rgb(6, 54, 14))

val BackGroundCard = Color(rgb(0, 98, 17))

val AlbumDetailColor = Color(rgb(0, 111, 19))

val AlbumTitleColor = Color(rgb(27, 194, 86))