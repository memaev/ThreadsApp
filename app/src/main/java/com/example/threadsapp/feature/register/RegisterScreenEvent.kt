package com.example.threadsapp.feature.register

import com.example.threadsapp.feature.login.LoginScreenEvent

sealed interface RegisterScreenEvent {
    data class UsernameChanged(val newUsername: String): RegisterScreenEvent
    data class EmailChanged(val newEmail: String): RegisterScreenEvent
    data class PasswordChanged(val newPassword: String): RegisterScreenEvent
    data object RegisterBtnClicked: LoginScreenEvent
}