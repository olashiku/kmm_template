package com.olashiku.kmmtemplate

import android.app.Application
import com.olashiku.kmmtemplate.di.appModule
import com.olashiku.kmmtemplate.module.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KmmTemplateModule :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoinModule()
    }

      fun startKoinModule(){
          startKoin {
              androidContext(this@KmmTemplateModule)
              modules(appModule() + androidModule)
          }

     }
}