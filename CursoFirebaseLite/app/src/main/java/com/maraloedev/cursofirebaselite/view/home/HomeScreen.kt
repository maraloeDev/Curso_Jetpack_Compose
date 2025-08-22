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

@Composable
fun HomeScreen(onNavigateToRegister: () -> Unit, onNavigateToLoginScreen: () -> Unit) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(color = 0xFF111111)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(Modifier.height(height = 240.dp))
            Image(
                modifier = Modifier
                    .background(Color.Black)
                    .size(size = 60.dp),
                painter = painterResource(id = R.drawable.spotify),
                contentDescription = "Logo Spotify"
            )

            Text(
                text = "Millones de canciones.\nGratis en Spotify.",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp
            )

            Spacer(Modifier.height(height = 100.dp))

            Column {
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .size(size = 50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF111111),
                        containerColor = Color(color = 0xFF1CD35D)
                    ),
                    onClick = { onNavigateToRegister() }) {
                    Text(
                        text = "Registrarte gratis", fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(height = 10.dp))
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                        .size(size = 50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    ),
                    onClick = { onNavigateToLoginScreen() }) {
                    Text(
                        text = "Iniciar sesión", fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(Modifier.height(height = 30.dp))
        }
    }
}