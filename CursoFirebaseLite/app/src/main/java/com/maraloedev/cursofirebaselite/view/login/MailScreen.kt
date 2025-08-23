package com.maraloedev.cursofirebaselite.view.login

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.google.firebase.firestore.firestore
import com.maraloedev.cursofirebaselite.R
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Pantalla de inicio de sesión con correo y contraseña.
 * @param onNavigateToHome Navega a la pantalla principal.
 * @param onNavigateToLoginWithoutPassword Navega a la pantalla de login sin contraseña.
 */
@Composable
fun MailScreen(
    auth: FirebaseAuth = Firebase.auth,
    onNavigateToLoginScreen: () -> Unit,
    onNavigateToLoginWithoutPassword: () -> Unit,
    mailViewModel: MailViewModel = viewModel()
) {

    val state by mailViewModel.state.collectAsState()

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
            // Fila superior con botón de retroceso
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .clickable { onNavigateToLoginScreen() }
                        .padding(all = 30.dp)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.ic_back_24),
                    contentDescription = "", // Descripción accesible vacía
                    tint = Color.White
                )
                Spacer(Modifier.width(width = 50.dp))
            }

            Spacer(Modifier.padding(top = 30.dp))

            // Contenido principal de la pantalla
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp)
            ) {
                // Campo de correo o usuario
                Text(
                    text = "Correo electrónico o nombre de usuario",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    value = state.mail,
                    onValueChange = { mailViewModel.isMailChanged(mail = it) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(color = 0xFF585858),
                        focusedBorderColor = Color(color = 0xFF585858),
                        unfocusedLabelColor = Color(color = 0xFF292929)
                    )
                )
                Spacer(Modifier.padding(top = 20.dp))

                // Campo de contraseña
                Text(
                    text = "Contraseña",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    value = state.password,
                    onValueChange = { mailViewModel.isPasswordChanged(password = it) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(color = 0xFF585858),
                        focusedBorderColor = Color(color = 0xFF585858),
                        unfocusedLabelColor = Color(color = 0xFF292929)
                    )
                )

                // Botón para iniciar sesión y opción de login sin contraseña
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
                            auth.signInWithEmailAndPassword(
                                state.mail, state.password
                            ).addOnCompleteListener { task ->
                                if (task.isSuccessful) {

                                    Log.i("EDUARDO", "REGISTRO OK")
                                } else {
                                    Log.i("EDUARDO", "REGISTRO NO")
                                }
                            }
                        },
                        enabled = state.isEnabled,
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White,
                            disabledContentColor = Color.Black,
                            disabledContainerColor = Color(0xFF585858)
                        )
                    ) {
                        Text(text = "Iniciar sesion", fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.padding(top = 22.dp))
                    // Botón para iniciar sesión sin contraseña
                    TextButton(
                        border = BorderStroke(width = 1.dp, Color(0xFF222222)),
                        shape = RoundedCornerShape(size = 30.dp),
                        onClick = { onNavigateToLoginWithoutPassword() }
                    ) {
                        Text(
                            text = "Iniciar sesion sin contraseña",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}