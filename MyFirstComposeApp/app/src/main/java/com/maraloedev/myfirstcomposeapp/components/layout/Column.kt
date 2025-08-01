package com.maraloedev.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hola 1", modifier = Modifier.background(Color.Red).weight(1f))
        Text(text = "Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text(text = "Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text(text = "Hola 4", modifier = Modifier.background(Color.Blue).weight(1f))
        Text(text = "Hola 1", modifier = Modifier.background(Color.Red).weight(1f))
        Text(text = "Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text(text = "Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text(text = "Hola 4", modifier = Modifier.background(Color.Blue).weight(1f))
        Text(text = "Hola 1", modifier = Modifier.background(Color.Red).weight(1f))
        Text(text = "Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text(text = "Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text(text = "Hola 4", modifier = Modifier.background(Color.Blue).weight(1f))
        Text(text = "Hola 1", modifier = Modifier.background(Color.Red).weight(1f))
        Text(text = "Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text(text = "Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text(text = "Hola 4", modifier = Modifier.background(Color.Blue).weight(1f))
        Text(text = "Hola 1", modifier = Modifier.background(Color.Red).weight(1f))
        Text(text = "Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text(text = "Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text(text = "Hola 4", modifier = Modifier.background(Color.Blue).weight(1f))
        Text(text = "Hola 1", modifier = Modifier.background(Color.Red).weight(1f))
        Text(text = "Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text(text = "Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text(text = "Hola 4", modifier = Modifier.background(Color.Blue).weight(1f))

    }

}