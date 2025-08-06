package com.maraloedev.myfirstcomposeapp.components.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimatedAsState(modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }

    // Si esta seleccionado, se cambia el color a Rojo, si no, a Azul
    val animatedColor by animateColorAsState(
        targetValue = if (isSelected) Color.Red else Color.Blue
    )

    // Si esta seleccionado, se cambia el tamaño de la caja
    val animatedSize by animateDpAsState(targetValue = if (isSelected) 300.dp else 150.dp)
    val animatedOfSet by animateOffsetAsState(
        targetValue = if (isSelected) Offset(
            0f,
            300f
        ) else Offset(0f, 0f)
    )

    val animatedFloat by animateFloatAsState(targetValue = if (isSelected) 0.5f else 1f)

    Column {

        Button(onClick = { isSelected = !isSelected }) {
            Text("Seleccionar")
        }
        Text("Float: %.2f".format(animatedFloat))
        Spacer(Modifier.height(32.dp))

        Box(
            Modifier
                .offset(animatedOfSet.x.dp, animatedOfSet.y.dp)
                .size(animatedSize)
                .background(animatedColor)
        )
    }

}