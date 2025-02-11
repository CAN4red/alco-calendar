package com.example.alcocalendar.core.domain.repository

import com.example.alcocalendar.core.data.local.entities.DrinkIntake
import com.example.alcocalendar.features.drink_intake.data.local.entities.relations.DrinkingSessionWithDrinkIntakes
import java.time.LocalDate

interface SharedDrinkIntakeRepository {

    suspend fun getDrinkIntakesByDate(date: LocalDate): List<DrinkIntake>

    suspend fun getDrinkingSessionsWithDrinkIntakes(): List<DrinkingSessionWithDrinkIntakes>
}