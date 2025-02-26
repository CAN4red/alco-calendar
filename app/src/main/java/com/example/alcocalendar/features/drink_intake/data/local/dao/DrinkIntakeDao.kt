package com.example.alcocalendar.features.drink_intake.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.alcocalendar.core.data.local.entities.DrinkIntakeEntity
import com.example.alcocalendar.core.data.local.relations.DrinkingSessionWithDrinkIntakes
import java.time.LocalDate

@Dao
interface DrinkIntakeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkIntake(drinkIntake: DrinkIntakeEntity)

    @Update
    suspend fun updateDrinkIntake(drinkIntake: DrinkIntakeEntity)

    @Delete
    suspend fun deleteDrinkIntake(drinkIntake: DrinkIntakeEntity)

    @Query("DELETE FROM drink_intake WHERE drinkIntakeId = :drinkIntakeId")
    suspend fun deleteDrinkIntakeById(drinkIntakeId: Int)

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE date = :date")
    suspend fun getDrinkingSessionWithDrinkIntakes(date: LocalDate): DrinkingSessionWithDrinkIntakes?

    @Transaction
    @Query("SELECT * FROM drinking_session")
    suspend fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes>
}
