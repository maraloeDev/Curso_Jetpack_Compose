package com.maraloedev.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maraloedev.myfirstcomposeapp.components.MyTopAppBar
import com.maraloedev.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() }) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text("Esta es mi screen")
                    }
                }
            }
        }
    }
}