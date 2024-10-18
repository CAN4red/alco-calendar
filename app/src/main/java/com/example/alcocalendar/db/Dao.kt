package com.example.alcocalendar.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.alcocalendar.db.entities.DrinkingSession

@Dao
interface DrinkingSessionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkingSession(drinkingSession: DrinkingSession)

    @Transaction
    @Query("SELECT * FROM drinking_sessions")
    suspend fun getDrinkingSessions(): List<DrinkingSession>
}