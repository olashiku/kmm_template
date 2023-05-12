package com.olashiku.kmmtemplate.di

import com.olashiku.kmmtemplate.repository.auth_repository.AuthRepositoryImplementation
import com.olashiku.kmmtemplate.repository.auth_repository.AuthenticationRepository
import org.koin.dsl.module

val repositoryModule = module {
    single <AuthenticationRepository> { AuthRepositoryImplementation() }
}