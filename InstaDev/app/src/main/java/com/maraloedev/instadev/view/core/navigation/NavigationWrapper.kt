package com.maraloedev.instadev.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maraloedev.instadev.view.auth.login.LoginScreen
import com.maraloedev.instadev.view.auth.register.RegisterScreen

@Composable
fun NavigationWrapper() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(onNavigateToCreateNewAccount = { navController.navigate(route = Register) })
        }

        composable<Register> {
            RegisterScreen(onNavigateLogin = { navController.navigate(route = Login) })
        }
    }

}