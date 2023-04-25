package br.senai.sp.jandira.tripapp.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.model.Categories

class CategoriesRepository {
    companion object{
        @Composable
        fun getCategoriesList(): List<Categories>{

            return listOf<Categories>(
                
                Categories(
                    id = 1,
                    name = stringResource(id = R.string.mountain),
                    image = painterResource(id = R.drawable.montain)
                ),
                Categories(
                    id = 2,
                    name = stringResource(id = R.string.snow),
                    image = painterResource(id = R.drawable.ski)
                ),
                Categories(
                    id = 3,
                    name = stringResource(id = R.string.beach),
                    image = painterResource(id = R.drawable.beach)
                )

            )
        }
    }
}