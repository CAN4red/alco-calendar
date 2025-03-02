package com.example.alcocalendar.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alcocalendar.core.data.local.entities.DrinkingSessionEntity
import java.time.LocalDate

@Dao
interface DrinkingSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Update
    suspend fun updateDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Delete
    suspend fun deleteDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Query("DELETE FROM drinking_session WHERE date = :date")
    suspend fun deleteDrinkingSessionByDate(date: LocalDate)

    @Query("SELECT * FROM drinking_session WHERE date = :date")
    suspend fun getDrinkingSession(date: LocalDate): DrinkingSessionEntity?
}