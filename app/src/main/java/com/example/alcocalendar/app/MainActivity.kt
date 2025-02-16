package com.example.alcocalendar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.alcocalendar.features.calendar.presentation.month_appearance.MonthCalendarScreen
import com.example.alcocalendar.features.calendar.presentation.year_appearance.YearCalendarScreen
import com.example.alcocalendar.features.drink_intake.ui.theme.AlcoCalendarTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.Month
import java.time.Year
import java.time.YearMonth

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            AlcoCalendarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    val currentMonth = YearMonth.now()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.MonthCalendarScreen.route +
                                "/{${currentMonth.year}}" +
                                "/{${currentMonth.month.toString().lowercase()}}",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(
                            route = Screen.MonthCalendarScreen.route + "/{year}/{month}",
                            arguments = listOf(
                                navArgument("year") { type = NavType.IntType },
                                navArgument("month") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val yearInt = backStackEntry.arguments?.getInt("year")
                            val monthString = backStackEntry.arguments?.getString("month")

                            val month = monthString?.let { Month.valueOf(it.uppercase()) }
                            val firstVisibleMonth = yearInt?.let { YearMonth.of(it, month) } ?: YearMonth.now()

                            MonthCalendarScreen(
                                navController = navController,
                                firstVisibleMonth = firstVisibleMonth,
                            )
                        }
                        composable(
                            route = Screen.YearCalendarScreen.route + "/{year}",
                            arguments = listOf(navArgument("year") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val yearInt = backStackEntry.arguments?.getInt("year")

                            val firstVisibleYear = yearInt?.let { Year.of(it) } ?: Year.now()

                            YearCalendarScreen(
                                navController = navController,
                                firstVisibleYear = firstVisibleYear
                            )
                        }
                    }
                }
            }
        }
    }
}
