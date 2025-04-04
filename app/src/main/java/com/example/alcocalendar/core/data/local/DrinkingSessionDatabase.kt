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
import com.example.alcocalendar.core.data.local.entity.DrinkIntakeEntity
import com.example.alcocalendar.core.data.local.entity.DrinkingSessionEntity
import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.session_manage.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.features.session_manage.media.data.local.dao.MediaDao
import com.example.alcocalendar.features.session_manage.media.data.local.entity.MediaItemEntity
import com.example.alcocalendar.features.session_manage.notes.data.local.dao.NotesDao
import com.example.alcocalendar.features.session_manage.notes.data.local.entity.NoteEntity

@Database(
    entities = [
        DrinkingSessionEntity::class,
        DrinkIntakeEntity::class,
        NoteEntity::class,
        MediaItemEntity::class,
    ],
    version = 9,
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
    abstract val notesDao: NotesDao
    abstract val mediaDao: MediaDao

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