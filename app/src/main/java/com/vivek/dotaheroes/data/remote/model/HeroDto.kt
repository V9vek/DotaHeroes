package com.vivek.dotaheroes.data.remote.model

import com.google.gson.annotations.SerializedName

data class HeroDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("localized_name")
    val localizedName: String,

    @SerializedName("primary_attr")
    val primaryAttribute: String,

    @SerializedName("attack_type")
    val attackType: String,

    @SerializedName("roles")
    val roles: List<String>,

    @SerializedName("img")
    val img: String,

    @SerializedName("icon")
    val icon: String,

    @SerializedName("base_health")
    val baseHealth: Float,

    @SerializedName("base_health_regen")
    val baseHealthRegen: Float?,

    @SerializedName("base_mana")
    val baseMana: Float,

    @SerializedName("base_mana_regen")
    val baseManaRegen: Float?,

    @SerializedName("base_armor")
    val baseArmor: Float,

    @SerializedName("base_mr")
    val baseMoveRate: Float,

    @SerializedName("base_attack_min")
    val baseAttackMin: Int,

    @SerializedName("base_attack_max")
    val baseAttackMax: Int,

    @SerializedName("base_str")
    val baseStr: Int,

    @SerializedName("base_agi")
    val baseAgi: Int,

    @SerializedName("base_int")
    val baseInt: Int,

    @SerializedName("str_gain")
    val strGain: Float, // Strength gain per lvl

    @SerializedName("agi_gain")
    val agiGain: Float, // Agility gain per lvl

    @SerializedName("int_gain")
    val intGain: Float, // Intelligence gain per lvl

    @SerializedName("attack_range")
    val attackRange: Int,

    @SerializedName("projectile_speed")
    val projectileSpeed: Int,

    @SerializedName("attack_rate")
    val attackRate: Float,

    @SerializedName("move_speed")
    val moveSpeed: Int,

    @SerializedName("turn_rate")
    val turnRate: Float? = 0F,

    @SerializedName("legs")
    val legs: Int, // How many legs does this hero have?

    @SerializedName("turbo_picks")
    val turboPicks: Int, // How many times picked for turbo matches?

    @SerializedName("turbo_wins")
    val turboWins: Int, // How many times won a turbo match?

    @SerializedName("pro_win")
    val proWins: Int? = 0, // How many times won a pro match?

    @SerializedName("pro_pick")
    val proPick: Int? = 0, // How many times picked in pro match?

    @SerializedName("1_pick")
    val firstPick: Int, // How many times picked first?

    @SerializedName("1_win")
    val firstWin: Int, // How many times picked first and won?

    @SerializedName("2_pick")
    val secondPick: Int, // How many times picked second?

    @SerializedName("2_win")
    val secondWin: Int, // How many times picked second and won?

    @SerializedName("3_pick")
    val thirdPick: Int, // How many times picked third?

    @SerializedName("3_win")
    val thirdWin: Int, // How many times picked third and won?

    @SerializedName("4_pick")
    val fourthPick: Int, // How many times picked in fourth round?

    @SerializedName("4_win")
    val fourthWin: Int, // How many times picked in fourth round and won?

    @SerializedName("5_pick")
    val fifthPick: Int, // How many times picked fifth?

    @SerializedName("5_win")
    val fifthWin: Int, // How many times picked fifth and won?

    @SerializedName("6_pick")
    val sixthPick: Int, // How many times picked sixth?

    @SerializedName("6_win")
    val sixthWin: Int, // How many times picked sixth and won?

    @SerializedName("7_pick")
    val seventhPick: Int, // How many times picked seventh?

    @SerializedName("7_win")
    val seventhWin: Int, // How many times picked seventh and won?

    @SerializedName("8_pick")
    val eighthPick: Int, // How many times picked eighth round?

    @SerializedName("8_win")
    val eighthWin: Int, // How many times picked eighth and won?
)
