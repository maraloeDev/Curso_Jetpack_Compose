package com.maraloedev.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.maraloedev.myfirstcomposeapp.R

@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(30))
            .border(
                width = 5.dp,
                shape = CircleShape,
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Yellow, Color.Blue))
            ),
        painter = painterResource(R.drawable.cangrejo),
        contentDescription = "Avatar image profile",
        contentScale = ContentScale.Inside

    )

}

@Composable
//Los iconos nos permiten tintar las imagenes
fun MyIcon() {
    Icon(
        modifier = Modifier.size(300.dp),
        painter = painterResource(R.drawable.ic_personita),
        contentDescription = null,
        tint = Color.Blue
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(
        modifier = modifier.size(250.dp),
        model = "https://www.shutterstock.com/image-vector/vector-illustration-sea-animal-600nw-2437990151.jpg",
        contentDescription = "Image from network",
        onError = { Log.i("Error image", "Ha ocurrido un error ${it.result.throwable.message}") }
    )
}