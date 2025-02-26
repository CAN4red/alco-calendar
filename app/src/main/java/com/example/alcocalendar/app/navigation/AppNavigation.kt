package com.example.alcocalendar.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.alcocalendar.core.navigation.NavRoutes
import com.example.alcocalendar.features.calendar.presentation.month_appearance.MonthCalendarScreen
import com.example.alcocalendar.features.calendar.presentation.year_appearance.YearCalendarScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.CALENDAR,
        modifier = modifier,
    ) {
        navigation(
            startDestination = NavRoutes.MONTH_CALENDAR,
            route = NavRoutes.CALENDAR
        ) {
            composable(
                route = NavRoutes.MONTH_CALENDAR,
            ) { backStackEntry ->
                MonthCalendarScreen(
                    navController = navController,
                    viewModel = backStackEntry.sharedViewModel(navController)
                )
            }

            composable(
                route = NavRoutes.YEAR_CALENDAR,
            ) { backStackEntry ->
                YearCalendarScreen(
                    navController = navController,
                    viewModel = backStackEntry.sharedViewModel(navController)
                )
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}
