package com.example.alcocalendar

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alcocalendar.ui.calendar.month.MonthLayout
import com.example.alcocalendar.ui.calendar.year.YearLayout
import com.example.alcocalendar.viewmodel.CalendarEvent
import com.example.alcocalendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.navigation.CalendarScreen

@Composable
fun AlcoCalendarApp(
    calendarState: CalendarState,
    onEvent: (CalendarEvent) -> Unit,
    navController: NavHostController = rememberNavController(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = CalendarScreen.MonthView.name,
        modifier = modifier
    ) {
        composable(route = CalendarScreen.MonthView.name) {
            MonthLayout(
                calendarState = calendarState,
                onEvent = onEvent,
                navigateToYear = { navController.navigate(CalendarScreen.YearView.name) },
                modifier = modifier
            )
        }
        composable(route = CalendarScreen.YearView.name) {
            YearLayout(
                calendarState = calendarState,
                onEvent = onEvent,
                navigateToYear = { navController.navigate(CalendarScreen.MonthView.name) },
                modifier = modifier,
            )
        }
    }
}
