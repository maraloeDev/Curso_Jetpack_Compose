@file:OptIn(ExperimentalMaterial3Api::class)

package com.maraloedev.twitter.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maraloedev.twitter.R

@Composable
fun LoginScreen(onNavigateToHome: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
            .background(Color(color = 0xFFFDFDFD)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {},
            navigationIcon = {
                Icon(
                    modifier = Modifier
                        .clickable { onNavigateToHome() }
                        .clip(
                            CircleShape
                        ), imageVector = Icons.Default.Close, contentDescription = ""
                )
            },
            actions = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.size(size = 25.dp),
                        painter = painterResource(id = R.drawable.iconx),
                        contentDescription = "Logo X"
                    )
                }
            })

        Text(
            modifier = Modifier.padding(end = 80.dp),
            text = "Para empezar,\nintroduce tu telefono,\ncorreo electrónico o\n@nombredeusuario",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 22.dp),
            value = "",
            onValueChange = {},
            label = {
                Text(
                    text = "Teléfono, correo electrónico o nombre de usuario",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF6E7679)
                )
            },
            minLines = 1
        )
        Spacer(modifier = Modifier.height(height = 500.dp))
        HorizontalDivider()

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                modifier = Modifier.padding(end = 5.dp),
                onClick = {},
            ) {
                Text(
                    text = "¿Olvidaste tu contraseña?",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier
                    .padding(start = 35.dp)
                    .fillMaxWidth(),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Siguiente",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}