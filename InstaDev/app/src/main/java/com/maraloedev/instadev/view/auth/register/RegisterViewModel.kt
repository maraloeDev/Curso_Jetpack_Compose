package com.maraloedev.instadev.view.auth.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    //Comprobar si el numero de telefono esta bien
    fun isPhoneChange(mobilePhone: String) {
        _uiState.update {
            it.copy(mobilePhone = mobilePhone)
        }
        verifyPhone()
    }

    //Comprobar si el numero de telefono tiene 9 digitos
    fun isPhoneValid(): Boolean = uiState.value.mobilePhone.length == 9

    //Habilitar el boton Siguiente, si el telefono movil esta bien
    fun verifyPhone() {
        val isEnableButton = isPhoneValid()

        _uiState.update {
            it.copy(isEnabled = isEnableButton)
        }
    }
}

data class RegisterUiState(
    val mobilePhone: String = "",
    val isEnabled: Boolean = false
)