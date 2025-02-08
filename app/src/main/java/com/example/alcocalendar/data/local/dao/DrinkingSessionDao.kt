package com.example.alcocalendar.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface DrinkingSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Update
    suspend fun updateDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Delete
    suspend fun deleteDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Query("SELECT * from drinking_sessions WHERE date = :date LIMIT 1")
    suspend fun getDrinkingSession(date: LocalDate): Flow<DrinkingSessionEntity>

    @Query("SELECT * from drinking_sessions")
    suspend fun getAllDrinkingSessions(): Flow<List<DrinkingSessionEntity>>
}