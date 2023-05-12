package com.olashiku.kmmtemplate.network

import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json



class NetworkConfiguration {
    val client=httpClient {
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(ContentNegotiation){
            json(Json{
                prettyPrint = true
                isLenient = true
            })
        }

        defaultRequest {
            header("Content-Type", "application/json")
            header("Authorization","Bearer 6746754575546")
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 300000L
            connectTimeoutMillis = 300000L
            socketTimeoutMillis = 300000L

        }
    }

    val socketClient = httpClient {
        install(WebSockets)
        install(Logging) {
            level = LogLevel.ALL
        }
    }
}