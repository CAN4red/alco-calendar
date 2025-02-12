package com.example.alcocalendar.core.data.mappers

import com.example.alcocalendar.core.data.local.entities.DrinkIntakeEntity
import com.example.alcocalendar.core.domain.model.DrinkIntake

object DrinkIntakeMapper {

    fun toDomain(intakeEntity: DrinkIntakeEntity): DrinkIntake {
        return DrinkIntake(
            drinkIntakeId = intakeEntity.drinkIntakeId,
            date = intakeEntity.date,
            drinkType = intakeEntity.drinkType,
            liters = intakeEntity.liters,
            alcoStrength = intakeEntity.alcoStrength
        )
    }

    fun toData(intake: DrinkIntake): DrinkIntakeEntity {
        return DrinkIntakeEntity(
            drinkIntakeId = intake.drinkIntakeId,
            date = intake.date,
            drinkType = intake.drinkType,
            liters = intake.liters,
            alcoStrength = intake.alcoStrength
        )
    }
}