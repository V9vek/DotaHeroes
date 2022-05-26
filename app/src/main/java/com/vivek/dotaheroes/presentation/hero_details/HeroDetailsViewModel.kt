package com.vivek.dotaheroes.presentation.hero_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.dotaheroes.domain.usecases.GetHeroFromCache
import com.vivek.dotaheroes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailsViewModel @Inject constructor(
    private val getHeroFromCache: GetHeroFromCache,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeroDetailsState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<HeroDetailsEvent>()
    val events = _events.asSharedFlow()

    init {
        savedStateHandle.get<Int>("heroId")?.let { heroId ->
            getHeroFromCache(id = heroId)
        }
    }

    fun onTriggerEvent(event: HeroDetailsEvent) = viewModelScope.launch {
        when (event) {
            is HeroDetailsEvent.ShowToast -> {
                _events.emit(HeroDetailsEvent.ShowToast(message = event.message))
            }
        }
    }

    private fun getHeroFromCache(id: Int) {
        viewModelScope.launch {
            getHeroFromCache.execute(id = id)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { hero ->
                                _uiState.value = uiState.value.copy(hero = hero)
                            }
                        }
                        is Resource.Error -> {
                            onTriggerEvent(
                                event = HeroDetailsEvent.ShowToast(
                                    message = result.message ?: "Unknown error"
                                )
                            )
                        }
                        is Resource.Loading -> {
                            _uiState.value = uiState.value.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}






























