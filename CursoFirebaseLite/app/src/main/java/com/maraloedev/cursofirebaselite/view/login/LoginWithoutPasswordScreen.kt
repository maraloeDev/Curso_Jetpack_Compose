package com.maraloedev.cursofirebaselite.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maraloedev.cursofirebaselite.R

/**
 * Pantalla para iniciar sesión sin contraseña.
 * @param onNavigateToContinueMail Acción para navegar a la pantalla de ingreso por correo.
 */
@Composable
fun LoginWithoutPasswordScreen(
    LoginWithoutPasswordViewModel: LoginWithoutPasswordViewModel = viewModel(),
    onNavigateToContinueMail: () -> Unit
) {
    // Observa el estado actual del ViewModel
    val state by LoginWithoutPasswordViewModel.state.collectAsState()

    // Scaffold proporciona la estructura base y maneja el padding del sistema
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFF111111)), // Fondo oscuro
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Fila superior: botón de retroceso y título
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .clickable { onNavigateToContinueMail() } // Navega hacia atrás
                        .padding(30.dp)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.ic_back_24),
                    contentDescription = "", // Accesibilidad: descripción vacía
                    tint = Color.White
                )
                Spacer(Modifier.width(10.dp))

                Text(
                    text = "Iniciar sesión sin contraseña",
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color.White
                )
            }

            Spacer(Modifier.padding(top = 30.dp))

            // Contenido principal: campo de correo/usuario y botón
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {

                // Título del campo de entrada
                Text(
                    text = "Correo electronico o nombre de usuario",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                // Campo de texto para ingresar correo o usuario
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    value = state.mail,
                    onValueChange = { LoginWithoutPasswordViewModel.isMailChange(it) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF585858),
                        focusedBorderColor = Color(0xFF585858),
                        unfocusedLabelColor = Color(0xFF292929)
                    ),
                    supportingText = {
                        Text(
                            text = "Te enviaremos un correo electrónico con el\nque puedes iniciar sesión",
                            color = Color.White
                        )
                    }
                )

                // Botón para obtener el enlace de acceso
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp)
                            .height(55.dp),
                        onClick = { /* Acción para enviar enlace */ },
                        enabled = state.isEnabled,
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White,
                            disabledContentColor = Color.Black,
                            disabledContainerColor = Color(0xFF585858)
                        )
                    ) {
                        Text(text = "Obtener enlace", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}