package com.example.alcocalendar.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DrinkingSessionEntity(
    @PrimaryKey(autoGenerate = true)
    val sessionId: Int,
    @Embedded
    val totalIntake: TotalIntake,
)