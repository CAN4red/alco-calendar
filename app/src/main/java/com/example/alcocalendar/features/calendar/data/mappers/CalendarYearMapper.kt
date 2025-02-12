package com.example.alcocalendar.features.calendar.data.mappers

import com.example.alcocalendar.core.data.mappers.DrinkIntakeMapper
import com.example.alcocalendar.core.data.mappers.DrinkingSessionMapper
import com.example.alcocalendar.features.calendar.domain.model.CalendarYear
import com.example.alcocalendar.core.data.local.relations.DrinkingSessionWithDrinkIntakes

object CalendarYearMapper {

    fun toDomain(drinkingSessionsWithDrinkIntakes: List<DrinkingSessionWithDrinkIntakes>): CalendarYear {
        val sessionsWithIntakes = drinkingSessionsWithDrinkIntakes.associate { session ->
            val drinkingSession = DrinkingSessionMapper.toDomain(session.drinkingSession)
            val drinkIntakes = session.drinkIntakes.map { intake -> DrinkIntakeMapper.toDomain(intake) }

            drinkingSession to drinkIntakes
        }
        return CalendarYear(sessionsWithIntakes)
    }
}