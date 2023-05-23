package com.olashiku.kmmtemplate.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.olashiku.kmmtemplate.model.response.login.LoginResponse
import com.olashiku.kmmtemplate.utils.fromJson
import com.olashiku.kmmtemplate.viewModel.AuthenticationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    val authViewModel: AuthenticationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel.loginUser()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App(authViewModel)
                }
            }
        }
    }

}

@Composable
fun App(authenticationViewModel: AuthenticationViewModel) {
    val state by authenticationViewModel.state.collectAsState()
    if(state.loginResponse.isNotEmpty()){
        val loginResponse = state.loginResponse.fromJson<LoginResponse>()
        GreetingView(loginResponse.responsemessage)
    }

     if(state.errorMessage.isNotEmpty()){
         val message = state.errorMessage
         GreetingView(message)
     }

}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}



@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
