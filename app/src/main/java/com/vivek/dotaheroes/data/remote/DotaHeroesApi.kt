package com.vivek.dotaheroes.data.remote

import com.vivek.dotaheroes.data.remote.model.HeroDto
import retrofit2.http.GET

interface DotaHeroesApi {

    @GET("api/heroStats")
    suspend fun getHeroes(): List<HeroDto>

    companion object {
        const val BASE_URL = "https://api.opendota.com"
    }
}

























