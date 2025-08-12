package com.maraloedev.instadev.view.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    onNavigateLogin: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val state by registerViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = { focusManager.clearFocus() })
                }
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier.align(Alignment.Start),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                onClick = { onNavigateLogin() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = ""
                )
            }

            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "¿Cuál es tu número de móvil?",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(text = "Introduce tu número de móvil de contacto. Nadie lo verá en tu perfil")
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.mobilePhone,
                shape = RoundedCornerShape(30),
                onValueChange = { registerViewModel.isPhoneChange(mobilePhone = it) },
                label = { Text(text = "Número de móvil") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(Modifier.height(15.dp))
            Text(
                text = "Puede que recibas notificaciones nuestras en WhatsApp y por SMS por motivos de seguridad y para iniciar sesión.",
                fontSize = 12.sp
            )
            Spacer(Modifier.height(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = state.isEnabled
            ) { Text(text = "Siguiente") }
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, color = Color(0xFFD3D2D5)),
                onClick = {}) { Text(text = "Registrarte con tu correo electrónico") }
            Spacer(Modifier.weight(1f))
            TextButton(onClick = {}) { Text(text = "Ya tengo una cuenta") }
        }
    }
}