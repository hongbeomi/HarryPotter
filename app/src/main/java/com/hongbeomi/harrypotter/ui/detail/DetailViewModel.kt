package com.hongbeomi.harrypotter.ui.detail

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

import androidx.lifecycle.*
import com.hongbeomi.harrypotter.data.repository.Repository
import com.hongbeomi.harrypotter.model.Character
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.detail.DetailActivity.Companion.KEY_HOUSE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val houseName = savedStateHandle.get<HouseType>(KEY_HOUSE)?.name

    val characterList : LiveData<List<Character>> = liveData(Dispatchers.IO) {
        isLoading.postValue(true)
        houseName?.let {
            emit(repository.getCharacters(it))
        }
        isLoading.postValue(false)
    }

    val isLoading = MutableLiveData<Boolean>()

}