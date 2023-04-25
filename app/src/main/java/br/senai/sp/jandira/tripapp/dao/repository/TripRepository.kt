package br.senai.sp.jandira.tripapp.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.model.Trips
import java.time.LocalDate
import java.time.MonthDay
import java.time.Year

class TripRepository {

    companion object {
        @Composable
        fun getTripList(): List<Trips> {

            return listOf<Trips>(

                Trips(
                    id = 0,
                    location = stringResource(id = R.string.london),
                    description = stringResource(id = R.string.london_description),
                    dataStart = LocalDate.of(2023,4,21),
                    dataEnd = LocalDate.of(2023,4,23)


                    ),
                Trips(
                    id = 1,
                    location ="São Roque",
                    description = "Visitei a vinicula Goes, quase não voltei para casa",
                    dataStart = LocalDate.of(2023,4,21),
                    dataEnd = LocalDate.of(2023,4,23)
                ),
                Trips(
                    id = 1,
                    location ="Uma Cidade",
                    description = "Tava tão louco que nem sei onde tava",
                    dataStart = LocalDate.of(2023,4,21),
                    dataEnd = LocalDate.of(2023,4,23)
                )
            )

        }
    }
}