package com.vivek.dotaheroes.domain.model

sealed class HeroAttackType(
    val uiValue: String
) {
    object Melee : HeroAttackType(uiValue = "Melee")
    object Ranged : HeroAttackType(uiValue = "Ranged")
    object Unknown : HeroAttackType(uiValue = "Unknown")
}

fun getHeroAttackType(uiValue: String): HeroAttackType {
    return when (uiValue) {
        HeroAttackType.Melee.uiValue -> {
            HeroAttackType.Melee
        }
        HeroAttackType.Ranged.uiValue -> {
            HeroAttackType.Ranged
        }
        else -> {
            HeroAttackType.Unknown
        }
    }
}
