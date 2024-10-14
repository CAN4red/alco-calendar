package com.example.alcocalendar.model

import java.time.LocalDate


data class DrinkingSessionModel(
    val date: LocalDate,
    val isDrunk: Boolean = false,
)