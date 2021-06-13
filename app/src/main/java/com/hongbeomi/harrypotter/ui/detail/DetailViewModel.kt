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
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val houseName = savedStateHandle.get<HouseType>(KEY_HOUSE)?.name

    private val _isLoadingFlow = MutableStateFlow(false)
    val isLoadingFlow: StateFlow<Boolean> = _isLoadingFlow.asStateFlow()

    private val _selectedCharacter = MutableSharedFlow<Character?>()
    val selectedCharacter: SharedFlow<Character?> = _selectedCharacter.asSharedFlow()

    val characterListFlow: StateFlow<List<Character>> = flow {
        houseName?.let {
            _isLoadingFlow.emit(true)
            emit(repository.getCharacters(it))
        }
        _isLoadingFlow.emit(false)
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun showCharacterDialogEvent(character: Character) = viewModelScope.launch {
        _selectedCharacter.emit(character)
    }

    fun hideCharacterDialogEvent() = viewModelScope.launch {
        _selectedCharacter.emit(null)
    }

}