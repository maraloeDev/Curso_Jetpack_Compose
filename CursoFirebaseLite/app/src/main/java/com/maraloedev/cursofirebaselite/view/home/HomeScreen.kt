package com.maraloedev.cursofirebaselite.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maraloedev.cursofirebaselite.R

/**
 * Pantalla principal de bienvenida.
 * @param onNavigateToRegister Navega a la pantalla de registro.
 * @param onNavigateToLoginScreen Navega a la pantalla de inicio de sesión.
 */
@Composable
fun HomeScreen(
    onNavigateToRegister: () -> Unit,
    onNavigateToLoginScreen: () -> Unit
) {
    // Scaffold para manejar el padding del sistema y la estructura base
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFF111111)), // Fondo oscuro
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Espaciado superior para centrar el contenido
            Spacer(Modifier.height(240.dp))

            // Logo de la aplicación
            Image(
                modifier = Modifier
                    .background(Color.Black)
                    .size(60.dp),
                painter = painterResource(id = R.drawable.spotify),
                contentDescription = "Logo Spotify"
            )

            // Título principal
            Text(
                text = "Millones de canciones.\nGratis en Spotify.",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp
            )

            // Espaciado entre el título y los botones
            Spacer(Modifier.height(100.dp))

            // Column para los botones de acción
            Column {
                // Botón para registrarse
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .size(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF111111),
                        containerColor = Color(0xFF1CD35D)
                    ),
                    onClick = { onNavigateToRegister() }
                ) {
                    Text(
                        text = "Registrarte gratis",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                // Botón para iniciar sesión
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .size(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    onClick = { onNavigateToLoginScreen() }
                ) {
                    Text(
                        text = "Iniciar sesión",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            // Espaciado inferior
            Spacer(Modifier.height(30.dp))
        }
    }
}