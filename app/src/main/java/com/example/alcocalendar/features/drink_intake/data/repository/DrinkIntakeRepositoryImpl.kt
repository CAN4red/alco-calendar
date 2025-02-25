package com.example.alcocalendar.features.drink_intake.data.repository

import com.example.alcocalendar.core.data.mappers.DrinkIntakeMapper
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.core.data.local.relations.DrinkingSessionWithDrinkIntakes
import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import java.time.LocalDate
import javax.inject.Inject

class DrinkIntakeRepositoryImpl @Inject constructor(
    private val drinkIntakeDao: DrinkIntakeDao
) : DrinkIntakeRepository {
    override suspend fun insertDrinkIntake(drinkIntake: DrinkIntake) {
        drinkIntakeDao.insertDrinkIntake(DrinkIntakeMapper.toData(drinkIntake))
    }

    override suspend fun updateDrinkIntake(drinkIntake: DrinkIntake) {
        drinkIntakeDao.updateDrinkIntake(DrinkIntakeMapper.toData(drinkIntake))
    }

    override suspend fun deleteDrinkIntakeById(drinkIntakeId: Int) {
        drinkIntakeDao.deleteDrinkIntakeById(drinkIntakeId)
    }

    override suspend fun getDrinkIntakesByDate(date: LocalDate): List<DrinkIntake> {
        return drinkIntakeDao.getDrinkingSessionWithDrinkIntakes(date).drinkIntakes
            .map { DrinkIntakeMapper.toDomain(it) }
    }

    override suspend fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes> {
        return drinkIntakeDao.getDrinkingSessionsWithDrinkIntakes()
    }
}