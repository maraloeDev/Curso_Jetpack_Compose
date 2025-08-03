@file:OptIn(ExperimentalMaterial3Api::class)

package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.maraloedev.myfirstcomposeapp.components.model.PokemonCombat
import java.util.Calendar

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = { showDialog = false },
            //Boton dee confirmacion
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                }) { Text(text = "Entendido") }
            },
            dismissButton = {
                Button(onClick = {
                    showDialog = false
                }) { Text(text = "Cancelar") }
            },
            text = { Text("Esta el mi descripcion") },
            title = { Text(text = "Quieres hacer esta accion") },
            icon = {
                Icon(
                    modifier = Modifier.size(52.dp),
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(12),
            containerColor = Color.White,
            iconContentColor = Color.Red,
            titleContentColor = Color.Red,
            textContentColor = Color.Red,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn, //Esto es por seguridad, permite que puedas hacer screenshot
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        )
    }
}

@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()

    calendar.add(Calendar.DAY_OF_YEAR, +1)
    calendar.set(Calendar.DAY_OF_MONTH, Calendar.JANUARY)

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        yearRange = 2024..2025,//Rango de años en el calendario
        initialDisplayMode = DisplayMode.Picker
    )


    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                }) { Text(text = "Confirmars") }
            },
            colors = DatePickerDefaults.colors()
        ) { DatePicker(datePickerState) }
    }
}

@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {

    var showTimePicker by remember { mutableStateOf(true) }
    var timePickerState = rememberTimePickerState(
        initialHour = 7,
        initialMinute = 33,
        is24Hour = true

    )

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .background(Color.White)
            ) {
                TimePicker(
                    timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.Red,
                        clockDialSelectedContentColor = Color.Red,
                        selectorColor = Color.White,
                        clockDialUnselectedContentColor = Color.White,
                        //containerColor = Color.White
                        periodSelectorBorderColor = Color.Red,
                        periodSelectorUnselectedContentColor = Color.Red,
                        periodSelectorUnselectedContainerColor = Color.Red,
                        periodSelectorSelectedContainerColor = Color.Red,
                        periodSelectorSelectedContentColor = Color.White,
                        timeSelectorUnselectedContentColor = Color.Red,
                        timeSelectorUnselectedContainerColor = Color.Red,
                        timeSelectorSelectedContainerColor = Color.Red,
                        timeSelectorSelectedContentColor = Color.White

                    )
                )
            }
        }
    }

}

@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    pokemonCombat: PokemonCombat,
    showDialog: Boolean,
    onDimissDialog: () -> Unit,
    onStartCombat: () -> Unit
) {

    if (showDialog) {
        Dialog(onDismissRequest = { onDimissDialog() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(24)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = pokemonCombat.pokemonA,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(text = "VS")
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = pokemonCombat.pokemonB,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                }
                Button(onClick = { onDimissDialog() }) {
                    Text(text = "A LUCHAR!")
                }

                TextButton(onClick = { onDimissDialog() }) { Text(text = "Cancelar") }
            }

        }

    }

}