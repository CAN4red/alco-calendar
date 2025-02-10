package com.example.alcocalendar.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alcocalendar.core.data.local.converters.DrinkTypeConverter
import com.example.alcocalendar.core.data.local.converters.LocalDateConverter
import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.core.data.local.entities.DrinkingSession
import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.core.data.local.entities.DrinkIntake

@Database(
    entities = [DrinkingSession::class, DrinkIntake::class],
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