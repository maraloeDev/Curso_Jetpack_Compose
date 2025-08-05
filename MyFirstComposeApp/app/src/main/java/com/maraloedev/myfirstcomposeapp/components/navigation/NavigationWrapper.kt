package com.maraloedev.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.SettingsScreen
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.model.SettingsModel
import com.maraloedev.myfirstcomposeapp.components.navigation.types.createNavType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {

        composable<Login> { LoginScreen(onNavigateToHome = { navController.navigate(Home) }) }


        composable<Home> {
            HomeScreen(
                onNavigateToBack = { navController.popBackStack() },
                onNavigateToDetail = { navController.navigate(Detail(id = it)) })
        } //popBackStack es para ir atras

        composable<Detail> { navBackStartEntry ->
            val detail: Detail = navBackStartEntry.toRoute()
            DetailScreen(
                id = detail.id,
                onNavigateToSettings = { navController.navigate(Settings(it)) }
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsModel>() to createNavType<SettingsModel>())) { navBackEntry ->
            val settings = navBackEntry.toRoute<Settings>()
            SettingsScreen(settingsModel = settings.settingsModel, onNavigateToLogin = {
                navController.navigate(
                    Login
                ) {


                    //Esto sirve para eliminar una capa
                    popUpTo<Login> { inclusive = true } //El inclusive wBorra todas la vistas
                }
            })
        }
    }
}