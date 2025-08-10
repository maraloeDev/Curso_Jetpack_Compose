package com.maraloedev.instadev.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maraloedev.instadev.R

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

    //Cuando la pantalla muera, la subscripcion muere
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        loginViewModel
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = "Español (España)", color = Color.Gray
            )
            Spacer(Modifier.weight(1f))

            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "Logo InstaDev"
            )
            Spacer(Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Usuario, correo electronico o movil") },
                shape = RoundedCornerShape(30),
                value = uiState.email,
                onValueChange = { loginViewModel.onEmailChange(email = it) })
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Contraseña") },
                shape = RoundedCornerShape(30),
                value = uiState.password,
                onValueChange = { loginViewModel.onPasswordChange(password = it) })
            Spacer(Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ), onClick = {  },
                enabled = uiState.isLoginEnabled) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "Iniciar sesion"
                )
            }
            TextButton(onClick = { }) { Text("¿Has olvidado la contraseña?") }
            Spacer(Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { }) { Text(text = "Crear cuenta nueva") }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }

}