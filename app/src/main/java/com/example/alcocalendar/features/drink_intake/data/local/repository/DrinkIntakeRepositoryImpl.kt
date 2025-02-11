package com.example.alcocalendar.features.drink_intake.data.local.repository

import com.example.alcocalendar.core.data.local.entities.DrinkIntake
import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.features.drink_intake.data.local.entities.relations.DrinkingSessionWithDrinkIntakes
import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import java.time.LocalDate
import javax.inject.Inject

class DrinkIntakeRepositoryImpl @Inject constructor(
    private val drinkIntakeDao: DrinkIntakeDao
) : DrinkIntakeRepository {
    override suspend fun insertDrinkIntake(drinkIntake: DrinkIntake) {
        drinkIntakeDao.insertDrinkIntake(drinkIntake)
    }

    override suspend fun updateDrinkIntake(drinkIntake: DrinkIntake) {
        drinkIntakeDao.updateDrinkIntake(drinkIntake)
    }

    override suspend fun deleteDrinkIntakeById(drinkIntakeId: Int) {
        drinkIntakeDao.deleteDrinkIntakeById(drinkIntakeId)
    }

    override suspend fun getDrinkIntakesByDate(date: LocalDate): List<DrinkIntake> {
        return drinkIntakeDao.getDrinkingSessionWithDrinkIntakes(date).drinkIntakes
    }

    override suspend fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes> {
        return drinkIntakeDao.getDrinkingSessionsWithDrinkIntakes()
    }
}