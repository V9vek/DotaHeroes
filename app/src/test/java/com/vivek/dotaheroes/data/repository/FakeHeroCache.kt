package com.vivek.dotaheroes.data.repository

import com.vivek.dotaheroes.data.cache.FakeHeroDatabase
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.model.HeroAttackType
import com.vivek.dotaheroes.domain.model.HeroAttribute
import com.vivek.dotaheroes.domain.model.HeroRole
import com.vivek.dotaheroes.domain.repository.HeroCache

class FakeHeroCache(
    private val db: FakeHeroDatabase
) : HeroCache {

    override suspend fun insertHero(hero: Hero) {
        if (db.heroes.isNotEmpty()) {
            var inserted = false
            for (h in db.heroes) {
                if (h.id == hero.id) {
                    db.heroes.remove(h)
                    db.heroes.add(hero)
                    inserted = true
                    break
                }
            }

            if (inserted.not()) {
                db.heroes.add(hero)
            }
        } else {
            db.heroes.add(hero)
        }
    }

    override suspend fun insertHeroes(heroes: List<Hero>) {
        if (db.heroes.isNotEmpty()) {
            for (hero in heroes) {
                if (db.heroes.contains(hero)) {
                    db.heroes.remove(hero)
                    db.heroes.add(hero)
                }
            }
        } else {
            db.heroes.addAll(heroes)
        }
    }

    override suspend fun deleteHeroById(id: Int) {
        db.heroes.removeIf { it.id == id }
    }

    override suspend fun deleteAllHeroes() {
        db.heroes.clear()
    }

    override suspend fun getHeroById(id: Int): Hero? {
        return db.heroes.find { it.id == id }
    }

    override suspend fun getAllHeores(): List<Hero> {
        return db.heroes
    }

    override suspend fun searchHeroesByName(localizedName: String): List<Hero> {
        return db.heroes.filter { it.localizedName.contains(localizedName) }
    }

    override suspend fun searchHeroesByAttribute(primaryAttribute: HeroAttribute): List<Hero> {
        return db.heroes.filter { it.primaryAttribute == primaryAttribute }
    }

    override suspend fun searchHeroesByAttackType(attackType: HeroAttackType): List<Hero> {
        return db.heroes.filter { it.attackType == attackType }
    }

    override suspend fun searchHeroesByRoles(roles: List<HeroRole>): List<Hero> {
        return db.heroes    // Not yet fully implemented
    }
}

















