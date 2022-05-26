package com.vivek.dotaheroes.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vivek.dotaheroes.data.cache.model.HeroEntity

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(heroEntity: HeroEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHeroes(heroesEntity: List<HeroEntity>)

    @Query("DELETE FROM heroentity WHERE id = :id")
    suspend fun deleteHeroById(id: Int)

    @Query("DELETE FROM heroentity")
    suspend fun deleteAllHeroes()

    @Query("SELECT * FROM heroentity where id = :id")
    suspend fun getHeroById(id: Int): HeroEntity?

    @Query("SELECT * FROM heroentity")
    suspend fun getAllHeores(): List<HeroEntity>

    @Query(
        """
        SELECT * FROM heroentity WHERE LOWER(localizedName) LIKE ('%' || LOWER(:localizedName) || '%')
    """
    )
    suspend fun searchHeroesByName(localizedName: String): List<HeroEntity>

    @Query(
        """
        SELECT * FROM heroentity WHERE LOWER(primaryAttribute) LIKE ('%' || LOWER(:primaryAttribute) || '%')
    """
    )
    suspend fun searchHeroesByAttribute(primaryAttribute: String): List<HeroEntity>

    @Query(
        """
        SELECT * FROM heroentity WHERE LOWER(attackType) LIKE ('%' || LOWER(:attackType) || '%')
    """
    )
    suspend fun searchHeroesByAttackType(attackType: String): List<HeroEntity>

    @Query(
        """
        SELECT * FROM heroentity
        WHERE roleCarry = :roleCarry
        AND roleEscape = :roleEscape
        AND roleNuker = :roleNuker
        AND roleInitiator = :roleInitiator
        AND roleDurable = :roleDurable
        AND roleDisabler = :roleDisabler
        AND roleJungler = :roleJungler
        AND roleSupport = :roleSupport
        AND rolePusher = :rolePusher
    """
    )
    suspend fun searchHeroesByRoles(
        roleCarry: Long,
        roleEscape: Long,
        roleNuker: Long,
        roleInitiator: Long,
        roleDurable: Long,
        roleDisabler: Long,
        roleJungler: Long,
        roleSupport: Long,
        rolePusher: Long
    ): List<HeroEntity>

}






























