package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Una Card es un contenedor para agrupar informacion
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyCard(modifier: Modifier = Modifier) {
    Scaffold { paddingValues ->
        Card(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = CircleShape,
            border = BorderStroke(2.dp, Color.Red),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Green,
                contentColor = Color.Blue,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.DarkGray
            ),
            enabled = false,
            onClick = {}
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .padding(16.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                )
                Column {
                    Text(
                        text = "Eduardo Martín-Sonseca Alonso",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Eduardo es muy guapo")
                }
            }
        }
    }
}