package com.example.alcocalendar.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.data.local.entities.drinks.DrinkIntakeEntity
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

    @Delete
    suspend fun deleteDrinkIntake(drinkIntakeEntity: DrinkIntakeEntity)

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE date = :date")
    fun getParentWithChildren(date: LocalDate): DrinkingSessionWithDrinkIntakes

    @Transaction
    @Query("SELECT * FROM drinking_session")
    fun getAllParentsWithChildren(): List<DrinkingSessionWithDrinkIntakes>
}