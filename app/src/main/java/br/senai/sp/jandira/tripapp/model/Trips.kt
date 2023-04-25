package br.senai.sp.jandira.tripapp.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.tripapp.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.MonthDay
import java.time.Year

data class Trips(
    var id: Long = 0,
    var location: String = "",
    var description: String = "",
    var dataStart: LocalDate = LocalDate.of(2000,1,1),
    var dataEnd: LocalDate = LocalDate.of(2000,1,1),
    var image: Int =R.drawable.no_photography_24
)
