package br.senai.sp.jandira.tripapp.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.model.Trips
import java.time.MonthDay
import java.time.Year

class TripRepository {

    companion object {
        @Composable
        fun getTripList(): List<Trips> {

            return listOf<Trips>(

                Trips(
                    id = 0,
                    city = stringResource(id = R.string.london),
                    year = stringResource(id = R.string.london_year),
                    dataStart = stringResource(id = R.string.london_dataStart),
                    dataEnd = stringResource(id = R.string.london_dataEnd),
                    description = stringResource(id = R.string.london_description),
                    image = painterResource(id = R.drawable.london)
                ),
                Trips(
                    id = 0,
                    city = stringResource(id = R.string.london),
                    year = stringResource(id = R.string.london_year),
                    dataStart = stringResource(id = R.string.london_dataStart),
                    dataEnd = stringResource(id = R.string.london_dataEnd),
                    description = stringResource(id = R.string.london_description),
                    image = painterResource(id = R.drawable.london)
                )
            )

        }
    }
}