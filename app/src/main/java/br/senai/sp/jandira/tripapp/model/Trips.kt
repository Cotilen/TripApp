package br.senai.sp.jandira.tripapp.model

import androidx.compose.ui.graphics.painter.Painter
import java.time.MonthDay
import java.time.Year

data class Trips(
    var id: Int = 0,
    var city: String = "",
    var year: String = "",
    var description: String = "",
    var dataStart: String = "",
    var dataEnd: String = "",
    var image: Painter? = null
)
