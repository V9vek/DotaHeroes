package com.vivek.dotaheroes.domain.repository

import com.vivek.dotaheroes.domain.model.Hero

interface HeroNetwork {

    suspend fun getHeroes(): List<Hero>
}