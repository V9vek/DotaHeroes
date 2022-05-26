package com.vivek.dotaheroes.di

import android.app.Application
import androidx.room.Room
import com.vivek.dotaheroes.data.cache.HeroDatabase
import com.vivek.dotaheroes.data.cache.HeroDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): HeroDatabase {
        return Room.databaseBuilder(
            app,
            HeroDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}
























