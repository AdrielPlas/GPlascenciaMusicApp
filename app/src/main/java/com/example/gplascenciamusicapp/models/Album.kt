package com.example.gplascenciamusicapp.models

import coil3.Image

class Album(
    val title : String,
    val artist : String,
    val description : String? = null,
    val image: String,
    val id : String
)