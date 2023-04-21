package br.senai.sp.jandira.tripapp.gui

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.dao.repository.CategoriesRepository
import br.senai.sp.jandira.tripapp.dao.repository.TripRepository
import br.senai.sp.jandira.tripapp.model.Categories
import br.senai.sp.jandira.tripapp.model.Trips
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import java.io.DataInput
import java.util.Date

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras
        val name = intent.getStringExtra("name")
        val id = intent.getStringExtra("id")
        val photo = intent.getStringExtra("photo")

        val nomeUsuario: String = name ?: "Usuário"

        setContent {
            TripAppTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    HomeScreen(
                        CategoriesRepository.getCategoriesList(),
                        TripRepository.getTripList(),
                        nomeUsuario
                    )

                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun HomeScreen(categories: List<Categories>,
               trips: List<Trips>,
               nome: String
)
{
    Column(modifier = Modifier.fillMaxSize()) {
        //Header Paris
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .paint(
                        // Replace with your image id
                        painterResource(id = R.drawable.image_home),
                        contentScale = ContentScale.FillWidth,
                    )

            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 19.dp, top = 13.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.susanna),
                        contentDescription = "",
                        modifier = Modifier
                            .height(61.dp)
                            .width(61.dp)
                    )

                    Text(
                        text = nome,
                        color = Color(255, 255, 255),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 18.sp

                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.Start

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.location_on_24),
                            contentDescription = "",
                            tint = Color(255, 255, 255)
                        )
                        Text(
                            text = stringResource(id = R.string.you_are),
                            color = Color(255, 255, 255),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            lineHeight = 21.sp
                        )


                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp),
                        horizontalArrangement = Arrangement.Start

                    ) {

                        Text(
                            text = stringResource(id = R.string.my_tripp),
                            color = Color(255, 255, 255),
                            fontSize = 24.sp,
                            fontWeight = FontWeight(700),
                            lineHeight = 36.sp
                        )

                    }
                }


            }

        }
        //Categorias
        Row(modifier = Modifier.padding(start = 17.dp, bottom = 7.dp, top = 13.dp)) {
            Text(
                text = stringResource(id = R.string.categories),
                color = Color(86, 84, 84),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                lineHeight = 21.sp
            )


        }
        //Cards Categorias
        LazyRow(modifier = Modifier.padding(start = 19.dp)) {
            for (categorie in categories) {
                item {
                    Card(
                        modifier = Modifier
                            .height(64.dp)
                            .width(109.dp)
                            .padding(end = 8.dp),
                        backgroundColor = Color(207, 6, 240),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(top = 8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = categorie.image
                                    ?: painterResource(id = R.drawable.susanna),
                                contentDescription = "",
                                Modifier.size(32.dp),
                                colorFilter = ColorFilter.tint(Color.White)
                            )

                            Text(
                                text = categorie.name,
                                color = Color.White
                            )
                        }

                    }
                }
            }
        }
        //Search
        Row(modifier = Modifier.padding(start = 16.dp, top = 33.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "",
                tint = Color(160, 156, 156)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = stringResource(id = R.string.seach),
                color = Color(160, 156, 156),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                lineHeight = 21.sp
            )
        }
        Spacer(modifier = Modifier.height(34.dp))
        //Past Trips
        Row(modifier = Modifier.padding(start = 17.dp)) {
            Text(
                text = stringResource(id = R.string.past_trip),
                color = Color(86, 84, 84),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                lineHeight = 21.sp
            )


        }
        Spacer(modifier = Modifier.height(14.dp))
        //Trips
        LazyColumn(modifier = Modifier.padding(start = 19.dp)) {

            for (trip in trips) {
                item {
                    Card(
                        modifier = Modifier
                            .height(208.dp)
                            .width(325.dp)
                            .padding(bottom = 16.dp),
                        backgroundColor = Color(255,255,255),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 1.dp
                    ) {
                        Column(modifier = Modifier.padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(painter = painterResource(id = R.drawable.london),
                                contentDescription = "",
                            modifier = Modifier
                                .width(315.dp)
                                .height(106.dp))

                            Row(modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start) {

                                Text(text = trip.city + ", " + trip.year,
                                    color = Color(207, 6, 240),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(400),
                                    lineHeight = 21.sp)
                            }

                            
                            Text(text = trip.description,
                                color = Color(160, 156, 156),
                                fontSize = 10.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 15.sp)

                            Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End) {
                                Text(text = trip.dataStart + " - " + trip.dataEnd,
                                    color = Color(207, 6, 240),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(400),
                                    lineHeight = 15.sp)
                            }



                        }
                    }

                }
            }
        }
        Column(modifier = Modifier.padding(start = 17.dp)) {
            Card(
                modifier = Modifier
                    .width(325.dp)
                    .height(208.dp),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color(255, 255, 255),
                elevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.london),
                        contentDescription = "",
                        modifier = Modifier
                            .height(106.dp)
                            .width(315.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.london),
                        color = Color(207, 6, 240),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        textAlign = TextAlign.Start,
                        lineHeight = 21.sp

                    )

                    Text(
                        text = stringResource(id = R.string.london_description),
                        color = Color(160, 156, 156),
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 15.sp
                    )
                    Text(
                        text = stringResource(id = R.string.name),
                        color = Color(207, 6, 240),
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400),
                        textAlign = TextAlign.End,
                        lineHeight = 15.sp
                    )

                }

            }

        }


    }
}

