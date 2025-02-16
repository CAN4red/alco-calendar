package com.example.alcocalendar.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.alcocalendar.core.navigation.NavArgs
import com.example.alcocalendar.core.navigation.NavRoutes
import com.example.alcocalendar.features.calendar.presentation.month_appearance.MonthCalendarScreen
import com.example.alcocalendar.features.calendar.presentation.year_appearance.YearCalendarScreen
import java.time.YearMonth

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val currentMonth = YearMonth.now()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.monthCalendarRoute(
            year = currentMonth.year.toString(),
            month = currentMonth.month.toString().lowercase()
        ),
        modifier = modifier,
    ) {
        composable(
            route = NavRoutes.MONTH_CALENDAR,
            arguments = listOf(
                navArgument(NavArgs.YEAR) { type = NavType.IntType },
                navArgument(NavArgs.MONTH) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val firstVisibleMonth = backStackEntry.parseMonthFromArguments()

            MonthCalendarScreen(
                navController = navController,
                firstVisibleMonth = firstVisibleMonth,
            )
        }

        composable(
            route = NavRoutes.YEAR_CALENDAR,
            arguments = listOf(navArgument(NavArgs.YEAR) { type = NavType.IntType })
        ) { backStackEntry ->
            val firstVisibleYear = backStackEntry.parseYearFromArguments()

            YearCalendarScreen(
                navController = navController,
                firstVisibleYear = firstVisibleYear,
            )
        }
    }
}