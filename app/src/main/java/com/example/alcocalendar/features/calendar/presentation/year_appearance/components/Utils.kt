package com.example.alcocalendar.features.calendar.presentation.year_appearance.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import com.kizitonwose.calendar.compose.yearcalendar.YearCalendarLayoutInfo
import com.kizitonwose.calendar.compose.yearcalendar.YearCalendarState
import com.kizitonwose.calendar.core.CalendarYear
import kotlinx.coroutines.flow.filterNotNull

@Composable
fun rememberFirstMostVisibleYear(
    state: YearCalendarState,
    viewportPercent: Float = 50f,
): CalendarYear {
    val visibleMonth = remember(state) { mutableStateOf(state.firstVisibleYear) }
    LaunchedEffect(state) {
        snapshotFlow { state.layoutInfo.firstMostVisibleYear(viewportPercent) }
            .filterNotNull()
            .collect { month -> visibleMonth.value = month }
    }
    return visibleMonth.value
}

private fun YearCalendarLayoutInfo.firstMostVisibleYear(viewportPercent: Float = 50f): CalendarYear? {
    return if (visibleYearsInfo.isEmpty()) {
        null
    } else {
        val viewportSize = (viewportEndOffset + viewportStartOffset) * viewportPercent / 100f
        visibleYearsInfo.firstOrNull { itemInfo ->
            if (itemInfo.offset < 0) {
                itemInfo.offset + itemInfo.size >= viewportSize
            } else {
                itemInfo.size - itemInfo.offset >= viewportSize
            }
        }?.year
    }
}