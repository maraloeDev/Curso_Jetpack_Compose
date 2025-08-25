package com.maraloedev.twitter.view.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maraloedev.twitter.R

@Composable
fun HomeScreen(onNavigateToLogin: () -> Unit, onNavigateToCreateNewAccount: () -> Unit) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(size = 25.dp),
                painter = painterResource(id = R.drawable.iconx),
                contentDescription = "Logo X"
            )

            Spacer(Modifier.padding(99.dp))

            Text(
                text = "Entérate de lo que\nestá pasando en\nel mundo en este\nmomento.",
                modifier = Modifier.padding(end = 30.dp),
                textAlign = TextAlign.Start,
                fontSize = 35.sp,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp
            )

            Spacer(Modifier.height(130.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .border(border = BorderStroke(1.dp, Color(0xFFDDDFDF)), shape = CircleShape)
                    .height(50.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )

            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(25.dp),
                    painter = painterResource(id = R.drawable.logogoogle),
                    contentDescription = "Logo Google"
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Continuar con Google",
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "o",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                HorizontalDivider(modifier = Modifier.weight(1f))
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                onClick = { onNavigateToCreateNewAccount() }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(
                    "Crear cuenta", fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(Modifier.height(height = 10.dp))
            Text(
                modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                text = "Al registrarte, aceptas los Terminos, la politica\n de privacidad y la Politica de cookies",
                color = Color.Gray,
                fontSize = 13.sp,
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
            Spacer(Modifier.height(55.dp))

            Row(
                modifier = Modifier.padding(end = 40.dp)
            ) {
                Text(
                    text = "¿Ya tienes una cuenta? ",
                    color = Color.Gray,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier
                        .clickable { onNavigateToLogin() },
                    text = "Inicia Sesión",
                    color = Color(0xFF1DA1F2), // Azul de Twitter
                    fontSize = 15.sp

                )
            }
        }
    }
}