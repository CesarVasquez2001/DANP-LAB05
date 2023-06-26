package com.fggc.lab03.presentation.login


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobileconnectors.iot.AWSIotMqttManager
import com.amazonaws.regions.Regions
import com.fggc.lab03.domain.model.User


@Composable
fun LoginScreen(

    navigateToLoginReporteScreen: (loginId: Int) -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),


    ) {

    val showLoginForm = rememberSaveable {
        mutableStateOf(true)
    }

    val users by viewModel.users.collectAsState(
        initial = emptyList()
    )

    Log.d("USUARIOS", users.toString())


    Surface(

        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if (showLoginForm.value) {
                Text(text = "Inicia Sesion")
                UserForm(
                    isCreateAccount = false,
                    navigateToLoginReporteScreen = navigateToLoginReporteScreen,

                    )
                { email, password ->
                    Log.d("Bien", "Logueando con $email y $password")
                    val userFound = users.find { it.email == email && it.password == password }
                    if (userFound != null) {
                        Log.d("SI", "EXISTE")
                        Log.d("ID", userFound.userId.toString())
                        Log.d("EMAIL", userFound.email)
                        Log.d("PASSWORD", userFound.password)
                        navigateToLoginReporteScreen(userFound.userId)
                    } else {
                        Log.d("NO", "NO EXISTE")
                    }
                }

            } else {
                Text(text = "Crea una cuenta")
                UserForm(
                    isCreateAccount = true,
                    navigateToLoginReporteScreen = navigateToLoginReporteScreen,
                )
                { email, password ->
                    Log.d("Bien", "Creando cuenta con $email y $password")
                    Log.d("REGISTRA SESION", "TEST")
                    val userFound = users.find { it.email == email && it.password == password }
                    if (userFound != null) {
                        Log.d("SI", "EXISTE")
                    } else {
                        Log.d("NO", "NO EXISTE")
                        val user = User(0, email, password)
                        viewModel.addUser(user)
                        showLoginForm.value = !showLoginForm.value
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val text1 =
                    if (showLoginForm.value) "No tienes cuenta?"
                    else "Ya tienes cuenta?"
                val text2 =
                    if (showLoginForm.value) "Registrate"
                    else "Inicia sesion"
                Text(text = text1)
                Text(text = text2,
                    modifier = Modifier
                        .clickable { showLoginForm.value = !showLoginForm.value }
                        .padding(start = 5.dp),
                    color = MaterialTheme.colors.secondaryVariant)

            }
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    navigateToLoginReporteScreen: (loginId: Int) -> Unit,
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = { email, pwd -> }
) {
    val email = rememberSaveable { mutableStateOf("") }

    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisible = rememberSaveable { mutableStateOf(false) }
    val valido = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState = password, labelId = "Password", passwordVisible = passwordVisible
        )
        SubmitButton(
            navigateToLoginReporteScreen = navigateToLoginReporteScreen,
            textId = if (isCreateAccount) "Crear cuenta" else "Login", inputValido = valido,

            ) {
            onDone(
                email.value.trim(),
                password.value.trim(),
            )
            if (keyboardController != null) {
                keyboardController.hide()
            }


        }

    }
}


@Composable
fun SubmitButton(

    navigateToLoginReporteScreen: (loginId: Int) -> Unit,
    textId: String,
    inputValido: Boolean,
    onClic: () -> Unit
) {

    Button(
        onClick = onClic,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValido
    ) {
        Text(
            text = textId, modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun PasswordInput(
    passwordState: MutableState<String>, labelId: String, passwordVisible: MutableState<Boolean>
) {
    val visualTransformation = if (passwordVisible.value) VisualTransformation.None
    else PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = {
            Text(
                text = labelId
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank()) {
                PasswordVisibleIcon(passwordVisible)
            } else null
        })
}

@Composable
fun PasswordVisibleIcon(passwordVisible: MutableState<Boolean>) {
    val image = if (passwordVisible.value) {
        Icons.Default.VisibilityOff
    } else {
        Icons.Default.Visibility
    }
    IconButton(onClick = {
        passwordVisible.value = !passwordVisible.value
    }) {
        Icon(
            imageVector = image, contentDescription = ""
        )
    }

}

@Composable
fun EmailInput(emailState: MutableState<String>, labelId: String = "Email") {
    InputField(
        valueState = emailState, labelId = labelId, keyboardType = KeyboardType.Email
    )
}

@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

