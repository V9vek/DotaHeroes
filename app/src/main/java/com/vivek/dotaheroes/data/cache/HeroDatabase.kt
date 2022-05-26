package com.vivek.dotaheroes.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vivek.dotaheroes.data.cache.model.HeroEntity

@Database(
    entities = [HeroEntity::class],
    version = 1
)
abstract class HeroDatabase : RoomDatabase() {

    abstract val dao: HeroDao

    companion object {
        const val DATABASE_NAME = "herodb.db"
    }
}


























