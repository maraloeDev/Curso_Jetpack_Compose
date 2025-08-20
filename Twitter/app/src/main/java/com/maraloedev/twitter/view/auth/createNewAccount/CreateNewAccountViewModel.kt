package com.maraloedev.twitter.view.auth.createNewAccount

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CreateNewAccountViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(value = NewAccountUi())
    val state: StateFlow<NewAccountUi> = _uiState

    fun isNameChange(name: String) {
        _uiState.update {
            it.copy(name = name)
        }
        verifyValue()
    }

    fun isValueChange(value: String) {
        _uiState.update {
            it.copy(value = value)
        }
        verifyValue()
    }

    /*
    Creo una variable comprobando si el boton esta habilitado, si es asi, llamas a la fun del mail,
    si no al del Mobile
     */
    fun verifyValue() {
        val isEnabledButton = if (state.value.isMailButtonEnabled) {
            isMailValid()
        } else {
            isMobileValid()
        }

        _uiState.update {
            it.copy(isMailButtonEnabled = isEnabledButton)
        }
    }

    /* Combruebo si esta habilitado el boton del mail,
     y si es asi, compruebo si el telefono tiene 9 digitos,
     y si el mail, contiene un @*/
    fun isMobileValid(): Boolean = state.value.value.length == 9
    fun isMailValid(): Boolean = Patterns.EMAIL_ADDRESS.matcher(state.value.value).matches()
}

data class NewAccountUi(
    val name: String = "", //valor del nombre
    val value: String = "", //valor del nombre
    val isEnabled: Boolean = false, //Boton siguiente habilitado
    val isMailButtonEnabled: Boolean = false //Boton mail habilitado

)