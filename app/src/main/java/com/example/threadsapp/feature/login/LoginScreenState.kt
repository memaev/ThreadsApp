package com.example.threadsapp.feature.login

data class LoginScreenState(
    val emailState:String = "",
    val passwordState:String = "",
    val isLoggedIn: Boolean = false,
    val message: String? = null
)
