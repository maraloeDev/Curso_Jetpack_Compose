package com.maraloedev.myfirstcomposeapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Pepe")
        Text(text = "Pepe rojo", color = Color.Red)
        Text(text = "Pepe rojo", fontSize = 25.sp)
        Text(text = "Pepe rojo", fontStyle = FontStyle.Italic)
        Text(
            text = "Pepe rojo",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text(text = "Letter Spacing", letterSpacing = 2.sp)
        Text(
            text = "TextDecoration",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = Modifier.clickable { })
        Text(
            text = "TextDecoration",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            text = "Align, Align  Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, ",
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis

        )
    }
}