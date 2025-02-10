package com.example.alcocalendar.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alcocalendar.core.database.converters.DrinkTypeConverter
import com.example.alcocalendar.core.database.converters.LocalDateConverter
import com.example.alcocalendar.core.database.dao.DrinkingSessionDao
import com.example.alcocalendar.core.database.entities.DrinkingSessionEntity
import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.core.database.entities.DrinkIntakeEntity

@Database(
    entities = [DrinkingSessionEntity::class, DrinkIntakeEntity::class],
    version = 2,
    exportSchema = false,
)
@TypeConverters(LocalDateConverter::class, DrinkTypeConverter::class)
abstract class DrinkingSessionDatabase : RoomDatabase() {

    abstract val drinkingSessionDao: DrinkingSessionDao
    abstract val drinkIntakeDao : DrinkIntakeDao

    companion object {
        @Volatile
        private var INSTANCE: DrinkingSessionDatabase? = null

        fun getInstance(context: Context): DrinkingSessionDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, DrinkingSessionDatabase::class.java, "drinking_session_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}