package com.example.alcocalendar.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alcocalendar.db.converters.LocalDateConverter
import com.example.alcocalendar.db.entities.DrinkingSession

@Database(
    entities = [DrinkingSession::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateConverter::class)
abstract class DrinkingSessionDatabase : RoomDatabase() {

    abstract val drinkingSessionsDao: DrinkingSessionsDao

    companion object {
        @Volatile
        private var INSTANCE: DrinkingSessionDatabase? = null

        fun getInstance(context: Context): DrinkingSessionDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DrinkingSessionDatabase::class.java,
                    "drinking_sessions_db"
                )
                    .fallbackToDestructiveMigration()
                    .build().also {
                        INSTANCE = it
                    }
            }
        }
    }
}