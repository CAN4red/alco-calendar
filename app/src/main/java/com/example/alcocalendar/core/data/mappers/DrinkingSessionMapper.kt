package com.example.alcocalendar.core.data.mappers

import com.example.alcocalendar.core.data.local.entity.DrinkingSessionEntity
import com.example.alcocalendar.core.domain.model.DrinkingSession

object DrinkingSessionMapper {

    fun toDomain(sessionEntity: DrinkingSessionEntity?): DrinkingSession? {
        if (sessionEntity == null) return null
        return DrinkingSession(
            date = sessionEntity.date,
        )
    }

    fun toData(session: DrinkingSession): DrinkingSessionEntity {
        return DrinkingSessionEntity(
            date = session.date
        )
    }
}