package com.maraloedev.cursofirebaselite.view.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(value = MailUi())
    val state: StateFlow<MailUi> = _uiState

    fun isMailChanged(mail: String) {
        _uiState.update {
            it.copy(mail = mail)
        }
        verifyChanges()
    }

    fun isPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        verifyChanges()
    }

    fun verifyChanges() {
        val enabled = isMailValid() && isPasswordValid()

        _uiState.update {
            it.copy(isEnabled = enabled)
        }
    }

    fun isMailValid(): Boolean = Patterns.EMAIL_ADDRESS.matcher(state.value.mail).matches()
    fun isPasswordValid(): Boolean = state.value.password.length >= 9
}

data class MailUi(
    val mail: String = "",
    val password: String = "",
    val isEnabled: Boolean = false
)