package com.example.alcocalendar.data.local.entities

import com.example.alcocalendar.data.local.entities.drinks.types.DrinkType

interface DrinkIntake {
    val drinkType: DrinkType
    val liters: Double
    val alcoStrength: Double
}

