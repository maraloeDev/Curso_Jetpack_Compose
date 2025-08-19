package com.maraloedev.twitter.view.auth.forgotPassword

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ForgotPasswordViewModel : ViewModel() {
    private val _uistate = MutableStateFlow(ForgotPassword())
    val state: StateFlow<ForgotPassword> = _uistate

    //Comprueba si el valor que hay en el OTF es un telefono, correo electronico, o nombre de usuario
    fun isValid(value: String) {
        _uistate.update {
            it.copy(value = value)
        }
        confirmation(value)
    }


    fun confirmation(value: String) {

        val enable =
            Patterns.EMAIL_ADDRESS.matcher(value)
                .matches() || value.length == 9 || value.startsWith(prefix = "@")
        _uistate.update {
            it.copy(isEnabled = enable)
        }
    }
}

//En esta data class, se necesitan los valores que hay en la pantalla de Login
data class ForgotPassword(
    val value: String = "",
    val isEnabled: Boolean = false
)