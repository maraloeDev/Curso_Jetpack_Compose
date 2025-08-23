package com.maraloedev.cursofirebaselite.view.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginWithoutPasswordViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(value = LoginWithoutPasswordUi())
    val state: StateFlow<LoginWithoutPasswordUi> = _uiState

    fun isMailChange(mail: String) {
        _uiState.update {
            it.copy(mail = mail)
        }

        verifyLogin()
    }

    fun verifyLogin() {
        val enabled = mailValid()

        _uiState.update {
            it.copy(isEnabled = enabled)
        }
    }

    fun mailValid(): Boolean = Patterns.EMAIL_ADDRESS.matcher(state.value.mail).matches()
}

data class LoginWithoutPasswordUi(
    val mail: String = "",
    val isEnabled: Boolean = false
)