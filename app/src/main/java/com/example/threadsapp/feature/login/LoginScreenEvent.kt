package com.example.threadsapp.feature.login

sealed interface LoginScreenEvent {
    data class EmailChanged(val newEmail: String): LoginScreenEvent
    data class PasswordChanged(val newPassword: String): LoginScreenEvent
    data object LoginButtonClicked: LoginScreenEvent
}