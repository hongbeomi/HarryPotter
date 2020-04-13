package com.hongbeomi.harrypotter.data.remote

import com.hongbeomi.harrypotter.model.Character

interface RemoteDataSource {

    suspend fun getCharacters(type: String) : List<Character>

}