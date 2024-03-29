package br.senai.sp.jandira.tripapp.gui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import br.senai.sp.jandira.tripapp.components.BottomShape
import br.senai.sp.jandira.tripapp.components.TopShape
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.model.User
import br.senai.sp.jandira.tripapp.repository.UserRepository
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import java.net.URI

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val user = User(
//            username = "Maria Da Silva",
//            email = "maria@terra.com.br",
//            password = "12345",
//            phone = "(11)99999-9999",
//            isOver18 = true
//        )
//
//        val userRep = UserRepository(this)
//        var id = userRep.save(user)
//
//        Toast.makeText(this, "$id", Toast.LENGTH_LONG).show()


        setContent {
            TripAppTheme {
                // A surface container using the 'background' color from the theme
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {



    var photoUriState by remember {
        //A interrogação siginifica que essa variável pode ser nula
        mutableStateOf<Uri?>(null)
    }

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(photoUriState).build()
    )

    //Faz uma requisição de um aplicativo externo
    //O contract diz ao launcher o que ele tem que trazer
    var launcher = rememberLauncherForActivityResult(
        contract =ActivityResultContracts.GetContent()
    ){
        photoUriState = it
    }

    var userNameState by remember {
        mutableStateOf("")
    }

    var userPhoneState by remember {
        mutableStateOf("")
    }

    var userEmailState by remember {
        mutableStateOf("")
    }

    var userPasswordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp), horizontalArrangement = Arrangement.End
            ) {

                TopShape()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = Color(207, 6, 240),
                    fontSize = 48.sp,
                    fontWeight = FontWeight(800),
                )
                Text(text = stringResource(id = R.string.new_account), color = Color(160, 156, 156))
                Spacer(modifier = Modifier.height(16.dp))
                Box(
//                    contentAlignment = Alignment.BottomEnd
                ) {
                    Card(
                        modifier = Modifier.size(100.dp),
                        shape = CircleShape,
                        backgroundColor = Color(160, 160, 160)
                    ) {
                        Image(
                            painter = painter, contentScale = ContentScale.Crop,
                            contentDescription = null

                        )
                    }
                    Image(
                        painterResource(id = R.drawable.photo_24),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .clickable {

                                launcher.launch("image/*")
                                var message = "nada"
                                Log.i(

                                    "ds2m",

                                    "URI: ${photoUriState?.path ?: message}"
                                )
                            }
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Column() {

                    Column(
                        modifier = Modifier
                            .height(height = 300.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        OutlinedTextField(
                            value = userNameState,
                            shape = RoundedCornerShape(16.dp),
                            onValueChange = { userNameState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.username)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.person_24),
                                    contentDescription = "Username",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            value = userPhoneState,
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = { userPhoneState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.phone)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.phone_24),
                                    contentDescription = "Phone",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = userEmailState,
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            onValueChange = { userEmailState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.email)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.email),
                                    contentDescription = "Phone",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = userPasswordState,
                            shape = RoundedCornerShape(16.dp),
                            visualTransformation = PasswordVisualTransformation(),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.),
                            onValueChange = { userPasswordState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.password)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.lock_24),
                                    contentDescription = "Phone",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Checkbox(checked = over18State, onCheckedChange = { over18State = it })
                            Text(text = stringResource(id = R.string.over_18))
                        }

                        Row(
                            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                        ) {

                            Button(
                                onClick = {
                                    saveUser(
                                        userName = userNameState,
                                        phone = userPhoneState,
                                        email = userEmailState,
                                        password = userPasswordState,
                                        isOver18 = over18State,
                                        photoURI = photoUriState?.path ?: "",
                                        context = context,

                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),

                                ) {
                                Text(
                                    text = stringResource(
                                        id = R.string.create
                                    ).uppercase(),
                                    fontWeight = FontWeight(800),
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            }
                        }


                    }

                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(id = R.string.already_account),
                    color = Color(160, 156, 156)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    modifier = Modifier.clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)

                    },
                    text = stringResource(id = R.string.sign_in),
                    color = Color(207, 1, 240),
                    fontWeight = FontWeight(800)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {

                BottomShape()

            }

        }
    }
}

fun saveUser(
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean,
    photoURI: String,
    context: Context
) {
    //criando um objeto USER
    val newUser = User(
        id = 0,
        username = userName,
        phone = phone,
        email = email,
        password = password,
        isOver18 = isOver18,
        profilePhoto = photoURI
    )
    //criando uma instância do repositorio
    val userRepository = UserRepository(context)

    //verificando se o  usuário já existe
    val user = userRepository.findUserByEmail(email)

    Log.i("ds2m", "${user.toString()}")

    //salvando o usuario

    if (user == null){
        val id = userRepository.save(newUser)
        Toast.makeText(context, "$id", Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, "User alredy exists", Toast.LENGTH_LONG).show()
    }




}
