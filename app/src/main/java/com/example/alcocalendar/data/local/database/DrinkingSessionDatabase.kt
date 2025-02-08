package com.example.alcocalendar.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alcocalendar.data.local.converters.LocalDateConverter
import com.example.alcocalendar.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity

@Database(
    entities = [DrinkingSessionEntity::class],
    version = 0,
    exportSchema = false,
)
@TypeConverters(LocalDateConverter::class)
abstract class DrinkingSessionDatabase : RoomDatabase() {

    abstract val drinkingSessionDao: DrinkingSessionDao

    companion object {
        @Volatile
        private var INSTANCE: DrinkingSessionDatabase? = null

        fun getInstance(context: Context): DrinkingSessionDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, DrinkingSessionDatabase::class.java, "drinking_session_database")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}