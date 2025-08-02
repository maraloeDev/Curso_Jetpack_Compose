package com.maraloedev.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.maraloedev.myfirstcomposeapp.R

@Composable
fun MyButton(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Button(
            onClick = { Log.i("Eduardo", "Boton pulsado") },
            enabled = false,
            shape = RoundedCornerShape(30.dp), // Una shape es el redondeado del boton
            border = BorderStroke(2.dp, color = Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red, //Es el color de lo de dentro
                containerColor = Color.White, //Es el color del contenedor
                disabledContainerColor = Color.Yellow,
                disabledContentColor = Color.Green

            )
        ) {
            Text(
                text = "Pulsame",
            )
        }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "OutlinedButton")
        }

        TextButton(onClick = {}, colors = ButtonDefaults.buttonColors()) {
            Text(text = "TextButton")
        }

        //Se crea una sombra al rededor del boton
        ElevatedButton(
            onClick = {}, elevation = ButtonDefaults.buttonElevation(
                //pressedElevation = //Es mientras se mantiene presionado
            )
        ) {
            Text(
                text = "ElevatedButton"
            )
        }
    }

}

@Composable
fun MyFAB(modifier: Modifier = Modifier) {

    FloatingActionButton(onClick = {}, shape = CircleShape) {
        Icon(painter = painterResource(R.drawable.ic_add), contentDescription = null)
    }

}