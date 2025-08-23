package com.maraloedev.cursofirebaselite.view.login

import androidx.compose.foundation.Image
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.maraloedev.cursofirebaselite.R

/**
 * Pantalla de inicio de sesión.
 * @param onNavigateToHome Navega a la pantalla principal.
 * @param onNavigateToRegister Navega a la pantalla de registro.
 * @param onNavigateToMail Navega a la pantalla de login por correo.
 */
@Composable
fun LoginScreen(
    auth: FirebaseAuth = Firebase.auth,
    onNavigateToHome: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onNavigateToMail: () -> Unit
) {
    // Estructura principal con Scaffold para manejar el padding del sistema
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFF111111)), // Fondo oscuro
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Icono de retroceso, alineado a la izquierda
            Icon(
                modifier = Modifier
                    .clickable { onNavigateToHome() }
                    .align(Alignment.Start)
                    .padding(all = 30.dp)
                    .size(30.dp),
                painter = painterResource(id = R.drawable.ic_back_24),
                contentDescription = "",
                tint = Color.White
            )

            Spacer(Modifier.height(20.dp))

            // Logo de la app
            Image(
                modifier = Modifier
                    .background(Color.Black)
                    .size(60.dp),
                painter = painterResource(id = R.drawable.spotify),
                contentDescription = "Logo Spotify"
            )

            // Título de la pantalla
            Text(
                text = "Iniciar sesión en\nSpotify",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp
            )

            // Column para los botones de login
            Column {
                // Botón para continuar con correo
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .size(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF111111),
                        containerColor = Color(0xFF1CD35D)
                    ),
                    onClick = { onNavigateToMail() }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.mail),
                            contentDescription = ""
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            modifier = Modifier.padding(end = 50.dp),
                            text = "Continuar con correo",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Botón para continuar con Google
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .size(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    onClick = { /*REGISTRO GOOGLE*/ }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Logo Google"
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            modifier = Modifier.padding(end = 55.dp),
                            text = "Continuar con google",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Botón para continuar con Facebook
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .size(size = 50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    onClick = { /*REGISTRO FACEBOOK*/ }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Logo Google"
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            modifier = Modifier.padding(end = 55.dp),
                            text = "Continuar con Facebook",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                Spacer(Modifier.padding(top = 50.dp))

                // Sección para registro si no tiene cuenta
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "No tienes cuenta?",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                    TextButton(onClick = { onNavigateToRegister() }) {
                        Text(
                            text = "Registrate",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(Modifier.height(height = 50.dp))
            }
        }
    }
}