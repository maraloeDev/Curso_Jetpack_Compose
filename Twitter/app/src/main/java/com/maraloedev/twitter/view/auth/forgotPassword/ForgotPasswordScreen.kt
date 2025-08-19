package com.maraloedev.twitter.view.auth.forgotPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maraloedev.twitter.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    forgotPasswordViewModel: ForgotPasswordViewModel = viewModel(),
    onNavigateToHome: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val state by forgotPasswordViewModel.state.collectAsState()
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .pointerInput(key1 = Unit) {
                    detectTapGestures { focusManager.clearFocus() }
                }
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
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
                Spacer(modifier = Modifier.weight(weight = 1f))
                Image(
                    modifier = Modifier.size(size = 25.dp),
                    painter = painterResource(id = R.drawable.iconx),
                    contentDescription = "Logo X"
                )
                Spacer(modifier = Modifier.weight(weight = 1.15f))
            }
            Spacer(Modifier.height(height = 30.dp))
            Text(
                modifier = Modifier.padding(all = 3.dp),
                text = "Encuentra tu cuenta de X",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(height = 5.dp))
            Text(
                modifier = Modifier.padding(all = 3.dp),
                text = "Introduce el correo electronico, el numero de telefono o el nombre de usuario asociados a tu cuenta para cambiar tu contraseña,",
                textAlign = TextAlign.Justify,
                color = Color.Gray
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp),
                value = state.value,
                onValueChange = { forgotPasswordViewModel.isValid(value = it) },
                minLines = 1,
                label = { Text(text = "Correo electronico, numero de...") })

            Spacer(modifier = Modifier.weight(weight = 1.15f))

            HorizontalDivider()
            Spacer(modifier = Modifier.padding(all = 5.dp))
            OutlinedButton(
                modifier = Modifier.padding(start = 270.dp),
                onClick = {},
                enabled = state.isEnabled,
                colors = ButtonDefaults.buttonColors(containerColor = Color(color = 0xFF646464))
            ) {
                Text(
                    text = "Siguiente",
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.6.sp
                )
            }
        }

    }
}