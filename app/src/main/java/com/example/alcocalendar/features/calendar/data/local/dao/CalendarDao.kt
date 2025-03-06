package com.example.alcocalendar.features.calendar.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.alcocalendar.core.data.local.entity.relations.DrinkingSessionWithDrinkIntakes

@Dao
interface CalendarDao {

    @Transaction
    @Query("SELECT * FROM drinking_session")
    suspend fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes>
}