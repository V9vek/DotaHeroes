package com.vivek.dotaheroes.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroEntity(
    @PrimaryKey val id: Long,
    val localizedName: String,
    val primaryAttribute: String,
    val attackType: String,
    val roleCarry: Long?,
    val roleEscape: Long?,
    val roleNuker: Long?,
    val roleInitiator: Long?,
    val roleDurable: Long?,
    val roleDisabler: Long?,
    val roleJungler: Long?,
    val roleSupport: Long?,
    val rolePusher: Long?,
    val img: String,
    val icon: String,
    val baseHealth: Double,
    val baseHealthRegen: Double?,
    val baseMana: Double,
    val baseManaRegen: Double?,
    val baseArmor: Double,
    val baseMoveRate: Double,
    val baseAttackMin: Double,
    val baseAttackMax: Double,
    val baseStr: Long,
    val baseAgi: Long,
    val baseInt: Long,
    val strGain: Double,
    val agiGain: Double,
    val intGain: Double,
    val attackRange: Long,
    val projectileSpeed: Long,
    val attackRate: Double,
    val moveSpeed: Long,
    val turnRate: Double?,
    val legs: Long,
    val turboPicks: Long,
    val turboWins: Long,
    val proWins: Long,
    val proPick: Long,
    val firstPick: Long,
    val firstWin: Long,
    val secondPick: Long,
    val secondWin: Long,
    val thirdPick: Long,
    val thirdWin: Long,
    val fourthPick: Long,
    val fourthWin: Long,
    val fifthPick: Long,
    val fifthWin: Long,
    val sixthPick: Long,
    val sixthWin: Long,
    val seventhPick: Long,
    val seventhWin: Long,
    val eighthPick: Long,
    val eighthWin: Long
) {
    override fun toString(): String = """
  |HeroEntity [
  |  id: $id
  |  localizedName: $localizedName
  |  primaryAttribute: $primaryAttribute
  |  attackType: $attackType
  |  roleCarry: $roleCarry
  |  roleEscape: $roleEscape
  |  roleNuker: $roleNuker
  |  roleInitiator: $roleInitiator
  |  roleDurable: $roleDurable
  |  roleDisabler: $roleDisabler
  |  roleJungler: $roleJungler
  |  roleSupport: $roleSupport
  |  rolePusher: $rolePusher
  |  img: $img
  |  icon: $icon
  |  baseHealth: $baseHealth
  |  baseHealthRegen: $baseHealthRegen
  |  baseMana: $baseMana
  |  baseManaRegen: $baseManaRegen
  |  baseArmor: $baseArmor
  |  baseMoveRate: $baseMoveRate
  |  baseAttackMin: $baseAttackMin
  |  baseAttackMax: $baseAttackMax
  |  baseStr: $baseStr
  |  baseAgi: $baseAgi
  |  baseInt: $baseInt
  |  strGain: $strGain
  |  agiGain: $agiGain
  |  intGain: $intGain
  |  attackRange: $attackRange
  |  projectileSpeed: $projectileSpeed
  |  attackRate: $attackRate
  |  moveSpeed: $moveSpeed
  |  turnRate: $turnRate
  |  legs: $legs
  |  turboPicks: $turboPicks
  |  turboWins: $turboWins
  |  proWins: $proWins
  |  proPick: $proPick
  |  firstPick: $firstPick
  |  firstWin: $firstWin
  |  secondPick: $secondPick
  |  secondWin: $secondWin
  |  thirdPick: $thirdPick
  |  thirdWin: $thirdWin
  |  fourthPick: $fourthPick
  |  fourthWin: $fourthWin
  |  fifthPick: $fifthPick
  |  fifthWin: $fifthWin
  |  sixthPick: $sixthPick
  |  sixthWin: $sixthWin
  |  seventhPick: $seventhPick
  |  seventhWin: $seventhWin
  |  eighthPick: $eighthPick
  |  eighthWin: $eighthWin
  |]
  """.trimMargin()
}
