package com.example.alcocalendar.core.data.mappers

import com.example.alcocalendar.core.data.local.entity.DrinkIntakeEntity
import com.example.alcocalendar.core.domain.model.DrinkIntake

object DrinkIntakeMapper {

    fun toDomain(intakeEntity: DrinkIntakeEntity): DrinkIntake {
        return DrinkIntake(
            date = intakeEntity.date,
            drinkType = intakeEntity.drinkType,
            liters = intakeEntity.liters,
            alcoStrength = intakeEntity.alcoStrength
        )
    }

    fun toData(intake: DrinkIntake): DrinkIntakeEntity {
        return DrinkIntakeEntity(
            date = intake.date,
            drinkType = intake.drinkType,
            liters = intake.liters,
            alcoStrength = intake.alcoStrength
        )
    }

    fun toInsertingData(intake: DrinkIntake): DrinkIntakeEntity {
        return DrinkIntakeEntity(
            date = intake.date,
            drinkType = intake.drinkType,
            liters = intake.liters,
            alcoStrength = intake.alcoStrength
        )
    }
}