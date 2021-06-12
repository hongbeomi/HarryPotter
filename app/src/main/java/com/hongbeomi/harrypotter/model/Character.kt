package com.hongbeomi.harrypotter.model

/**
 * Copyright 2020 Hongbeom Ahn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val yearOfBirth: String,
    val ancestry: String,
    val patronus: String,
    val actor: String,
    val alive: Boolean,
    val image: String
) : Parcelable {

    fun getInfoText(): String {
        return "${::species.name} : $species\n" +
                "${::gender.name} : $gender\n" +
                "${::house.name} : $house\n" +
                "${::dateOfBirth.name} : $dateOfBirth\n" +
                "${::yearOfBirth.name} : $yearOfBirth\n" +
                "${::ancestry.name} : $ancestry\n" +
                "${::patronus.name} : ${if(patronus.isBlank()) "X" else patronus}\n" +
                "${::actor.name} : $actor\n" +
                "${::alive.name} : $alive"
    }

}