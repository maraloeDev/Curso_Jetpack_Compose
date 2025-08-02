package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maraloedev.myfirstcomposeapp.components.model.NavItem

@Composable
fun MyNavigationBar() { //ES EL RECOMENDADO PARA NAVEGAR ENTRE 3 Y 5 TABS

    val itemList = listOf(
        NavItem("Home", icon = Icons.Default.Home),
        NavItem("Favorite", icon = Icons.Default.Favorite),
        NavItem("Person", icon = Icons.Default.Person)
    )

    var selectedIndex by remember { mutableIntStateOf(2) } //Indice que marca el seleccionado
    NavigationBar(
        containerColor = Color.Red,
        tonalElevation = 10.dp
    ) {
        itemList.forEachIndexed { index, itemList ->
            EduardoList(navItem = itemList, isSelected = index == selectedIndex) {
                selectedIndex = index
            }
        }
    }
}

@Composable
fun RowScope.EduardoList(navItem: NavItem, isSelected: Boolean, onItemClick: () -> Unit) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { onItemClick() },
        icon = {
            Icon(imageVector = navItem.icon, contentDescription = null)
        },
        label = { Text(text = navItem.name) },
        alwaysShowLabel = false, // Es para que se vea al label solamente si esta seleccionadp
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red,
            selectedTextColor = Color.White,
            indicatorColor = Color.White,
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.White,
            disabledIconColor = Color.Gray,
            disabledTextColor = Color.Gray
        )
    )

}