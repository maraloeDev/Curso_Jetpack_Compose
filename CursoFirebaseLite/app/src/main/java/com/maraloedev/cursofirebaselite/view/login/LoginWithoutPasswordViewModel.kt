package com.maraloedev.cursofirebaselite.view.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel encargado de manejar el estado de la pantalla de login sin contraseña.
 * Gestiona el correo electrónico ingresado y la habilitación del botón para obtener el enlace.
 */
class LoginWithoutPasswordViewModel : ViewModel() {

    // Estado interno mutable de la UI
    private val _uiState = MutableStateFlow(value = LoginWithoutPasswordUi())

    // Estado expuesto de solo lectura para la UI
    val state: StateFlow<LoginWithoutPasswordUi> = _uiState

    /**
     * Actualiza el correo electrónico en el estado y verifica si el botón debe habilitarse.
     * @param mail Nuevo valor del correo electrónico ingresado por el usuario.
     */
    fun isMailChange(mail: String) {
        _uiState.update {
            it.copy(mail = mail)
        }
        verifyLogin()
    }

    /**
     * Verifica si el correo es válido y actualiza el estado de habilitación del botón.
     */
    fun verifyLogin() {
        val enabled = mailValid()
        _uiState.update {
            it.copy(isEnabled = enabled)
        }
    }

    /**
     * Valida el formato del correo electrónico usando patrones estándar de Android.
     * @return true si el correo es válido, false en caso contrario.
     */
    fun mailValid(): Boolean = Patterns.EMAIL_ADDRESS.matcher(state.value.mail).matches()
}

/**
 * Estado de la UI para el login sin contraseña.
 * @param mail Correo electrónico ingresado.
 * @param isEnabled Indica si el botón de obtener enlace debe estar habilitado.
 */
data class LoginWithoutPasswordUi(
    val mail: String = "",
    val isEnabled: Boolean = false
)