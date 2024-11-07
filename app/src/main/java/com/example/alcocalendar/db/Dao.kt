package com.example.alcocalendar.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.alcocalendar.db.entities.DrinkingSession
import java.time.LocalDate

@Dao
interface DrinkingSessionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkingSession(drinkingSession: DrinkingSession)

    @Update
    suspend fun updateDrinkingSession(drinkingSession: DrinkingSession)

    @Delete
    suspend fun deleteDrinkingSession(drinkingSession: DrinkingSession)

    @Transaction
    @Query("SELECT * FROM drinking_sessions WHERE date = :date LIMIT 1")
    suspend fun getDrinkingSession(date: LocalDate): DrinkingSession?

    @Transaction
    @Query("SELECT * FROM drinking_sessions")
    suspend fun getDrinkingSessions(): List<DrinkingSession>
}