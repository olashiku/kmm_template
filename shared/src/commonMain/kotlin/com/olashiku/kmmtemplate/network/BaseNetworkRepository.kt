package com.olashiku.kmmtemplate.network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


open class BaseNetworkRepository: KoinComponent {

     val networkProvider : NetworkConfiguration by inject()

    suspend inline fun <reified R:Any, reified T:Any> makeNetworkCallAndRetrieveData(request:R, endpoint:String, checkIfSuccessful:(T)->Boolean, data:(R, T)->Unit): NetworkResult<T>{
     return  try {
           val response: HttpResponse = networkProvider.client.post {
               url {
                   protocol = URLProtocol.HTTPS
                   host = EndPoints.HOST
                   path(endpoint)
               }
               contentType(ContentType.Application.Json)
               setBody(request)
           }
            val resp = response.body<T>()
           if(checkIfSuccessful(resp)){
               data(request,resp)
               NetworkResult.Success(resp)
           }else {
               NetworkResult.Failed(resp)
           }
       }catch (ex:Exception){
         NetworkResult.Errror(ex)
       }
     }

    suspend inline fun <reified R:Any, reified T:Any> makeNetworkCall(request:R, endpoint:String, checkIfSuccessful:(T)->Boolean): NetworkResult<T>{
        return  try {
            val response: HttpResponse = networkProvider.client.post {
                url {
                    protocol = URLProtocol.HTTPS
                    host = EndPoints.HOST
                    path(endpoint)
                }
                contentType(ContentType.Application.Json)
                setBody(request)
            }
            val resp = response.body<T>()
            if(checkIfSuccessful(resp)){
                NetworkResult.Success(resp)
            }else {
                NetworkResult.Failed(resp)
            }
        }catch (ex:Exception){
            NetworkResult.Errror(ex)
        }
    }

    suspend inline fun < reified T:Any> runGetRequest( endpoint:String, checkIfSuccessful:(T)->Boolean): NetworkResult<T>{
        return  try {
            val response: HttpResponse = networkProvider.client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = EndPoints.HOST
                    path(endpoint)
                }
                contentType(ContentType.Application.Json)
            }

            val resp = response.body<T>()
            if(checkIfSuccessful(resp)){
                NetworkResult.Success(resp)
            }else {
                NetworkResult.Failed(resp)
            }
        }catch (ex:Exception){
            NetworkResult.Errror(ex)
        }
    }

    suspend inline fun < reified T:Any> runGetRequestWithData( endpoint:String, checkIfSuccessful:(T)->Boolean,data:(T)->Unit): NetworkResult<T>{
        return  try {
            val response: HttpResponse = networkProvider.client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = EndPoints.HOST
                    path(endpoint)
                }
                contentType(ContentType.Application.Json)
            }

            val resp = response.body<T>()
            if(checkIfSuccessful(resp)){
                data(resp)
                NetworkResult.Success(resp)
            }else {
                NetworkResult.Failed(resp)
            }
        }catch (ex:Exception){
            NetworkResult.Errror(ex)
        }
    }
}