package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maraloedev.myfirstcomposeapp.components.model.NavDrawer

@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable (() -> Unit)) {
    val scope = rememberCoroutineScope()
    val myItem = listOf(
        NavDrawer("Home", Icons.Default.Home, 3),
        NavDrawer("Fav", Icons.Default.Favorite, 0),
        NavDrawer("Build", Icons.Default.Build, 9),
        NavDrawer("Call", Icons.Default.Call, 0),
        NavDrawer("Location", Icons.Default.LocationOn, 3)
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer( //Contenedor del navigation
        drawerState = drawerState,
        drawerContent = { //Se crea el menu de dentro
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(10),
                drawerContentColor = Color.Red,
                drawerContainerColor = Color.Black,
                drawerTonalElevation = 10.dp

            ) {
                Spacer(Modifier.height(44.dp))
                myItem.forEachIndexed { index, drawer ->
                    NavigationDrawerItem(
                        label = { Text(text = drawer.name) },
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = { Icon(imageVector = drawer.icon, contentDescription = null) },
                        badge = { Text(text = drawer.notification.toString()) },
                        shape = CircleShape,
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Red,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            selectedBadgeColor = Color.Yellow,
                            unselectedContainerColor = Color.White,
                            unselectedTextColor = Color.Red,
                            unselectedBadgeColor = Color.Green,
                            unselectedIconColor = Color.Red


                        )
                    )
                }


            }
        },
        scrimColor = Color.Red.copy(0.6f) //Color una vez se abre el menu
    ) {
        content()

    }
}