package com.hongbeomi.harrypotter.di

import com.hongbeomi.harrypotter.data.remote.RemoteDataSource
import com.hongbeomi.harrypotter.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(service = get()) }
}