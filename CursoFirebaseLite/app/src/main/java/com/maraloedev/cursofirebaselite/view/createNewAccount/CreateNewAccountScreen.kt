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
 * Pantalla para crear una nueva cuenta con correo y contraseña.
 * @param auth Instancia de FirebaseAuth para registrar usuarios.
 * @param createNewAccountViewModel ViewModel que gestiona el estado de la pantalla.
 * @param onNavigateToRegister Acción para volver a la pantalla de registro.
 */
@Composable
fun CreateNewAccountScreen(
    auth: FirebaseAuth = Firebase.auth,
    createNewAccountViewModel: CreateNewAccountViewModel = viewModel(),
    onNavigateToRegister: () -> Unit
) {
    // Observa el estado actual del ViewModel
    val state by createNewAccountViewModel.state.collectAsState()

    // Estructura base de la pantalla con Scaffold
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
                        .clickable { onNavigateToRegister() } // Navega hacia atrás
                        .padding(30.dp)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.ic_back_24),
                    contentDescription = "", // Accesibilidad: descripción vacía
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

            // Contenido principal: campos de correo y contraseña
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                // Título y campo de correo electrónico
                Text(
                    text = "¿Cuál es tu correo electronico?",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    value = state.mail,
                    onValueChange = { createNewAccountViewModel.changeMail(it) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF585858),
                        focusedBorderColor = Color(0xFF585858),
                        unfocusedLabelColor = Color(0xFF292929)
                    ),
                    supportingText = {
                        Text(
                            text = "Luego tendrás que confirmar esta dirección",
                            color = Color.White
                        )
                    }
                )

                // Título y campo de contraseña
                Text(
                    text = "¿Cuál es tu contraseña?",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    value = state.password,
                    onValueChange = { createNewAccountViewModel.changePassword(it) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF585858),
                        focusedBorderColor = Color(0xFF585858),
                        unfocusedLabelColor = Color(0xFF292929)
                    ),
                )

                // Botón para crear la cuenta
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp)
                            .height(55.dp),
                        onClick = {
                            // Intenta crear el usuario con Firebase
                            auth.createUserWithEmailAndPassword(state.mail, state.password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Log.i("EDUARDO", "LOG OK") // Registro exitoso
                                    } else {
                                        Log.i("EDUARDO", "LOG NO") // Error en el registro
                                    }
                                }
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White,
                            disabledContentColor = Color.Black,
                            disabledContainerColor = Color(0xFF585858)
                        )
                    ) {
                        Text(text = "Siguiente", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}