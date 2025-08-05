package com.maraloedev.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onNavigateToBack:()-> Unit, onNavigateToDetail: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(text = "HOME", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Row {
            TextField(
                modifier = Modifier.weight(1f),
                value = text,
                onValueChange = { text = it }
            )
            Button(onClick = { onNavigateToDetail(text) }) { Text(text = "Detail") }
        }
            Spacer(Modifier.weight(1f))
            Button(onClick = { onNavigateToBack() }) { Text(text = "Atras") }
    }

}