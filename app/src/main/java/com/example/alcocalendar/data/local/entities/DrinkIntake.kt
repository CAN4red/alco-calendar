package com.example.alcocalendar.data.local.entities

import com.example.alcocalendar.data.local.entities.drink_types.DrinkType

interface DrinkIntake {
    val liters: Double
    val alcoStrength: Double
    val drinkType: DrinkType
}

