package com.vivek.dotaheroes.domain.repository

import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.model.HeroAttackType
import com.vivek.dotaheroes.domain.model.HeroAttribute
import com.vivek.dotaheroes.domain.model.HeroRole

interface HeroCache {

    suspend fun insertHero(hero: Hero)

    suspend fun insertHeroes(heroes: List<Hero>)

    suspend fun deleteHeroById(id: Int)

    suspend fun deleteAllHeroes()

    suspend fun getHeroById(id: Int): Hero?

    suspend fun getAllHeores(): List<Hero>

    suspend fun searchHeroesByName(localizedName: String): List<Hero>

    suspend fun searchHeroesByAttribute(primaryAttribute: HeroAttribute): List<Hero>

    suspend fun searchHeroesByAttackType(attackType: HeroAttackType): List<Hero>

    suspend fun searchHeroesByRoles(roles: List<HeroRole>): List<Hero>
}


























