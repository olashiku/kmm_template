package com.olashiku.kmmtemplate.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.olashiku.kmmtemplate.model.request.login.LoginRequest
import com.olashiku.kmmtemplate.model.response.login.LoginResponse
import com.olashiku.kmmtemplate.repository.auth_repository.AuthenticationRepository
import com.olashiku.kmmtemplate.utils.toJson
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class AuthenticationViewModel(
    private val authenticationRepository: AuthenticationRepository,
    private val saveStateHandle: SavedStateHandle
) : BaseViewModel() {
    private val loading = saveStateHandle.getStateFlow("isLoading", false)
    private val loginResponse = saveStateHandle.getStateFlow("loginResponse", LoginResponse().toJson())
    private val errorMessage = saveStateHandle.getStateFlow("errorMessage", "")

    val state =
        combine(loginResponse, errorMessage, loading) { loginResponse, errorMessage, loading ->
            LoginState(
                loginResponse = loginResponse,
                errorMessage = errorMessage,
                loadingState = loading
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LoginState())

    fun loginUser() {
        val request = LoginRequest(
            "Android SDK built for x86",
            "Android",
            "1.0",
            "8755326412e91de0",
            "69474fb5-dd3e-48e7-82a3-1a570a9bb3ac",
            "12345678",
            "Android",
            "2347066353204"
        )
        makePostRequest(request, authenticationRepository::login, {
            saveStateHandle["errorMessage"] = it.response?.message
        },
            { response ->
                saveStateHandle["loginResponse"] = response.toJson()
            }, { exception ->
                saveStateHandle["errorMessage"] = exception
            }
        ) { isLoading ->
            saveStateHandle["isLoading"] = isLoading
        }
    }
}