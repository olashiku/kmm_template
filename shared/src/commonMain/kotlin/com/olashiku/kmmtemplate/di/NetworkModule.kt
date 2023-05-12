package com.olashiku.kmmtemplate.di

import com.olashiku.kmmtemplate.network.NetworkConfiguration
import org.koin.dsl.module

val networkModule = module {
 single { NetworkConfiguration() }
}