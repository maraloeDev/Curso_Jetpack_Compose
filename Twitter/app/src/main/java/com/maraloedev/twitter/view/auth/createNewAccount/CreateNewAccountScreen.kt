@file:OptIn(ExperimentalMaterial3Api::class)

package com.maraloedev.twitter.view.auth.createNewAccount

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maraloedev.twitter.R

@Composable
fun CreateNewAccountScreen(
    createNewAccountViewModel: CreateNewAccountViewModel = viewModel(),
    onNavigateToHome: () -> Unit = {}
) {
    val focusManager = LocalFocusManager.current
    val state by createNewAccountViewModel.state.collectAsState()
    var isPhoneFocused by remember { mutableStateOf(false) }


    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(all = 10.dp)
                .pointerInput(key1 = Unit) {
                    detectTapGestures { focusManager.clearFocus() }
                }
        ) {

            Row {
                Icon(
                    modifier = Modifier.clickable { onNavigateToHome() },
                    imageVector = Icons.Default.ArrowBack,
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
            Spacer(modifier = Modifier.height(height = 30.dp))

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "Crea tu cuenta",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(height = 160.dp))

            OutlinedTextField(
                value = state.name,
                onValueChange = { createNewAccountViewModel.isNameChange(name = it) },
                supportingText = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        if (state.name.length >= 50) {
                            Text(
                                text = "Debe tener 50 caracteres o menos.${state.name.length}/50",
                                fontSize = 13.sp,
                                color = Color(0xFFD36F73)
                            )
                        } else {
                            Text(text = "${state.name.length}/50", fontSize = 13.sp)

                        }
                    }
                },
                label = { Text(text = "Nombre") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true
            )

            OutlinedTextField(
                modifier = Modifier
                    .onFocusChanged { isPhoneFocused = it.isFocused },
                value = state.value,
                onValueChange = { createNewAccountViewModel.isValueChange(value = it) },
                label = { Text(text = "Telefono") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            /*OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Fecha de nacimiento") },
                placeholder = {
                    Text(
                        text = "DD/MM/YYYY"
                    )
                }
            )*/
            Spacer(modifier = Modifier.weight(weight = 0.5f))

            HorizontalDivider()

            Row {
                if (isPhoneFocused) {
                    OutlinedButton(onClick = {}) {
                        Text(text = "Usar correo")
                    }
                }

                Spacer(modifier = Modifier.weight(weight = 1f))
                OutlinedButton(onClick = {}) { Text(text = "Siguiente") }

            }
        }
    }
}

