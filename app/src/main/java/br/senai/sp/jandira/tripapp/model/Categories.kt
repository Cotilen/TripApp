package br.senai.sp.jandira.tripapp.model

import androidx.compose.ui.graphics.painter.Painter

data class Categories(
    var id: Int = 0,
    var name : String = "",
    var image : Painter? = null
)
