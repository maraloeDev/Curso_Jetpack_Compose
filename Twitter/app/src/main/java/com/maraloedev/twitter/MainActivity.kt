package com.maraloedev.twitter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maraloedev.twitter.ui.theme.TwitterTheme
import com.maraloedev.twitter.view.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwitterTheme {
                NavigationWrapper()
            }
        }
    }
}