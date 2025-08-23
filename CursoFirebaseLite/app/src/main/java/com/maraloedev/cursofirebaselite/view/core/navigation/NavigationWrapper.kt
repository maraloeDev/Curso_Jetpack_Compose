package com.maraloedev.cursofirebaselite.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.maraloedev.cursofirebaselite.view.createNewAccount.CreateNewAccountScreen
import com.maraloedev.cursofirebaselite.view.home.HomeScreen
import com.maraloedev.cursofirebaselite.view.login.LoginScreen
import com.maraloedev.cursofirebaselite.view.login.LoginWithoutPasswordScreen
import com.maraloedev.cursofirebaselite.view.login.MailScreen
import com.maraloedev.cursofirebaselite.view.register.RegisterScreen

/**
 * Composable principal encargado de gestionar la navegación entre pantallas usando Navigation Compose.
 * @param auth Instancia de FirebaseAuth para operaciones de autenticación.
 */
@Composable
fun NavigationWrapper(auth: FirebaseAuth) {

    // Se crea y recuerda el NavController, necesario para controlar la navegación.
    val navController = rememberNavController()

    // NavHost define el grafo de navegación y la pantalla inicial.
    NavHost(navController = navController, startDestination = Home) {

        // Ruta: Pantalla principal (Home)
        composable<Home> {
            HomeScreen(
                onNavigateToRegister = { navController.navigate(route = Register) },
                onNavigateToLoginScreen = { navController.navigate(route = Login) }
            )
        }

        // Ruta: Pantalla de registro de usuario
        composable<Register> {
            RegisterScreen(
                onNavigateToHome = { navController.navigate(route = Home) },
                onNavigateToContinueMail = { navController.navigate(route = CreateNewAccountScreen) },
                onNavigateToLoginScreen = { navController.navigate(route = Login) }
            )
        }

        // Ruta: Pantalla para crear nueva cuenta con correo
        composable<CreateNewAccountScreen> {
            CreateNewAccountScreen(
                auth = auth,
                onNavigateToRegister = { navController.navigate(route = Register) }
            )
        }

        // Ruta: Pantalla de inicio de sesión
        composable<Login> {
            LoginScreen(
                onNavigateToHome = { navController.navigate(route = Home) },
                onNavigateToMail = { navController.navigate(route = MailScreen) },
                onNavigateToRegister = { navController.navigate(route = Register) }
            )
        }

        // Ruta: Pantalla de login sin contraseña
        composable<LoginWithoutPassword> {
            LoginWithoutPasswordScreen(
                onNavigateToContinueMail = { navController.navigate(route = MailScreen) }
            )
        }

        // Ruta: Pantalla de ingreso por correo electrónico
        composable<MailScreen> {
            MailScreen(
                auth = auth,
                onNavigateToLoginScreen = { navController.navigate(route = Login) },
                onNavigateToLoginWithoutPassword = { navController.navigate(route = LoginWithoutPassword) }
            )
        }
    }
}