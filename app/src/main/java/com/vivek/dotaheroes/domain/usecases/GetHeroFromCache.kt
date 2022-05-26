package com.vivek.dotaheroes.domain.usecases

import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.repository.HeroCache
import com.vivek.dotaheroes.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHeroFromCache @Inject constructor(
    private val cache: HeroCache
) {
    fun execute(id: Int): Flow<Resource<Hero>> = flow {
        emit(Resource.Loading(isLoading = true))

        try {
            val cachedHero = cache.getHeroById(id = id)
                ?: throw Exception("This Hero does not exist in the cache")

            emit(Resource.Success(data = cachedHero))
        } catch (e: Exception) {
            e.printStackTrace()

            emit(Resource.Error(message = e.message ?: "Unknown Error"))
        }

        emit(Resource.Loading(isLoading = false))
    }
}
























