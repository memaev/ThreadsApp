package com.example.threadsapp.feature.register

data class RegisterScreenState (
    val usernameState: String = "",
    val emailState: String = "",
    val passwordState: String = "",
    val errorMessage: String? = null
)