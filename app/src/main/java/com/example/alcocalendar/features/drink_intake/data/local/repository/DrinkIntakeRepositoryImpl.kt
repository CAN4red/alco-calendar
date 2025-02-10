package com.example.alcocalendar.features.drink_intake.data.local.repository

import com.example.alcocalendar.core.data.local.entities.DrinkIntake
import com.example.alcocalendar.core.domain.repository.DrinkIntakeRepository
import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.features.drink_intake.data.local.entities.relations.DrinkingSessionWithDrinkIntakes
import java.time.LocalDate

class DrinkIntakeRepositoryImpl(
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