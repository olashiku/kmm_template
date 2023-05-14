package com.olashiku.kmmtemplate.repository.auth_repository

import com.olashiku.kmmtemplate.model.request.login.LoginRequest
import com.olashiku.kmmtemplate.model.response.login.LoginResponse
import com.olashiku.kmmtemplate.network.BaseNetworkRepository
import com.olashiku.kmmtemplate.network.EndPoints
import com.olashiku.kmmtemplate.network.NetworkResult

class AuthRepositoryImplementation:BaseNetworkRepository(),AuthenticationRepository {
    override suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> {
      return  makeNetworkCallAndRetrieveData(loginRequest,EndPoints.LOGIN,{it.responsecode.equals("00")},::getLogin )
    }

     fun getLogin(request: LoginRequest,response: LoginResponse){

     }
}