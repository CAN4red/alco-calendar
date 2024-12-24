package com.example.alcocalendar.ui.calendar.viewmodel

import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.ui.theme.color.GreenDrunkHard
import com.example.alcocalendar.ui.theme.color.GreenDrunkHigh
import com.example.alcocalendar.ui.theme.color.GreenDrunkLow
import com.example.alcocalendar.ui.theme.color.GreenDrunkMedium

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

    fun getSessionColor(alcoUnits: Double): Color {
        if (alcoUnits > thresholdHard) return GreenDrunkHard
        if (alcoUnits > thresholdHigh) return GreenDrunkHigh
        if (alcoUnits > thresholdMedium) return GreenDrunkMedium
        if (alcoUnits > thresholdLow) return GreenDrunkLow
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
