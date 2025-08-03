package com.maraloedev.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.maraloedev.myfirstcomposeapp.components.MyCustomDialog
import com.maraloedev.myfirstcomposeapp.components.MyFAB
import com.maraloedev.myfirstcomposeapp.components.MyModalDrawer
import com.maraloedev.myfirstcomposeapp.components.MyNavigationBar
import com.maraloedev.myfirstcomposeapp.components.MyTopAppBar
import com.maraloedev.myfirstcomposeapp.components.model.PokemonCombat
import com.maraloedev.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                var showDialog by remember { mutableStateOf(false) }
                val pokemonCombat = PokemonCombat("Pikachu", "Gengar")

                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onStartCombat = {showDialog = false},
                    onDimissDialog = {showDialog = false}) //Dialogos por encima, debido a que se quiere mostrar primero
                MyModalDrawer(drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
                        snackbarHost = { SnackbarHost(snackbarHostState) },
                        floatingActionButton = { MyFAB { showDialog = true } },
                        floatingActionButtonPosition = FabPosition.Start,
                        bottomBar = { MyNavigationBar() }) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(Color.Cyan), contentAlignment = Alignment.Center
                        ) {
                            Text("Esta es mi screen", Modifier.clickable {
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "Ejemplo 1",
                                        actionLabel = "Deshacer" //Cierra el snackbar, y se puede deshacer la accion
                                    )

                                    if (result == SnackbarResult.ActionPerformed) {
                                        //pulso deshacer
                                    } else {
                                        //No hiza nada
                                    }
                                }
                            })
                        }
                    }
                }

            }
        }
    }
}