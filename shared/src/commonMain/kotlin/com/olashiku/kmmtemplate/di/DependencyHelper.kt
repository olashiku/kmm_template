package com.olashiku.kmmtemplate.di

import org.koin.core.context.startKoin



fun initKoin(){
    startKoin {
        modules(appModule())
    }
}