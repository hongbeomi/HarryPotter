package com.hongbeomi.harrypotter.data.repository

import com.hongbeomi.harrypotter.model.Character

interface Repository {

    suspend fun getCharacters(type: String) : List<Character>

}