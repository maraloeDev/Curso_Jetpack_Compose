package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier = Modifier) {
    var user by remember { mutableStateOf(value = "Eduardo") }
    var value by remember { mutableStateOf(value = "") }
    Column(modifier = modifier) {
        MyTextField(user = user, onUserChange = { user = it })
        MySecondTextField(value = value, onValueChange = { value = it })
        MyAdvancedTextField(value = value, onValueChange = { value = it })
        MyPasswordTextField(value = value, onValueChange = { value = it })


    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(
        value = user, onValueChange = { onUserChange(it) },
        readOnly = true
    )

}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Box(
                Modifier
                    .size(40.dp)
                    .background(Color.Red)
            )
        },
        label = { Text("Introdue tu email") })

}

@Composable
fun MyAdvancedTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
            if (it.contains("a")) {
                onValueChange(it.replace("a", ""))
            }
        }
    )

}

// Es para mostrar u ocultar el texto de la contraseña según el estado de la variable passwordHidden

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier.clickable { passwordHidden = !passwordHidden },
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text(text = "Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = { Text(text = if (passwordHidden) "Mostrar" else "Ocultar") }
    )
}