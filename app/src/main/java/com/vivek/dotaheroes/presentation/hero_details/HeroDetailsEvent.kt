package com.vivek.dotaheroes.presentation.hero_details

sealed class HeroDetailsEvent {

    data class ShowToast(val message: String) : HeroDetailsEvent()

    // TODO: add other events
}