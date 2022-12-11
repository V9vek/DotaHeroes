package com.vivek.dotaheroes.util

import android.graphics.Color
import com.vivek.dotaheroes.R
import com.vivek.dotaheroes.domain.model.HeroAttackType

fun getProWinRateTextColor(proWinRate: String): Int {
    val proWR = proWinRate.toInt()
    var textColor = "#F61E50"
    if (proWR > 50) textColor = "#2ED470"
    return Color.parseColor(textColor)
}

fun getHeroAttackImage(heroAttackType: HeroAttackType): Int {
    return when (heroAttackType) {
        HeroAttackType.Melee -> R.drawable.ic_melee
        HeroAttackType.Ranged -> R.drawable.ic_ranged
        HeroAttackType.Unknown -> R.drawable.ic_melee
    }
}