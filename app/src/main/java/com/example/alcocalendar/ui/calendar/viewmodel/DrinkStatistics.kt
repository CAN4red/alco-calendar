package com.example.alcocalendar.ui.calendar.viewmodel

import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.ui.theme.color.DarkSessionPallet
import com.example.alcocalendar.ui.theme.color.LightSessionPallet

class DrinkStatistics {
    private val alcoUnitsPopulation: MutableList<Double> = mutableListOf()

    private var thresholdLow: Double = 0.0
    private var thresholdMedium: Double = 0.0
    private var thresholdHigh: Double = 0.0
    private var thresholdHard: Double = 0.0

    fun updatePopulation(alcoUnits: Double) {
        if (alcoUnits == 0.0) return
        alcoUnitsPopulation.add(alcoUnits)
        alcoUnitsPopulation.sort()
        updateMinAlcoUnits()
    }

    fun deleteFromPopulation(alcoUnits: Double) {
        alcoUnitsPopulation.remove(alcoUnits)
        updateMinAlcoUnits()
    }

    fun getSessionColor(alcoUnits: Double, isSystemInDarkTheme: Boolean): Color {
        val sessionPallet = if (isSystemInDarkTheme) DarkSessionPallet else LightSessionPallet
        if (alcoUnits >= thresholdHard) return sessionPallet.GreenDrunkHard
        if (alcoUnits >= thresholdHigh) return sessionPallet.GreenDrunkHigh
        if (alcoUnits >= thresholdMedium) return sessionPallet.GreenDrunkMedium
        if (alcoUnits >= thresholdLow) return sessionPallet.GreenDrunkLow
        return Color.Transparent
    }

    private fun updateMinAlcoUnits() {
        thresholdHard = getThresholdFor(CUMULATIVE_PERCENT_HARD)
        thresholdHigh = getAdjustedThresholdFor(CUMULATIVE_PERCENT_HIGH, thresholdHard)
        thresholdMedium = getAdjustedThresholdFor(CUMULATIVE_PERCENT_MEDIUM, thresholdHigh)
        thresholdLow = getAdjustedThresholdFor(CUMULATIVE_PERCENT_LOW, thresholdMedium)
    }

    private fun getAdjustedThresholdFor(percentage: Double, reference: Double): Double {
        val minValue = getThresholdFor(percentage)
        if (minValue == reference) {
            return alcoUnitsPopulation.lastOrNull { it < reference } ?: minValue
        }
        return minValue
    }

    private fun getThresholdFor(percentage: Double): Double {
        if (alcoUnitsPopulation.isEmpty()) return 0.0
        val index = (percentage * alcoUnitsPopulation.lastIndex).toInt()
        return alcoUnitsPopulation[index]
    }

    companion object {
        private const val CUMULATIVE_PERCENT_LOW = 0.0
        private const val CUMULATIVE_PERCENT_MEDIUM = 0.30
        private const val CUMULATIVE_PERCENT_HIGH = 0.60
        private const val CUMULATIVE_PERCENT_HARD = 0.85
    }
}
