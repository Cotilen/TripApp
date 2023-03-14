package br.senai.sp.jandira.tripapp

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripAppTheme {
                SignUpScreen()

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignUpScreen() {

    Surface(modifier = Modifier.fillMaxSize()) {

        var checked by remember {
            mutableStateOf(false)
        }


        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                horizontalArrangement = Arrangement.End,
            ) {
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp),
                    backgroundColor = Color(207, 6, 240),
                    shape = RoundedCornerShape(bottomStart = 16.dp),
                ) {}
            }
            Column(modifier = Modifier.fillMaxWidth().padding(top = 70.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {


                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontSize = 32.sp,
                    color = Color(207, 6, 240),
                    letterSpacing = 4.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 48.sp
                )
                Text(
                    text = stringResource(id = R.string.new_account),
                    fontSize = 14.sp,
                    color = Color(160, 156, 156)
                )

                Column(modifier = Modifier.padding(17.dp)) {
                    OutlinedTextField(value = "",
                        onValueChange = {""
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(stringResource(id = R.string.username)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.person_24),
                                contentDescription = "Image_email",
                                modifier = Modifier
                                    .height(27.dp)
                                    .width(22.dp),
                                tint = Color(207, 6, 240)
                            )
                        })


                    OutlinedTextField(value = "",
                        onValueChange = {""
                        },
                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(16.dp),
                        label = { Text(stringResource(id = R.string.phone)) },
                        visualTransformation = PasswordVisualTransformation(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.phone_24),
                                contentDescription = "Image_password",
                                modifier = Modifier
                                    .height(27.dp)
                                    .width(22.dp),
                                tint = Color(207, 6, 240)
                            )
                        })


                    OutlinedTextField(value = "",
                        onValueChange = {""
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


                    OutlinedTextField(value = "",
                        onValueChange = {""
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
                        })

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = {checked = it},
                            modifier = Modifier
                                .height(27.dp)
                                .width(27.dp)

                        )
                        Text(text = stringResource(id = R.string.over_18),
                            fontSize = 18.sp,
                            lineHeight = 21.sp)
                    }

                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 17.dp),
                    horizontalAlignment = Alignment.End) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(327.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(207, 6, 240)
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.create).uppercase(),
                            color = Color.White
                        )
                        Icon(painter = painterResource(id = R.drawable.arrow_forward_24),
                            contentDescription ="",
                            tint = Color(255,255,255)
                        )

                    }
                    Spacer(modifier = Modifier.height(31.dp))

                    Row() {
                        Text(
                            text = stringResource(id = R.string.already_account),
                            color = Color(160, 156, 156),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            lineHeight = 18.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))

                        ClickableText(text = AnnotatedString(text = stringResource(id = R.string.sign_in)
                        ), style = TextStyle(
                            color = Color(207, 6, 240),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(700),
                            lineHeight = 18.sp,
                        ) , onClick ={}
                        )


                    }
            }

            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
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
}}