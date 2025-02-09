package com.example.alcocalendar.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import java.time.LocalDate

@Dao
interface DrinkingSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Update
    suspend fun updateDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Delete
    suspend fun deleteDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Query("SELECT * from drinking_session WHERE date = :date LIMIT 1")
    suspend fun getDrinkingSession(date: LocalDate): DrinkingSessionEntity

    @Query("SELECT * from drinking_session")
    suspend fun getAllDrinkingSessions(): List<DrinkingSessionEntity>
}