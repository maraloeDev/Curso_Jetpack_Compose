package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.maraloedev.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text("Idioma") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) } // Es para tener la flecha de la derecha

        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = true }) {

            DropdownMenuItem(text = { Text(text = "Opcion 1") }, onClick = {
                selection = "Opcion 1"
                expanded = false
            })
            DropdownMenuItem(text = { Text(text = "Opcion 2") }, onClick = {
                selection = "Opcion 2"
                expanded = false
            })
            DropdownMenuItem(text = { Text(text = "Opcion 3") }, onClick = {
                selection = "Opcion 3"
                expanded = false
            })
            DropdownMenuItem(text = { Text(text = "Opcion 4") }, onClick = {
                selection = "Opcion 4"
                expanded = false
            })

        }
    }

}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    //Se crea una variable expanded para saber si esta expandido
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier.padding(start = 30.dp)) {

        Button(onClick = { expanded = true }) { Text(text = "Ver opciones") }

        //Aqui van los items, onDismissRequest es la funcion que se llama cuando pulsas fuera del menu
        DropdownMenu(
            expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 16.dp), //Sirve para mover el menu de opciones
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = true,
                dismissOnBackPress = false,
                clippingEnabled = true //El Dropdown menu, es para que no se salga de la pantalla
            )
        ) {
            DropdownMenuItem(text = { Text(text = "Opcion 1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opcion 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opcion 3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opcion 4") }, onClick = { expanded = false })

        }
    }

}

@Composable
//El dropdown es la estructura que almacena los Items
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {

        DropdownMenuItem(
            modifier = modifier,
            text = { Text("Ejemplo 1") },
            onClick = {},
            leadingIcon = /*Es el icono de la izquierda*/ {
                Icon(
                    painter = painterResource(R.drawable.ic_info), contentDescription = null
                )
            },
            trailingIcon = /*Es el icono de la derecha*/ {
                Icon(
                    painter = painterResource(R.drawable.ic_personita), contentDescription = null
                )
            },
            enabled = true,
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Blue,
                trailingIconColor = Color.Green,
                disabledTextColor = Color.Yellow,
                disabledLeadingIconColor = Color.Yellow,
                disabledTrailingIconColor = Color.Yellow,

                )

        )
    }

}