package com.olashiku.kmmtemplate.model.request.login
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val devicename: String,
    val deviceplatform: String,
    val deviceversion: String,
    val mobiledeviceid: String,
    val mobilepushuserid: String,
    val password: String,
    val source: String,
    val username: String
)