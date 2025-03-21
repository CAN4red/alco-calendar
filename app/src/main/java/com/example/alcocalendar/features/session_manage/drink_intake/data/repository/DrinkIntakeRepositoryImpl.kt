package com.example.alcocalendar.features.session_manage.drink_intake.data.repository

import com.example.alcocalendar.core.data.local.entity.relations.DrinkingSessionWithDrinkIntakes
import com.example.alcocalendar.core.data.mappers.DrinkIntakeMapper
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.features.session_manage.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.features.session_manage.drink_intake.domain.repository.DrinkIntakeRepository
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

    override suspend fun deleteDrinkIntake(drinkIntake: DrinkIntake) {
        drinkIntakeDao.deleteDrinkIntake(DrinkIntakeMapper.toData(drinkIntake))
    }

    override suspend fun getDrinkIntakesByDate(date: LocalDate): List<DrinkIntake> {
        return drinkIntakeDao
            .getDrinkingSessionWithDrinkIntakes(date)?.drinkIntakes
            ?.map { DrinkIntakeMapper.toDomain(it) } ?: emptyList()
    }

    override suspend fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes> {
        return drinkIntakeDao.getDrinkingSessionsWithDrinkIntakes()
    }
}