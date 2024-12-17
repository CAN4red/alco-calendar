package com.example.alcocalendar.model

import com.example.alcocalendar.db.entities.DrinkingSession

data class DrinkingSessionWrapper(
    val drinkingSession: DrinkingSession,
    val sessionOrder: SessionOrder = SessionOrder.EMPTY_SESSION,
) : DrinkingSession {
    override val date get() = drinkingSession.date
    override val beerIntake get() = drinkingSession.beerIntake
    override val wineIntake get() = drinkingSession.wineIntake
    override val spiritsIntake get() = drinkingSession.spiritsIntake
    override val otherIntake get() = drinkingSession.otherIntake
    override val isEmpty get() = drinkingSession.isEmpty
}