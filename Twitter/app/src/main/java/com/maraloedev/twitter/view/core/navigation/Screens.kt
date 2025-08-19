package com.maraloedev.twitter.view.core.navigation

import kotlinx.serialization.Serializable

// Pantalla de inicio con el logo, y titulo en el medio
@Serializable
object Home

// Pantalla de login con el logo y titulo debajo, con ForgotPassword y button next
@Serializable
object Login

// Pantalla de FP con titulo en el medio, información y button next
@Serializable
object ForgotPassword