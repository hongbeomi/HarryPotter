package com.hongbeomi.harrypotter.di

import com.hongbeomi.harrypotter.data.repository.Repository
import com.hongbeomi.harrypotter.data.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> { RepositoryImpl(remoteDataSource = get()) }
}