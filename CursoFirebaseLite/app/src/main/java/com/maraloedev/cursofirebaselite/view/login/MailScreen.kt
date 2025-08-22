package com.maraloedev.cursofirebaselite.view.login

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maraloedev.cursofirebaselite.R

@Composable
fun MailScreen(onNavigateToHome: () -> Unit) {

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(color = 0xFF111111)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .clickable { onNavigateToHome() }
                        .padding(all = 30.dp)
                        .size(size = 30.dp),
                    painter = painterResource(id = R.drawable.ic_back_24),
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(Modifier.width(width = 50.dp))
            }

            Spacer(Modifier.padding(top = 30.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp)
            ) {

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
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(color = 0xFF585858),
                        focusedBorderColor = Color(color = 0xFF585858),
                        unfocusedLabelColor = Color(color = 0xFF292929)
                    ))
                Spacer(Modifier.padding(top = 20.dp))

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
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(color = 0xFF585858),
                        focusedBorderColor = Color(color = 0xFF585858),
                        unfocusedLabelColor = Color(color = 0xFF292929)
                    ))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp)
                            .height(height = 55.dp),
                        onClick = { },
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White,
                            disabledContentColor = Color.Black,
                            disabledContainerColor = Color(color = 0xFF585858)
                        )
                    ) {
                        Text(text = "Iniciar sesion", fontWeight = FontWeight.Bold)
                    }
                        Spacer(Modifier.padding(top = 22.dp))
                    TextButton(
                        border = BorderStroke(width = 1.dp, color = Color(color = 0xFF222222)),
                        shape = RoundedCornerShape(size = 30.dp),
                        onClick = {}) {
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