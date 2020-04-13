package com.hongbeomi.harrypotter.data.repository

import com.hongbeomi.harrypotter.data.remote.RemoteDataSource

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {

    override suspend fun getCharacters(type: String) =
        remoteDataSource.getCharacters(type)

}