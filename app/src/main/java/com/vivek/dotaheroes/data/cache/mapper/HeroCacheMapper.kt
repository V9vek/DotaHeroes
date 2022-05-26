package com.vivek.dotaheroes.data.cache.mapper

import com.vivek.dotaheroes.data.cache.model.HeroEntity
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.model.HeroRole
import com.vivek.dotaheroes.domain.model.getHeroAttackType
import com.vivek.dotaheroes.domain.model.getHeroAttribute

fun Hero.toHeroEntity(): HeroEntity {
    return HeroEntity(
        id = id.toLong(),
        localizedName = localizedName,
        primaryAttribute = primaryAttribute.abbreviation,
        attackType = attackType.uiValue,
        roleCarry = if (roles.contains(HeroRole.Carry)) 1L else 0L,
        roleEscape = if (roles.contains(HeroRole.Escape)) 1L else 0L,
        roleNuker = if (roles.contains(HeroRole.Nuker)) 1L else 0L,
        roleInitiator = if (roles.contains(HeroRole.Initiator)) 1L else 0L,
        roleDurable = if (roles.contains(HeroRole.Durable)) 1L else 0L,
        roleDisabler = if (roles.contains(HeroRole.Disabler)) 1L else 0L,
        roleJungler = if (roles.contains(HeroRole.Jungler)) 1L else 0L,
        roleSupport = if (roles.contains(HeroRole.Support)) 1L else 0L,
        rolePusher = if (roles.contains(HeroRole.Pusher)) 1L else 0L,
        img = img,
        icon = icon,
        baseHealth = baseHealth.toDouble(),
        baseHealthRegen = baseHealthRegen?.toDouble(),
        baseMana = baseMana.toDouble(),
        baseManaRegen = baseManaRegen?.toDouble(),
        baseArmor = baseArmor.toDouble(),
        baseMoveRate = baseMoveRate.toDouble(),
        baseAttackMin = baseAttackMin.toDouble(),
        baseAttackMax = baseAttackMax.toDouble(),
        baseStr = baseStr.toLong(),
        baseAgi = baseAgi.toLong(),
        baseInt = baseInt.toLong(),
        strGain = strGain.toDouble(),
        agiGain = agiGain.toDouble(),
        intGain = intGain.toDouble(),
        attackRange = attackRange.toLong(),
        projectileSpeed = projectileSpeed.toLong(),
        attackRate = attackRate.toDouble(),
        moveSpeed = moveSpeed.toLong(),
        turnRate = turnRate?.toDouble(),
        legs = legs.toLong(),
        turboPicks = turboPicks.toLong(),
        turboWins = turboWins.toLong(),
        proWins = proWins.toLong(),
        proPick = proPick.toLong(),
        firstPick = firstPick.toLong(),
        firstWin = firstWin.toLong(),
        secondPick = secondPick.toLong(),
        secondWin = secondWin.toLong(),
        thirdPick = thirdPick.toLong(),
        thirdWin = thirdWin.toLong(),
        fourthPick = fourthPick.toLong(),
        fourthWin = fourthWin.toLong(),
        fifthPick = fifthPick.toLong(),
        fifthWin = fifthWin.toLong(),
        sixthPick = sixthPick.toLong(),
        sixthWin = sixthWin.toLong(),
        seventhPick = seventhPick.toLong(),
        seventhWin = seventhWin.toLong(),
        eighthWin = eighthWin.toLong(),
        eighthPick = eighthPick.toLong()
    )
}

fun HeroEntity.toHero(): Hero {
    return Hero(
        id = id.toInt(),
        localizedName = localizedName,
        primaryAttribute = getHeroAttribute(abbreviation = primaryAttribute),
        attackType = getHeroAttackType(uiValue = attackType),
        roles = rolesToList(
            carry = roleCarry?.toInt() == 1,
            escape = roleEscape?.toInt() == 1,
            nuker = roleNuker?.toInt() == 1,
            initiator = roleInitiator?.toInt() == 1,
            durable = roleDurable?.toInt() == 1,
            disabler = roleDisabler?.toInt() == 1,
            jungler = roleJungler?.toInt() == 1,
            support = roleSupport?.toInt() == 1,
            pusher = rolePusher?.toInt() == 1
        ),
        img = img,
        icon = icon,
        baseHealth = baseHealth.toFloat(),
        baseHealthRegen = baseHealthRegen?.toFloat(),
        baseMana = baseMana.toFloat(),
        baseManaRegen = baseManaRegen?.toFloat(),
        baseArmor = baseArmor.toFloat(),
        baseMoveRate = baseMoveRate.toFloat(),
        baseAttackMin = baseAttackMin.toInt(),
        baseAttackMax = baseAttackMax.toInt(),
        baseStr = baseStr.toInt(),
        baseAgi = baseAgi.toInt(),
        baseInt = baseInt.toInt(),
        strGain = strGain.toFloat(),
        agiGain = agiGain.toFloat(),
        intGain = intGain.toFloat(),
        attackRange = attackRange.toInt(),
        projectileSpeed = projectileSpeed.toInt(),
        attackRate = attackRate.toFloat(),
        moveSpeed = moveSpeed.toInt(),
        turnRate = turnRate?.toFloat(),
        legs = legs.toInt(),
        turboPicks = turboPicks.toInt(),
        turboWins = turboWins.toInt(),
        proWins = proWins.toInt(),
        proPick = proPick.toInt(),
        firstPick = firstPick.toInt(),
        firstWin = firstWin.toInt(),
        secondPick = secondPick.toInt(),
        secondWin = secondWin.toInt(),
        thirdPick = thirdPick.toInt(),
        thirdWin = thirdWin.toInt(),
        fourthPick = fourthPick.toInt(),
        fourthWin = fourthWin.toInt(),
        fifthPick = fifthPick.toInt(),
        fifthWin = fifthWin.toInt(),
        sixthPick = sixthPick.toInt(),
        sixthWin = sixthWin.toInt(),
        seventhPick = seventhPick.toInt(),
        seventhWin = seventhWin.toInt(),
        eighthWin = eighthWin.toInt(),
        eighthPick = eighthPick.toInt()
    )
}

fun rolesToList(
    carry: Boolean,
    escape: Boolean,
    nuker: Boolean,
    initiator: Boolean,
    durable: Boolean,
    disabler: Boolean,
    jungler: Boolean,
    support: Boolean,
    pusher: Boolean,
): List<HeroRole> {
    val roles = mutableListOf<HeroRole>()
    if (carry) roles.add(HeroRole.Carry)
    if (escape) roles.add(HeroRole.Escape)
    if (nuker) roles.add(HeroRole.Nuker)
    if (initiator) roles.add(HeroRole.Initiator)
    if (durable) roles.add(HeroRole.Durable)
    if (disabler) roles.add(HeroRole.Disabler)
    if (jungler) roles.add(HeroRole.Jungler)
    if (support) roles.add(HeroRole.Support)
    if (pusher) roles.add(HeroRole.Pusher)
    return roles.toList()
}