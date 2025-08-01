package com.maraloedev.myfirstcomposeapp.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maraloedev.myfirstcomposeapp.components.state.CheckBoxState

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }) {

            Checkbox(
                modifier = modifier,
                checked = state,
                onCheckedChange = { state = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    checkmarkColor = Color.Blue,
                    uncheckedColor = Color.Blue,
                    disabledCheckedColor = Color.Yellow,
                    disabledUncheckedColor = Color.Green,
                )
            )
            Spacer(modifier.width(12.dp))
            Text(text = "Acepto los terminos de privacidad")
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState("terms", "Acepto los terminos y condiciones"),
                CheckBoxState("newsletter", "Recobor la newsletter", true),
                CheckBoxState("updates", "Recibir actualizaciones")
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()) {


        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map { // Recorre cada uno de los estados
                    if (it.id == myState.id) {
                        myState.copy(check = !myState.check, label = "")
                    } else {
                        it
                    }
                }
            }
        }
    }

}

@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkBoxState) }) {

        Checkbox(
            modifier = modifier,
            checked = checkBoxState.check,
            onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true,
        )
        Spacer(modifier.width(12.dp))
        Text(text = "Acepto los terminos de privaccidad")
    }


}