package com.maraloedev.cursofirebaselite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.maraloedev.cursofirebaselite.view.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationWrapper(auth)
        }
    }

    // Si al iniciar la app, si esta logueado, entonces, vas a login, si no, vas a la Home
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

        if (currentUser!=null) {
            //navegas al login
        } else {
            //navegas a la Home
        }
    }
}