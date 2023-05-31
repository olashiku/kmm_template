package com.olashiku.kmmtemplate.viewModel

data class LoginState (
    val loadingState : Boolean = false,
    val loginResponse: String = "",
    val errorMessage :String = ""
    )