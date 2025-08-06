package com.maraloedev.myfirstcomposeapp.components.animation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun MyCrossfade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("") }

    Column {
        Row {
            Text(modifier = Modifier.clickable { currentScreen = "Home" }, text = "Home")
            Text(modifier = Modifier.clickable { currentScreen = "Detail" }, text = "Detail")
            Text(modifier = Modifier.clickable { currentScreen = "Login" }, text = "Login")
        }

        Crossfade(targetState = currentScreen) { screen ->
            when(screen) {
                "Home"-> HomeScreen(onNavigateToBack = {}, onNavigateToDetail = { string: String ->})
                "Detail"-> DetailScreen(id = "", onNavigateToSettings = {})
                "Login"-> LoginScreen {  }
            }
        }
    }

}