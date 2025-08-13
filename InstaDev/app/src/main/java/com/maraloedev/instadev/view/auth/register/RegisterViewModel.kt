package com.maraloedev.instadev.view.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    //Cambiar el modo cuando se de click a "Registrarse con"
    fun isChangeMode() {
        _uiState.update {
            it.copy(isPhoneMode = !it.isPhoneMode)
        }
    }

    // Actualizo el estado creando un valor, comprobando si el modo telefono esta activado,
    // asi, compruebo si la longitud de caracteres del valor es 9, si no es asi, se comprueba
    // si el correo esta bien con Patterns (Opcion del sistema que comprueba si contiene un @)
    fun isPhoneChange(value: String) {
        _uiState.update {
            val isEnable = if (it.isPhoneMode) {
                it.value.length >= 9
            } else {
                Patterns.EMAIL_ADDRESS.matcher(value).matches()
            }
            it.copy(isPhoneMode = isEnable, value = "")
        }
    }
}

data class RegisterUiState(
    val value: String = "", //Valor a cambiar (Movil/Correo electronico)
    val isPhoneMode: Boolean = true, //Cambia entre true o false
    val isEnabled: Boolean = false //Boton siguiente habilitado dependiendo del TextField
)