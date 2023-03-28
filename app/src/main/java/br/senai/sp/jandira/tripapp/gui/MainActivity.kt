package br.senai.sp.jandira.tripapp.gui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.components.BottomShape
import br.senai.sp.jandira.tripapp.components.TopShape
import br.senai.sp.jandira.tripapp.dao.repository.CategoriesRepository
import br.senai.sp.jandira.tripapp.dao.repository.TripRepository
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme

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

@SuppressLint("SuspiciousIndentation")
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(), horizontalArrangement = Arrangement.End,
            ) {
               TopShape()
            }
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
            }
            Column(modifier = Modifier.padding(17.dp)) {
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
                    },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(207, 6, 240),
                    unfocusedBorderColor = Color(207, 6, 240)
                ))

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(value = passwordState,
                    onValueChange = {
                        passwordState = it
                    },
                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp),
                    label = { Text(stringResource(id = R.string.password)) },
                    visualTransformation = PasswordVisualTransformation(),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "Image_password",
                            modifier = Modifier
                                .height(27.dp)
                                .width(22.dp),
                            tint = Color(207, 6, 240)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(207, 6, 240),
                        unfocusedBorderColor = Color(207, 6, 240)
                    ))
            }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 17.dp), horizontalAlignment = Alignment.End) {
                    Button(
                        onClick = {
                            val openHome = Intent(context2, HomeActivity::class.java)
                            context2.startActivity(openHome)},
                        modifier = Modifier
                            .width(134.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(207, 6, 240)
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_in).uppercase(), color = Color.White
                        )
                        Icon(painter = painterResource(id = R.drawable.arrow_forward_24),
                            contentDescription ="",
                        tint = Color(255,255,255)
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

                        ClickableText(text = AnnotatedString(text = stringResource(id = R.string.sign_up)
                        ), style = androidx.compose.ui.text.TextStyle(
                            color = Color(207, 6, 240),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = fontFamily,
                            lineHeight = 18.sp,
                        ) , onClick ={
                            val openSignUp = Intent(context2,SignUp::class.java)
                                            context2.startActivity(openSignUp)}
                        )


                    }


                }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                BottomShape()
            }
        }
    }
}