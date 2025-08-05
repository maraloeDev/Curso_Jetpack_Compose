package com.maraloedev.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.model.SettingsModel

@Composable
fun DetailScreen(id: String, onNavigateToSettings: (SettingsModel) -> Unit) {

    var settingModel = SettingsModel(id = "Eduardo", darkMode = true)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(text = "DETAIL:$id", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = { onNavigateToSettings(settingModel) }) { Text(text = "Ajustes") }
        Spacer(Modifier.weight(1f))
    }

}