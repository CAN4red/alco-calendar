package com.example.alcocalendar.features.calendar.data.mappers

import com.example.alcocalendar.core.data.mappers.DrinkIntakeMapper
import com.example.alcocalendar.core.data.mappers.DrinkingSessionMapper
import com.example.alcocalendar.features.calendar.domain.model.CalendarMonth
import com.example.alcocalendar.core.data.local.relations.DrinkingSessionWithDrinkIntakes

object CalendarMonthMapper {

    fun toDomain(drinkingSessionsWithDrinkIntakes: List<DrinkingSessionWithDrinkIntakes>): CalendarMonth {
        val sessionsWithIntakes = drinkingSessionsWithDrinkIntakes.associate { session ->
            val drinkingSession = DrinkingSessionMapper.toDomain(session.drinkingSession)
            val drinkIntakes = session.drinkIntakes.map { intake -> DrinkIntakeMapper.toDomain(intake) }

            drinkingSession to drinkIntakes
        }
        return CalendarMonth(sessionsWithIntakes)
    }
}
