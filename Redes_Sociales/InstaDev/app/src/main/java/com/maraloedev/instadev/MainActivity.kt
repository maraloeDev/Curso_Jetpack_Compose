package com.maraloedev.instadev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maraloedev.instadev.ui.theme.InstaDevTheme
import com.maraloedev.instadev.view.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaDevTheme {
                NavigationWrapper()
            }
        }
    }
}