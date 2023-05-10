package com.olashiku.kmmtemplate.repository.auth_repository

import com.olashiku.kmmtemplate.model.request.login.LoginRequest
import com.olashiku.kmmtemplate.model.response.login.LoginResponse
import com.olashiku.kmmtemplate.network.NetworkResult

interface AuthenticationRepository {
    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse>
}