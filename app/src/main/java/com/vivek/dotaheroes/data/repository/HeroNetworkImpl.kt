package com.vivek.dotaheroes.data.repository

import com.vivek.dotaheroes.data.remote.DotaHeroesApi
import com.vivek.dotaheroes.data.remote.mapper.toHero
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.repository.HeroNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroNetworkImpl @Inject constructor(
    private val api: DotaHeroesApi
) : HeroNetwork {

    override suspend fun getHeroes(): List<Hero> = withContext(Dispatchers.IO) {
        // TODO: withContext(Dispatchers.IO) { }
        // TODO: provide Dispatchers using Dependency Injection
        api.getHeroes().map { it.toHero() }
    }
}




















