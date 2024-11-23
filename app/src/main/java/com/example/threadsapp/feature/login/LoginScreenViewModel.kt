package com.example.threadsapp.feature.login

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel: ViewModel(){
    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    private val auth = FirebaseAuth.getInstance()

    fun onEvent(event: LoginScreenEvent){
        when(event) {
            is LoginScreenEvent.EmailChanged -> onEmailChanged(event.newEmail)
            is LoginScreenEvent.PasswordChanged -> onPasswordChanged(event.newPassword)
            LoginScreenEvent.LoginButtonClicked -> onLoginButtonClicked()
        }
    }

    private fun onEmailChanged(newEmail: String) {
        _state.update { it.copy(emailState = newEmail) }
    }

    private fun onPasswordChanged(newPassword: String) {
        _state.update { it.copy(passwordState = newPassword) }

    }

    private fun onLoginButtonClicked() {
        val email = _state.value.emailState
        val password = _state.value.passwordState

        if (email.isBlank() || password.isBlank()) {
            _state.update { it.copy(message = "Fields cannot be empty") }
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _state.update { it.copy(message = "Successfully logged in") }
                } else {
                    _state.update { it.copy(message = "Got an error. Message: ${task.exception?.message}") }
                }
            }
    }
}