package com.olashiku.kmmtemplate.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olashiku.kmmtemplate.model.request.login.LoginRequest
import com.olashiku.kmmtemplate.repository.auth_repository.AuthRepositoryImplementation
import kotlinx.coroutines.launch

class AuthenticationViewModel: ViewModel() {

    val authenticationRepository = AuthRepositoryImplementation()

    fun loginUser(){
         viewModelScope.launch {
             val request = LoginRequest(
                 "Android SDK built for x86",
                 "Android",
                 "1.0",
                 "8755326412e91de0",
                 "69474fb5-dd3e-48e7-82a3-1a570a9bb3ac",
                 "12345678",
                 "Android",
                 "2347066353204")

             val response = authenticationRepository.login(request)
             println("myResponse $response")
         }
    }
}