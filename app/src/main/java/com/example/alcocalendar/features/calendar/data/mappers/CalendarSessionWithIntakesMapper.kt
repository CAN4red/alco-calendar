package com.example.alcocalendar.features.calendar.data.mappers

import com.example.alcocalendar.core.data.local.entity.relations.DrinkingSessionWithDrinkIntakes
import com.example.alcocalendar.core.data.mappers.DrinkIntakeMapper
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes

object CalendarSessionWithIntakesMapper {

    fun toDomain(sessionWithIntakes: DrinkingSessionWithDrinkIntakes): CalendarSessionWithIntakes {
        return CalendarSessionWithIntakes(
            date = sessionWithIntakes.drinkingSession.date,
            intakes = sessionWithIntakes.drinkIntakes.map { DrinkIntakeMapper.toDomain(it) }
        )
    }
}