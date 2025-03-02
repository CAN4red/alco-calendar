package com.example.alcocalendar.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alcocalendar.core.data.local.converters.DrinkTypeConverter
import com.example.alcocalendar.core.data.local.converters.LocalDateConverter
import com.example.alcocalendar.core.data.local.converters.YearMonthTypeConverter
import com.example.alcocalendar.core.data.local.converters.YearTypeConverter
import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.core.data.local.entities.DrinkIntakeEntity
import com.example.alcocalendar.core.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao

@Database(
    entities = [DrinkingSessionEntity::class, DrinkIntakeEntity::class],
    version = 4,
    exportSchema = false,
)
@TypeConverters(
    LocalDateConverter::class,
    DrinkTypeConverter::class,
    YearMonthTypeConverter::class,
    YearTypeConverter::class
)
abstract class DrinkingSessionDatabase : RoomDatabase() {

    abstract val drinkingSessionDao: DrinkingSessionDao
    abstract val drinkIntakeDao: DrinkIntakeDao
    abstract val calendarDao: CalendarDao

    companion object {
        @Volatile
        private var INSTANCE: DrinkingSessionDatabase? = null

        fun getInstance(context: Context): DrinkingSessionDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    DrinkingSessionDatabase::class.java,
                    "drinking_session_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}