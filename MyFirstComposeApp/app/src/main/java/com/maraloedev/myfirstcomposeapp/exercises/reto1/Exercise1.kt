package com.maraloedev.myfirstcomposeapp.exercises.reto1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Exercise1(modifier: Modifier = Modifier) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            Box(
                modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Cyan), contentAlignment =
                    Alignment.Center
            ) { Text(text = "Ejemplo 1") }
            Row(
                modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {

                Box(
                    modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center)
                { Text(text = "Ejemplo 2") }
                Box(
                    modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) { Text(text = "Ejemplo 3") }

            }
            Box(
                modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
            ) { Text(text = "Ejemplo 4") }
        }
    }
}
