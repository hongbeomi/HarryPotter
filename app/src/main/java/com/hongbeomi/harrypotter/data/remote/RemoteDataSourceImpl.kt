package com.hongbeomi.harrypotter.data.remote

import com.hongbeomi.harrypotter.data.service.HarryPotterService

class RemoteDataSourceImpl(private val service: HarryPotterService) : RemoteDataSource {

    override suspend fun getCharacters(type: String) = service.getCharacters(type)

}