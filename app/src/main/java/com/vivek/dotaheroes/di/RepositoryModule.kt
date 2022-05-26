package com.vivek.dotaheroes.di

import com.vivek.dotaheroes.data.repository.HeroCacheImpl
import com.vivek.dotaheroes.data.repository.HeroNetworkImpl
import com.vivek.dotaheroes.domain.repository.HeroCache
import com.vivek.dotaheroes.domain.repository.HeroNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindHeroNetwork(
        heroNetworkImpl: HeroNetworkImpl
    ): HeroNetwork

    @Singleton
    @Binds
    abstract fun bindHeroCache(
        heroCacheImpl: HeroCacheImpl
    ): HeroCache

}


























