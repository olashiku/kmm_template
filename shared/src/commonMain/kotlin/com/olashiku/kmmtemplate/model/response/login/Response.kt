package com.olashiku.kmmtemplate.model.response.login

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val code: String,
    val message: String
)