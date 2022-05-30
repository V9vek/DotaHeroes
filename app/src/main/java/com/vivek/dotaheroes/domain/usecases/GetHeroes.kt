package com.vivek.dotaheroes.domain.usecases

import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.repository.HeroCache
import com.vivek.dotaheroes.domain.repository.HeroNetwork
import com.vivek.dotaheroes.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// TODO: add swipe to refresh

class GetHeroes @Inject constructor(
    private val api: HeroNetwork,
    private val cache: HeroCache
) {
    fun execute(): Flow<Resource<List<Hero>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val cachedHeroes = cache.getAllHeores()

        emit(Resource.Success(data = cachedHeroes.ifEmpty { emptyList() }))

        val isDbEmpty = cachedHeroes.isEmpty()
        val shouldLoadFromCache = !isDbEmpty

        if (shouldLoadFromCache) {
            emit(Resource.Loading(isLoading = false))
            return@flow
        }

        val remoteHeroes = try {
            val response = api.getHeroes()
            response
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = e.message ?: "Unknown Error"))
            null
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(message = e.message ?: "Unknown Error"))
            null
        }

        remoteHeroes?.let { heroes ->
            cache.deleteAllHeroes()
            cache.insertHeroes(heroes)

            emit(Resource.Success(data = cache.getAllHeores()))
        }

        emit(Resource.Loading(isLoading = false))
    }
}






























