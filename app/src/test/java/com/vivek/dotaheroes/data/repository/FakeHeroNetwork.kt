package com.vivek.dotaheroes.data.repository

import com.vivek.dotaheroes.data.remote.DotaHeroesApi
import com.vivek.dotaheroes.data.remote.mapper.toHero
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.repository.HeroNetwork

class FakeHeroNetwork(
    private val api: DotaHeroesApi
) : HeroNetwork {

    override suspend fun getHeroes(): List<Hero> {
        return api.getHeroes().map { it.toHero() }
    }
}