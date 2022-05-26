package com.vivek.dotaheroes.presentation.hero_list

import com.vivek.dotaheroes.domain.model.Hero

data class HeroListState(
    val heroes: List<Hero> = emptyList(),
    val isLoading: Boolean = false,
)

























