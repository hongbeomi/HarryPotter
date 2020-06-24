package com.hongbeomi.harrypotter.di

import com.hongbeomi.harrypotter.data.remote.RemoteDataSource
import com.hongbeomi.harrypotter.data.repository.Repository
import com.hongbeomi.harrypotter.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
        return RepositoryImpl(remoteDataSource)
    }

}