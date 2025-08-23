package com.maraloedev.cursofirebaselite.view.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel encargado de manejar el estado de la pantalla de login con correo y contraseña.
 * Gestiona los datos ingresados y la habilitación del botón de inicio de sesión.
 */
class MailViewModel : ViewModel() {
    // Estado interno mutable de la UI
    private val _uiState = MutableStateFlow(value = MailUi())

    // Estado expuesto de solo lectura para la UI
    val state: StateFlow<MailUi> = _uiState

    /**
     * Actualiza el correo electrónico en el estado y verifica si el botón debe habilitarse.
     * @param mail Nuevo valor del correo electrónico ingresado por el usuario.
     */
    fun isMailChanged(mail: String) {
        _uiState.update {
            it.copy(mail = mail)
        }
        verifyChanges()
    }

    /**
     * Actualiza la contraseña en el estado y verifica si el botón debe habilitarse.
     * @param password Nueva contraseña ingresada por el usuario.
     */
    fun isPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        verifyChanges()
    }

    /**
     * Verifica si el correo y la contraseña son válidos y actualiza el estado de habilitación del botón.
     */
    fun verifyChanges() {
        val enabled = isMailValid() && isPasswordValid()
        _uiState.update {
            it.copy(isEnabled = enabled)
        }
    }

    /**
     * Valida el formato del correo electrónico usando patrones estándar de Android.
     * @return true si el correo es válido, false en caso contrario.
     */
    fun isMailValid(): Boolean = Patterns.EMAIL_ADDRESS.matcher(state.value.mail).matches()

    /**
     * Valida que la contraseña tenga al menos 9 caracteres.
     * @return true si la contraseña es válida, false en caso contrario.
     */
    fun isPasswordValid(): Boolean = state.value.password.length >= 9
}

/**
 * Estado de la UI para el login con correo y contraseña.
 * @param mail Correo electrónico ingresado.
 * @param password Contraseña ingresada.
 * @param isEnabled Indica si el botón de inicio de sesión debe estar habilitado.
 */
data class MailUi(
    val mail: String = "",
    val password: String = "",
    val isEnabled: Boolean = false
)