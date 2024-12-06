package com.example.alcocalendar

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.ui.addsession.screens.bottomsheets.AddBeerScreen
import com.example.alcocalendar.ui.addsession.screens.category.ChooseCategoryScreen
import com.example.alcocalendar.ui.addsession.screens.columns.AddOtherScreen
import com.example.alcocalendar.ui.addsession.screens.columns.AddSpiritsScreen
import com.example.alcocalendar.ui.addsession.screens.columns.AddWineScreen
import com.example.alcocalendar.ui.calendar.monthscreen.MonthLayout
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.calendar.yearscreen.YearLayout
import com.example.alcocalendar.ui.navigation.CalendarScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlcoCalendarApp(
    calendarState: CalendarState,
    fillingSessionState: DrinkingSession,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
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
                onCalendarEvent = onCalendarEvent,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateToCategoryScreen = { navController.navigate(CalendarScreen.ChooseCategory.name) },
                navigateToYear = { navController.navigate(CalendarScreen.YearView.name) },
                modifier = modifier
            )
        }
        composable(route = CalendarScreen.YearView.name) {
            YearLayout(
                calendarState = calendarState,
                onCalendarEvent = onCalendarEvent,
                navigateToYear = { navController.navigate(CalendarScreen.MonthView.name) },
                modifier = modifier,
            )
        }
        composable(route = CalendarScreen.ChooseCategory.name) {
            ChooseCategoryScreen(
                fillingSessionState = fillingSessionState,
                onFillingSessionEvent = onFillingSessionEvent,
                onCalendarEvent = onCalendarEvent,
                onBeerClick = { navController.navigate(CalendarScreen.AddBeer.name) },
                onWineClick = { navController.navigate(CalendarScreen.AddWine.name) },
                onSpiritsClick = { navController.navigate(CalendarScreen.AddSpirits.name) },
                onOtherClick = { navController.navigate(CalendarScreen.AddOther.name) },
                navigateBack = { navController.navigateUp() },
            )
        }
        composable(route = CalendarScreen.AddBeer.name) {
            AddBeerScreen(
                fillingSessionState = fillingSessionState,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateBack = { navController.navigateUp() }
            )
        }
//        composable(route = CalendarScreen.AddWine.name) {
//            AddWineScreen(
//                onFillingSessionEvent = onFillingSessionEvent,
//                navigateBack = { navController.navigateUp() },
//            )
//        }
//        composable(route = CalendarScreen.AddSpirits.name) {
//            AddSpiritsScreen(
//                onFillingSessionEvent = onFillingSessionEvent,
//                navigateBack = { navController.navigateUp() },
//            )
//        }
//        composable(route = CalendarScreen.AddOther.name) {
//            AddOtherScreen(
//                onFillingSessionEvent = onFillingSessionEvent,
//                navigateBack = { navController.navigateUp() },
//            )
//        }
    }
}
