@file:OptIn(ExperimentalMaterial3Api::class)

package com.maraloedev.twitter.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maraloedev.twitter.R

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    onNavigateToHome: () -> Unit,
    onNavigateToForgotPassword: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val state by loginViewModel.state.collectAsState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .pointerInput(Unit) {
                    detectTapGestures { focusManager.clearFocus() }
                }
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.clickable { onNavigateToHome() },
                    imageVector = Icons.Default.Close,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.iconx),
                    contentDescription = "Logo X"
                )
                Spacer(modifier = Modifier.weight(1.15f))
            }
            Spacer(Modifier.height(height = 50.dp))

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
                value = state.value,
                onValueChange = { loginViewModel.isValid(value = it) },
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
            Spacer(modifier = Modifier.height(height = 470.dp))

            HorizontalDivider()

            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(
                    modifier = Modifier.padding(end = 5.dp),
                    onClick = { onNavigateToForgotPassword() },
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
                    enabled = state.isEnabled,
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
}