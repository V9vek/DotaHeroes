package com.vivek.dotaheroes.util

import android.graphics.Color
import com.vivek.dotaheroes.R
import com.vivek.dotaheroes.domain.model.HeroAttackType
import com.vivek.dotaheroes.domain.model.HeroAttribute
import kotlin.math.round

fun calculateProWinRate(
    proWins: Int,
    proPick: Int
): String {
    val proWR = round(proWins.toDouble() / proPick.toDouble() * 100).toInt()
    return proWR.toString()
}

fun getProWinRateTextColor(proWinRate: String): Int {
    val proWR = proWinRate.toInt()
    var textColor = "#F61E50"
    if (proWR > 50) textColor = "#2ED470"
    return Color.parseColor(textColor)
}

fun getHeroAttributeImage(heroAttribute: HeroAttribute): Int {
    return when (heroAttribute) {
        HeroAttribute.Agility -> R.drawable.ic_agility
        HeroAttribute.Intelligence -> R.drawable.ic_intelligence
        HeroAttribute.Strength -> R.drawable.ic_strength
        HeroAttribute.Unknown -> R.drawable.ic_agility
    }
}

fun getHeroAttackImage(heroAttackType: HeroAttackType): Int {
    return when (heroAttackType) {
        HeroAttackType.Melee -> R.drawable.ic_melee
        HeroAttackType.Ranged -> R.drawable.ic_ranged
        HeroAttackType.Unknown -> R.drawable.ic_melee
    }
}

fun getHeroHealth(baseHealth: Float, baseStr: Int) = round(baseHealth + baseStr * 20).toInt()