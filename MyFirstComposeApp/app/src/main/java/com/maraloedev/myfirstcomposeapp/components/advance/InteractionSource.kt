package com.maraloedev.myfirstcomposeapp.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InteractionSource(modifier: Modifier = Modifier) {
    var interaction = remember { MutableInteractionSource() }
    val isPressed by interaction.collectIsPressedAsState()

    Box(
        modifier
            .size(150.dp)
            .background(if (isPressed) Color.Red else Color.White)
            .clickable(interactionSource = interaction, indication = null) {

            },
        contentAlignment = Alignment.Center
    ) {

        Text(text = if (isPressed) "Pulsado" else "Sin Pulsar")

    }

}