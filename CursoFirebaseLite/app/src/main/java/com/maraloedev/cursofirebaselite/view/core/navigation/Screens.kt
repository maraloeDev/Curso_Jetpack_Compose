package com.maraloedev.cursofirebaselite.view.core.navigation

import kotlinx.serialization.Serializable

// Objeto que representa la pantalla principal (Home) en la navegación.
@Serializable
object Home

// Objeto que representa la pantalla de registro de usuario.
@Serializable
object Register

// Objeto que representa la pantalla para crear una nueva cuenta con correo.
@Serializable
object CreateNewAccountScreen

// Objeto que representa la pantalla de ingreso por correo electrónico.
@Serializable
object MailScreen

// Objeto que representa la pantalla de inicio de sesión.
@Serializable
object Login

// Objeto que representa la pantalla de login sin contraseña.
@Serializable
object LoginWithoutPassword

// Objeto que representa la pantalla inicial tras un login exitoso.
@Serializable
object InitialHome