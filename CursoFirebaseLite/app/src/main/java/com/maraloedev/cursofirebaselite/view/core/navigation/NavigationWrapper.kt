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
import com.maraloedev.cursofirebaselite.view.createNewAccount.CreateNewAccountScreen
import com.maraloedev.cursofirebaselite.view.register.RegisterScreen

/**
 * Composable principal que gestiona la navegación entre pantallas usando Navigation Compose.
 * @param auth Instancia de FirebaseAuth para autenticación (puede usarse en las pantallas).
 */
@Composable
fun NavigationWrapper(auth: FirebaseAuth) {

    // Crea y recuerda el NavController para gestionar la navegación.
    val navController = rememberNavController()

    // Define el NavHost con la pantalla de inicio y las rutas de navegación.
    NavHost(navController = navController, startDestination = Home) {

        // Pantalla principal (Home)
        composable<Home> {
            HomeScreen(
                onNavigateToRegister = { navController.navigate(route = Register) },
                onNavigateToLoginScreen = { navController.navigate(route = Login) }
            )
        }

        // Pantalla de registro
        composable<Register> {
            RegisterScreen(
                onNavigateToHome = { navController.navigate(route = Home) },
                onNavigateToContinueMail = { navController.navigate(route = CreateNewAccountScreen) },
                onNavigateToLoginScreen = { navController.navigate(route = Login) }
            )
        }

        // Pantalla para continuar con correo
        composable<CreateNewAccountScreen> {
            CreateNewAccountScreen(
                auth = auth,
                onNavigateToRegister = { navController.navigate(route = Register) }
            )
        }

        // Pantalla de login
        composable<Login> {
            LoginScreen(
                onNavigateToHome = { navController.navigate(route = Home) },
                onNavigateToMail = { navController.navigate(route = MailScreen) },
                onNavigateToRegister = { navController.navigate(route = Register) }
            )
        }

        // Pantalla de login sin contraseña
        composable<LoginWithoutPassword> {
            LoginWithoutPasswordScreen(
                onNavigateToContinueMail = { navController.navigate(route = MailScreen) }
            )
        }

        // Pantalla de ingreso por correo
        composable<MailScreen> {
            MailScreen(
                auth = auth,
                onNavigateToLoginScreen = { navController.navigate(route = Login) },
                onNavigateToLoginWithoutPassword = { navController.navigate(route = LoginWithoutPassword) }
            )
        }
    }
}