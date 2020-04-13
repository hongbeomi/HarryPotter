package com.hongbeomi.harrypotter

import android.app.Application
import com.hongbeomi.harrypotter.di.dataSourceModule
import com.hongbeomi.harrypotter.di.networkModule
import com.hongbeomi.harrypotter.di.repositoryModule
import com.hongbeomi.harrypotter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HarryPotterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HarryPotterApp)
            modules(dataSourceModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(networkModule)
        }
    }

}