package com.olashiku.kmmtemplate.di

import androidx.lifecycle.SavedStateHandle
import com.olashiku.kmmtemplate.viewModel.AuthenticationViewModel
import com.olashiku.kmmtemplate.viewModel.BaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

 val viewModelModule = module {
     viewModel { AuthenticationViewModel( get(),it.get()) }
 }