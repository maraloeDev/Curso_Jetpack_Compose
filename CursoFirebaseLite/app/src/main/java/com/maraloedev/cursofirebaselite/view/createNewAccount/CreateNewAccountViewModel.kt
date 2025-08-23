package com.maraloedev.cursofirebaselite.view.createNewAccount

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel encargado de manejar el estado de la pantalla de registro.
 * Gestiona el correo electrónico y la habilitación del botón de continuar.
 */
class CreateNewAccountViewModel : ViewModel() {

    // Estado interno mutable de la UI
    private val _uiState = MutableStateFlow(value = CreateNewAccountUi())

    // Estado expuesto de solo lectura para la UI
    val state: StateFlow<CreateNewAccountUi> = _uiState

    /**
     * Actualiza el correo electrónico en el estado y verifica si el botón debe habilitarse.
     * @param mail Nuevo valor del correo electrónico ingresado por el usuario.
     */
    fun changeMail(mail: String) {
        _uiState.update {
            it.copy(mail = mail)
        }
        verifyChanges()
    }

    fun changePassword(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        verifyChanges()
    }

    /**
     * Verifica si el correo es válido y actualiza el estado de habilitación del botón.
     */
    fun verifyChanges() {
        val isEnable = isMailCorrect() && isPasswordCorrect()
        _uiState.update {
            it.copy(enable = isEnable)
        }
    }

    /**
     * Valida el formato del correo electrónico usando patrones estándar de Android.
     * @return true si el correo es válido, false en caso contrario.
     */
    fun isMailCorrect(): Boolean = Patterns.EMAIL_ADDRESS.matcher(state.value.mail).matches()
    fun isPasswordCorrect(): Boolean = state.value.password.length>=9
}

/**
 * Estado de la UI para la creación de una nueva cuenta.
 * @param mail Correo electrónico ingresado.
 * @param enable Indica si el botón de continuar debe estar habilitado.
 */
data class CreateNewAccountUi(
    val mail: String = "",
    val password: String = "",
    val enable: Boolean = false
)