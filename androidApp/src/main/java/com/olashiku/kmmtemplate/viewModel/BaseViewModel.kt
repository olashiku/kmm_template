package com.olashiku.kmmtemplate.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olashiku.kmmtemplate.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


open class BaseViewModel : ViewModel() {


    fun <R : Any, T : Any> makePostRequest(
        request: R,
        apiCall: suspend (request: R) -> NetworkResult<T>,
        getError: (response: T) -> Unit, response:(T)->Unit, getException:(String)->Unit,
        isLoading: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                isLoading(true)
                apiCall(request)
            }
            isLoading(false)
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
        getException:(String)->Unit,
        isLoading: (Boolean) -> Unit

    ) {
        runBlocking {
            val result = withContext(Dispatchers.IO) {
                isLoading(true)
                apiCall()
            }
            isLoading(false)
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