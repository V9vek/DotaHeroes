package com.vivek.dotaheroes.data.remote.mapper

import com.vivek.dotaheroes.data.remote.DotaHeroesApi
import com.vivek.dotaheroes.data.remote.model.HeroDto
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.model.getHeroAttackType
import com.vivek.dotaheroes.domain.model.getHeroAttribute
import com.vivek.dotaheroes.domain.model.getHeroRole

fun HeroDto.toHero(): Hero {
    return Hero(
        id = id,
        localizedName = localizedName,
        primaryAttribute = getHeroAttribute(abbreviation = primaryAttribute),
        attackType = getHeroAttackType(uiValue = attackType),
        roles = roles.map { getHeroRole(uiValue = it) },
        img = "${DotaHeroesApi.BASE_URL}$img",
        icon = "${DotaHeroesApi.BASE_URL}$icon",
        baseHealth = baseHealth,
        baseHealthRegen = baseHealthRegen,
        baseMana = baseMana,
        baseManaRegen = baseManaRegen,
        baseArmor = baseArmor,
        baseMoveRate = baseMoveRate,
        baseAttackMin = baseAttackMin,
        baseAttackMax = baseAttackMax,
        baseStr = baseStr,
        baseAgi = baseAgi,
        baseInt = baseInt,
        strGain = strGain,
        agiGain = agiGain,
        intGain = intGain,
        attackRange = attackRange,
        projectileSpeed = projectileSpeed,
        attackRate = attackRate,
        moveSpeed = moveSpeed,
        turnRate = turnRate,
        legs = legs,
        turboPicks = turboPicks,
        turboWins = turboWins,
        proWins = proWins ?: 0,
        proPick = proPick ?: 0,
        firstPick = firstPick,
        firstWin = firstWin,
        secondPick = secondPick,
        secondWin = secondWin,
        thirdPick = thirdPick,
        thirdWin = thirdWin,
        fourthPick = fourthPick,
        fourthWin = fourthWin,
        fifthPick = fifthPick,
        fifthWin = fifthWin,
        sixthPick = sixthPick,
        sixthWin = sixthWin,
        seventhPick = seventhPick,
        seventhWin = seventhWin,
        eighthWin = eighthWin,
        eighthPick = eighthPick
    )
}