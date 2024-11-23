package com.example.threadsapp.feature.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.threadsapp.R


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: LoginScreenViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LoginScreenView(
        state = state,
        modifier = modifier,
        onEvent = { viewModel.onEvent(it)}
    )

}

@Composable
fun LoginScreenView(
    modifier: Modifier = Modifier,
    state: LoginScreenState = LoginScreenState(),
    onEvent: (LoginScreenEvent) -> Unit = {}
) {
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.welcome),
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
                    text = stringResource(R.string.sign_in_to_account),
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(top = 50.dp)
                )
            }
            Text(
                text = state.message?:"No message",
                modifier = Modifier.padding(top = 20.dp)
            )
            // Email TextField
            TextField(
                value = state.emailState,
                onValueChange = {
                    onEvent(LoginScreenEvent.EmailChanged(newEmail = it))
                },
                placeholder = {
                    Text(text = stringResource(R.string.email))
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
                    .padding(top = 30.dp)
            )
            // Password TextField
            TextField(
                value = state.passwordState,
                onValueChange = {
                    onEvent(LoginScreenEvent.PasswordChanged(newPassword = it))
                },
                placeholder = {
                    Text(text = stringResource(R.string.password))
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
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = if (state.isLoggedIn) "Successfully logged in!" else "Not logged in yet"
            )
            Button(
                onClick = {
                    Toast.makeText(context, "Button sign in clicked", Toast.LENGTH_SHORT).show()
                    onEvent(LoginScreenEvent.LoginButtonClicked)},
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 20.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    disabledContainerColor = Color.Blue
                )
            ) {
                Text(
                    text = stringResource(R.string.sign_in),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenView()
}