package com.example.alcocalendar.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alcocalendar.core.data.local.entities.DrinkingSession
import java.time.LocalDate

@Dao
interface DrinkingSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkingSession(drinkingSessionEntity: DrinkingSession)

    @Update
    suspend fun updateDrinkingSession(drinkingSessionEntity: DrinkingSession)

    @Delete
    suspend fun deleteDrinkingSession(drinkingSessionEntity: DrinkingSession)

    @Query("DELETE FROM drinking_session WHERE date = :date")
    suspend fun deleteDrinkingSessionByDate(date: LocalDate)

    @Query("SELECT * FROM drinking_session WHERE date = :date")
    suspend fun getDrinkingSession(date: LocalDate): DrinkingSession
}