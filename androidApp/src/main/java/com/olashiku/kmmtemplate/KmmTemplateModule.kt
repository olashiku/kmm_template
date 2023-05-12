package com.olashiku.kmmtemplate

import android.app.Application
import com.olashiku.kmmtemplate.di.appModule
import org.koin.core.context.startKoin

class KmmTemplateModule :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoinModule()
    }

      fun startKoinModule(){

          startKoin {
              modules(appModule())
          }

     }
}