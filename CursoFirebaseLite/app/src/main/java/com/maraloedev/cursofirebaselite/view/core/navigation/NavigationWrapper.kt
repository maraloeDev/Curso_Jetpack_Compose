package com.maraloedev.cursofirebaselite.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.maraloedev.cursofirebaselite.view.home.HomeScreen
import com.maraloedev.cursofirebaselite.view.login.LoginScreen
import com.maraloedev.cursofirebaselite.view.login.LoginWithoutPasswordScreen
import com.maraloedev.cursofirebaselite.view.login.MailScreen
import com.maraloedev.cursofirebaselite.view.register.ContinueMail
import com.maraloedev.cursofirebaselite.view.register.RegisterScreen

@Composable
fun NavigationWrapper(auth: FirebaseAuth) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LoginWithoutPassword) { //CHANGE

        composable<Home> {
            HomeScreen(
                onNavigateToRegister = { navController.navigate(route = Register) },
                onNavigateToLoginScreen = { navController.navigate(route = Login) })
        }

        composable<Register> {
            RegisterScreen(
                onNavigateToHome = { navController.navigate(route = Home) },
                onNavigateToContinueMail = { navController.navigate(route = ContinueMail) },
                onNavigateToLoginScreen = { navController.navigate(route = Login) })
        }

        composable<ContinueMail> {
            ContinueMail(onNavigateToRegister = { navController.navigate(route = Register) })
        }

        composable<Login> {
            LoginScreen(
                onNavigateToHome = { navController.navigate(route = Home) },
                onNavigateToMail = { navController.navigate(route = MailScreen) },
                onNavigateToRegister = { navController.navigate(route = Register) })
        }

        composable<LoginWithoutPassword> {
            LoginWithoutPasswordScreen(onNavigateToContinueMail = { navController.navigate(ContinueMail) })
        }

        composable<MailScreen> {
            MailScreen(onNavigateToHome = { navController.navigate(route = Home) })
        }
    }

}