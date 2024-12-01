package com.example.threadsapp.feature.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier
){
    val viewModel: RegisterScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    RegisterScreenView(
        state = state,
        onEvent = viewModel::onEvent
    )

}
@Composable
fun RegisterScreenView(
    modifier: Modifier = Modifier,
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent) -> Unit = {}
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(com.example.threadsapp.R.string.welcome),
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(top = 125.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    text = stringResource(com.example.threadsapp.R.string.sign_up),
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(top = 50.dp)
                )
            }
            Text(
                text = state.errorMessage?:"No message",
                modifier = Modifier.padding(top = 20.dp)
            )
            //Username Textfield
            // Password TextField
            TextField(
                value = state.usernameState,
                onValueChange = {
                    onEvent(RegisterScreenEvent.UsernameChanged(newUsername = it))
                },
                placeholder = {
                    Text(text = stringResource(com.example.threadsapp.R.string.username))
                },
                shape = RoundedCornerShape(size = 15.dp),
                colors = TextFieldDefaults.colors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 30.dp)
            )
            // Email TextField
            TextField(
                value = state.emailState,
                onValueChange = {
                    onEvent(RegisterScreenEvent.EmailChanged(newEmail = it))
                },
                placeholder = {
                    Text(text = stringResource(com.example.threadsapp.R.string.email))
                },
                shape = RoundedCornerShape(size = 15.dp),
                colors = TextFieldDefaults.colors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 10.dp)
            )
            // Password TextField
            TextField(
                value = state.passwordState,
                onValueChange = {
                    onEvent(RegisterScreenEvent.PasswordChanged(newPassword = it))
                },
                placeholder = {
                    Text(text = stringResource(com.example.threadsapp.R.string.password))
                },
                shape = RoundedCornerShape(size = 15.dp),
                colors = TextFieldDefaults.colors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 10.dp),
                visualTransformation = PasswordVisualTransformation()
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreenView()
}