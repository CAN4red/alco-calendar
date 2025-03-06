package com.example.alcocalendar.features.session_manage.drink_intake.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.alcocalendar.core.data.local.entity.DrinkIntakeEntity
import com.example.alcocalendar.core.data.local.entity.relations.DrinkingSessionWithDrinkIntakes
import java.time.LocalDate

@Dao
interface DrinkIntakeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkIntake(drinkIntake: DrinkIntakeEntity)

    @Update
    suspend fun updateDrinkIntake(drinkIntake: DrinkIntakeEntity)

    @Delete
    suspend fun deleteDrinkIntake(drinkIntake: DrinkIntakeEntity)

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE date = :date")
    suspend fun getDrinkingSessionWithDrinkIntakes(date: LocalDate): DrinkingSessionWithDrinkIntakes?

    @Transaction
    @Query("SELECT * FROM drinking_session")
    suspend fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes>
}
