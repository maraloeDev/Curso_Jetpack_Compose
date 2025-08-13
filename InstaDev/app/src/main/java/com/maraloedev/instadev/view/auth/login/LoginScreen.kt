package com.maraloedev.instadev.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maraloedev.instadev.R

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel(), onNavigateToCreateNewAccount:() -> Unit) {

    //Cuando la pantalla muera, la subscripcion muere
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current

    Scaffold { paddingValues ->
        loginViewModel
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = { focusManager.clearFocus() })
                }
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = stringResource(R.string.login_screen_text_spanish_spain),
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(Modifier.weight(1f))

            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "Logo InstaDev"
            )
            Spacer(Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(R.string.login_screen_outlined_text_field_user_email_phone),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                shape = RoundedCornerShape(30),
                value = uiState.email,
                onValueChange = { loginViewModel.onEmailChange(email = it) })
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(R.string.login_screen_outlined_text_field_password),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                shape = RoundedCornerShape(30),
                value = uiState.password,
                onValueChange = { loginViewModel.onPasswordChange(password = it) })
            Spacer(Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ), onClick = { },
                shape = MaterialTheme.shapes.extraLarge,
                enabled = uiState.isLoginEnabled
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = stringResource(R.string.login_screen_button_Login)
                )
            }
            TextButton(onClick = { }) {
                Text(
                    stringResource(R.string.login_screen_text_Button_Forgot_Password),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onNavigateToCreateNewAccount() },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = stringResource(R.string.login_screen_text_Button_Create_new_account),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }

}