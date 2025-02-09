package com.example.alcocalendar.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.data.local.entities.DrinkIntakeEntity
import com.example.alcocalendar.data.local.entities.relations.DrinkingSessionWithDrinkIntakes
import java.time.LocalDate

@Dao
interface DrinkingSessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkIntake(drinkIntakeEntity: DrinkIntakeEntity)

    @Update
    suspend fun updateDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Update
    suspend fun updateDrinkIntake(drinkIntakeEntity: DrinkIntakeEntity)

    @Delete
    suspend fun deleteDrinkingSession(drinkingSessionEntity: DrinkingSessionEntity)

    @Query("DELETE FROM drinking_session WHERE date = :date")
    suspend fun deleteDrinkingSessionByDate(date: LocalDate)

    @Delete
    suspend fun deleteDrinkIntake(drinkIntakeEntity: DrinkIntakeEntity)

    @Query("DELETE FROM drink_intake WHERE drinkIntakeId = :drinkIntakeId")
    suspend fun deleteDrinkIntakeById(drinkIntakeId: Int)

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE date = :date")
    fun getDrinkingSessionWithDrinkIntakes(date: LocalDate): DrinkingSessionWithDrinkIntakes

    @Transaction
    @Query("SELECT * FROM drinking_session")
    fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes>
}