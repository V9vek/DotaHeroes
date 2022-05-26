package com.vivek.dotaheroes.presentation.hero_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.dotaheroes.domain.usecases.GetHeroes
import com.vivek.dotaheroes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val getHeroes: GetHeroes
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeroListState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<HeroListEvent>()
    val events = _events.asSharedFlow()

    init {
        getHeroes()
    }

    fun onTriggerEvent(event: HeroListEvent) = viewModelScope.launch {
        when (event) {
            is HeroListEvent.ShowToast -> {
                _events.emit(HeroListEvent.ShowToast(message = event.message))
            }
            is HeroListEvent.NavigateToHeroDetailsScreen -> {
                _events.emit(HeroListEvent.NavigateToHeroDetailsScreen(heroId = event.heroId))
            }
        }
    }

    private fun getHeroes() {
        viewModelScope.launch {
            getHeroes.execute()
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { heroes ->
                                _uiState.value = uiState.value.copy(heroes = heroes)
                            }
                        }
                        is Resource.Error -> {
                            onTriggerEvent(
                                event = HeroListEvent.ShowToast(
                                    message = result.message ?: "Unknown Error!"
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





























