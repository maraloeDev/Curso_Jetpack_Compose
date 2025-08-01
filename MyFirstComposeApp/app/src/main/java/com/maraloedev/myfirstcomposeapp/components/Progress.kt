package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun MyProgress(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(140.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            strokeCap = StrokeCap.Round,
            trackColor = Color.Blue //Es la parte estatica

        )

        Spacer(modifier = Modifier.height(24.dp))

        LinearProgressIndicator(
            modifier = Modifier,
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round


        )

    }

}

@Composable
fun ProgressAdvance(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0.5f) }
    val animatedProgress by animateFloatAsState(progress)
    var isLoading by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier.size(140.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            strokeCap = StrokeCap.Round,
            trackColor = Color.Blue //Es la parte estatica
        )

        Row(modifier = Modifier.padding(24.dp)) {
            Button(onClick = { progress += 0.1f }) { Text("<--") }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { progress -= 0.1f }) { Text("-->") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LinearProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier,
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )

        Button(onClick = { isLoading = !isLoading }) { Text("Mostrar/Ocultar") }

    }

}