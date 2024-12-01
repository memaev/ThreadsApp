package com.example.threadsapp.feature.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(RegisterScreenState())
    val state = _state.asStateFlow()

    fun onEvent(event: RegisterScreenEvent) {
        when(event) {
            is RegisterScreenEvent.UsernameChanged -> onUsernameChanged(event.newUsername)
            is RegisterScreenEvent.EmailChanged -> onEmailChanged()
            is RegisterScreenEvent.PasswordChanged -> onPasswordChanged()
            RegisterScreenEvent.RegisterBtnClicked -> TODO()
        }
    }

    private fun onUsernameChanged(newUsername: String) {
        _state.update { it.copy(usernameState = newUsername) }
    }
    private fun onEmailChanged(newEmail: String) {
        _state.update { it.copy(emailState = newEmail) }
    }
    private fun onPasswordChanged(newPassword: String) {
        _state.update { it.copy(passwordState = newPassword) }
    }
    private fun onRegisterBtnClicked() {
        register(_state.value.emailState, _state.value.passwordState)
    }

    private fun register(email: String, password: String) {
        // TODO: register new user with email and password
    }
}