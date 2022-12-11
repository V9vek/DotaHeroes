package com.vivek.dotaheroes.data.repository

import com.vivek.dotaheroes.data.cache.HeroDatabase
import com.vivek.dotaheroes.data.cache.mapper.toHero
import com.vivek.dotaheroes.data.cache.mapper.toHeroEntity
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.model.HeroAttackType
import com.vivek.dotaheroes.domain.model.HeroAttribute
import com.vivek.dotaheroes.domain.model.HeroRole
import com.vivek.dotaheroes.domain.repository.HeroCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroCacheImpl @Inject constructor(
    private val db: HeroDatabase
) : HeroCache {

    private val dao = db.dao

    override suspend fun insertHero(hero: Hero) = withContext(Dispatchers.IO) {
        // TODO: withContext(Dispatchers.IO) { }
        // TODO: provide Dispatchers using Dependency Injection
        dao.insertHero(heroEntity = hero.toHeroEntity())
    }

    override suspend fun insertHeroes(heroes: List<Hero>) = withContext(Dispatchers.IO) {
        dao.insertHeroes(heroesEntity = heroes.map { it.toHeroEntity() })
    }

    override suspend fun deleteHeroById(id: Int) = withContext(Dispatchers.IO) {
        dao.deleteHeroById(id = id)
    }

    override suspend fun deleteAllHeroes() = withContext(Dispatchers.IO) {
        dao.deleteAllHeroes()
    }

    override suspend fun getHeroById(id: Int): Hero? = withContext(Dispatchers.IO) {
        dao.getHeroById(id = id)?.toHero()
    }

    override suspend fun getAllHeores(): List<Hero> = withContext(Dispatchers.IO) {
        dao.getAllHeores().map { it.toHero() }
    }

    override suspend fun searchHeroesByName(localizedName: String): List<Hero> {
        return dao.searchHeroesByName(localizedName = localizedName).map { it.toHero() }
    }

    override suspend fun searchHeroesByAttribute(primaryAttribute: HeroAttribute): List<Hero> {
        return dao.searchHeroesByAttribute(
            primaryAttribute = primaryAttribute.abbreviation
        ).map { it.toHero() }
    }

    override suspend fun searchHeroesByAttackType(attackType: HeroAttackType): List<Hero> {
        return dao.searchHeroesByAttackType(
            attackType = attackType.uiValue
        ).map { it.toHero() }
    }

    override suspend fun searchHeroesByRoles(roles: List<HeroRole>): List<Hero> {
        return dao.searchHeroesByRoles(
            roleCarry = if (roles.contains(HeroRole.Carry)) 1L else 0L,
            roleEscape = if (roles.contains(HeroRole.Escape)) 1L else 0L,
            roleNuker = if (roles.contains(HeroRole.Nuker)) 1L else 0L,
            roleInitiator = if (roles.contains(HeroRole.Initiator)) 1L else 0L,
            roleDurable = if (roles.contains(HeroRole.Durable)) 1L else 0L,
            roleDisabler = if (roles.contains(HeroRole.Disabler)) 1L else 0L,
            roleJungler = if (roles.contains(HeroRole.Jungler)) 1L else 0L,
            roleSupport = if (roles.contains(HeroRole.Support)) 1L else 0L,
            rolePusher = if (roles.contains(HeroRole.Pusher)) 1L else 0L,
        ).map { it.toHero() }
    }

}

























