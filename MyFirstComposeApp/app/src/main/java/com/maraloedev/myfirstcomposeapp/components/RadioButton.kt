package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(false) }

    RadioButton(
        modifier = modifier,
        selected = state,
        onClick = { state = true },
        enabled = true,
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Red,
            unselectedColor = Color.Yellow,
            disabledSelectedColor = Color.Green,
            disabledUnselectedColor = Color.Magenta

        )
    )
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName by remember { mutableStateOf("") }

    Column {
        MyRadioButtonComponent(name = "Eduardo", selectedName = selectedName) { selectedName = it }
        MyRadioButtonComponent(name = "Matias", selectedName = selectedName) { selectedName = it }
        MyRadioButtonComponent(name = "Ricardo", selectedName = selectedName) { selectedName = it }
        MyRadioButtonComponent(name = "Manuel", selectedName = selectedName) { selectedName = it }
        MyRadioButtonComponent(name = "Angel", selectedName = selectedName) { selectedName = it }
        MyRadioButtonComponent(name = "Maria", selectedName = selectedName) { selectedName = it }
        MyRadioButtonComponent(name = "Carmen", selectedName = selectedName) { selectedName = it }

    }

    
}

@Composable
fun MyRadioButtonComponent(name: String, selectedName:String, onItemSelected:(String)-> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = name == selectedName,
            onClick = { onItemSelected(name)})
        Text(name)
    }

}