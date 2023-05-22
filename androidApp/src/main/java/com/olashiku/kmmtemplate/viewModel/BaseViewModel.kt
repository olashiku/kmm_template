package com.olashiku.kmmtemplate.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.olashiku.kmmtemplate.model.response.login.LoginResponse
import com.olashiku.kmmtemplate.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


open class BaseViewModel : ViewModel() {

     var isLoading  = MutableLiveData<Boolean>()

    fun <R : Any, T : Any> makePostRequest(
        request: R,
        apiCall: suspend (request: R) -> NetworkResult<T>,
        getError: (response: T) -> Unit, response:(T)->Unit, getException:(String)->Unit
    ) {
        runBlocking {
            val result = withContext(Dispatchers.IO) {
                isLoading.postValue(true)
                apiCall(request)
            }
            isLoading.postValue(false)
            when (result) {
                is NetworkResult.Success<*> -> {
                    response(result.data as T)
                }
                is NetworkResult.Errror -> {
                    getException(result.exception.message.toString())
                }
                is NetworkResult.Failed<*> -> {
                    getError(result.message as T)
                }
                else -> {}
            }
        }
    }


    fun <T : Any> makeGetRequest(
        apiCall: suspend () -> NetworkResult<T>,
        getError: (response: T) -> Unit,
        response:(T)->Unit,
        getException:(String)->Unit
    ) {
        runBlocking {
            val result = withContext(Dispatchers.IO) {
                isLoading.postValue(true)
                apiCall()
            }
            isLoading.postValue(false)
            when (result) {
                is NetworkResult.Success<*> -> {
                    response(result.data as T)
                }
                is NetworkResult.Errror -> {
                    getException(result.exception.message.toString())
                }
                is NetworkResult.Failed<*> -> {
                    getError(result.message as T)
                }
                else -> {}
            }
        }
    }


}