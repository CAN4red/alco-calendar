package com.example.alcocalendar.ui.calendar.viewmodel

import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.ui.theme.color.GreenDrunkHard
import com.example.alcocalendar.ui.theme.color.GreenDrunkHigh
import com.example.alcocalendar.ui.theme.color.GreenDrunkLow
import com.example.alcocalendar.ui.theme.color.GreenDrunkMedium

class DrinkStatistics {
    private val alcoUnitsPopulation: MutableList<Double> = mutableListOf()

    private var minAlcoUnitsForLow: Double = 0.0
    private var minAlcoUnitsForMedium: Double = 0.0
    private var minAlcoUnitsForHigh: Double = 0.0
    private var minAlcoUnitsForHard: Double = 0.0

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
        if (alcoUnits > minAlcoUnitsForHard) return GreenDrunkHard
        if (alcoUnits > minAlcoUnitsForHigh) return GreenDrunkHigh
        if (alcoUnits > minAlcoUnitsForMedium) return GreenDrunkMedium
        if (alcoUnits > minAlcoUnitsForLow) return GreenDrunkLow
        return Color.Transparent
    }

    private fun updateMinAlcoUnits() {
        minAlcoUnitsForHard = getMinFor(CUMULATIVE_PERCENT_HARD)
        minAlcoUnitsForHigh = getAdjustedMinFor(CUMULATIVE_PERCENT_HIGH, minAlcoUnitsForHard)
        minAlcoUnitsForMedium = getAdjustedMinFor(CUMULATIVE_PERCENT_MEDIUM, minAlcoUnitsForHigh)
        minAlcoUnitsForLow = getAdjustedMinFor(CUMULATIVE_PERCENT_LOW, minAlcoUnitsForMedium)
    }

    private fun getAdjustedMinFor(percentage: Double, reference: Double): Double {
        val minValue = getMinFor(percentage)
        if (minValue == reference) {
            return alcoUnitsPopulation.lastOrNull { it < reference } ?: minValue
        }
        return minValue
    }

    private fun getMinFor(percentage: Double): Double {
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
