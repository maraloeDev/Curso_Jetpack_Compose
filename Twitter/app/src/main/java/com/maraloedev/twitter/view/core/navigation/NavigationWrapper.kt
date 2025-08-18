package com.maraloedev.twitter.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maraloedev.twitter.view.auth.login.LoginScreen
import com.maraloedev.twitter.view.home.HomeScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(onNavigateToLogin = { navController.navigate(route = Login) })
        }

        composable<Login> {
            LoginScreen(onNavigateToHome = { navController.navigate(route = Home) })
        }
    }
}
