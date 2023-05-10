package com.olashiku.kmmtemplate.network

import io.ktor.client.*


expect fun  httpClient(config: HttpClientConfig<*>.()-> Unit={}):HttpClient
