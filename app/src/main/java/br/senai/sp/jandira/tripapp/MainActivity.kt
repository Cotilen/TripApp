package br.senai.sp.jandira.tripapp

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripAppTheme {
                TripAppScreen()

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TripAppScreen() {

    var emailState by rememberSaveable {
        mutableStateOf("")
    }
    var passwordState by rememberSaveable {
        mutableStateOf("")
    }
    val context = LocalContext.current.applicationContext
    val context2 = LocalContext.current

    val fontFamily = remember {
        FontFamily(
            typeface = ResourcesCompat.getFont(context, R.font.poppins_regular)!!
        )
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {
//Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                horizontalAlignment = Alignment.End,
            ) {
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp),
                    backgroundColor = Color(207, 6, 240),
                    shape = RoundedCornerShape(bottomStart = 16.dp),
                ) {}
            }
            Spacer(modifier = Modifier.height(104.dp))
            Column(modifier = Modifier.padding(17.dp)) {


                Text(
                    text = stringResource(id = R.string.title_login),
                    fontSize = 48.sp,
                    color = Color(207, 6, 240),
                    letterSpacing = 4.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 72.sp
                )
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 14.sp,
                    color = Color(160, 156, 156)
                )

                Spacer(modifier = Modifier.height(87.dp))

                OutlinedTextField(value = emailState,
                    onValueChange = {
                        Log.i("ds2m", it)
                        emailState = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(stringResource(id = R.string.email)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Image_email",
                            modifier = Modifier
                                .height(27.dp)
                                .width(22.dp),
                            tint = Color(207, 6, 240)
                        )
                    })

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(value = passwordState,
                    onValueChange = {
                        passwordState = it
                    },
                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),
                    label = { Text(stringResource(id = R.string.password)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "Image_password",
                            modifier = Modifier
                                .height(27.dp)
                                .width(22.dp),
                            tint = Color(207, 6, 240)
                        )
                    })
                Spacer(modifier = Modifier.height(31.dp))
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(134.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(207, 6, 240)
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_in), color = Color.White
                        )

                    }
                    Spacer(modifier = Modifier.height(31.dp))

                    Row() {
                        Text(
                            text = stringResource(id = R.string.dont_account),
                            color = Color(160, 156, 156),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = fontFamily,
                            lineHeight = 18.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = stringResource(id = R.string.sign_up),
                            color = Color(207, 6, 240),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = fontFamily,
                            lineHeight = 18.sp
                        )


                    }

                    Spacer(modifier = Modifier.height(108.dp))


                }


            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp),
                    backgroundColor = Color(207, 6, 240),
                    shape = RoundedCornerShape(topEnd = 16.dp),
                ) {}
            }
        }
    }
}
