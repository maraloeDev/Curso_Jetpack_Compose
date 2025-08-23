package com.maraloedev.cursofirebaselite.view.createNewAccount

import android.util.Log
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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.maraloedev.cursofirebaselite.R

/**
 * Pantalla para ingresar el correo electrónico durante el registro.
 * @param onNavigateToRegister Navega de regreso a la pantalla de registro.
 */

@Composable
fun CreateNewAccountScreen(
    auth: FirebaseAuth = Firebase.auth,
    createNewAccountViewModel: CreateNewAccountViewModel = viewModel(),
    onNavigateToRegister: () -> Unit
) {

    val state by createNewAccountViewModel.state.collectAsState()

    // Scaffold para manejar el padding del sistema y la estructura base
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(color = 0xFF111111)), // Fondo oscuro
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Fila superior con botón de retroceso y título
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .clickable { onNavigateToRegister() } // Acción de retroceso
                        .padding(all = 30.dp)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.ic_back_24),
                    contentDescription = "", // Descripción accesible vacía
                    tint = Color.White
                )
                Spacer(Modifier.width(50.dp))

                Text(
                    text = "Crear cuenta",
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color.White
                )
            }

            Spacer(Modifier.padding(top = 30.dp))

            // Contenido principal de la pantalla
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp)
            ) {

                // Título del campo de correo
                Text(
                    text = "¿Cuál es tu correo electronico?",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                // Campo de texto para ingresar el correo
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    value = state.mail,
                    onValueChange = { createNewAccountViewModel.changeMail(mail = it) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(color = 0xFF585858),
                        focusedBorderColor = Color(color = 0xFF585858),
                        unfocusedLabelColor = Color(color = 0xFF292929)
                    ),
                    supportingText = {
                        Text(
                            text = "Luego tendras que confirmar esta dirección",
                            color = Color.White
                        )
                    }
                )

                // Título del campo de contraseña
                Text(
                    text = "¿Cuál es tu contraseña?",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                // Campo de texto para ingresar el correo
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    value = state.password,
                    onValueChange = { createNewAccountViewModel.changePassword(password = it) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(color = 0xFF585858),
                        focusedBorderColor = Color(color = 0xFF585858),
                        unfocusedLabelColor = Color(color = 0xFF292929)
                    ),
                )

                // Botón para continuar con el registro
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp)
                            .height(height = 55.dp),
                        onClick = {
                            auth.createUserWithEmailAndPassword(state.mail, state.password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Log.i("EDUARDO", "LOG OK")
                                    } else {

                                        Log.i("EDUARDO", "LOG NO")
                                    }
                                }
                        },

                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White,
                            disabledContentColor = Color.Black,
                            disabledContainerColor = Color(color = 0xFF585858)
                        )
                    ) {
                        Text(text = "Siguiente", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}