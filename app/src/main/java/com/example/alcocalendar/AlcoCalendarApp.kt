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
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import com.example.alcocalendar.ui.addsession.screens.AddBeerScreen
import com.example.alcocalendar.ui.addsession.screens.AddOtherScreen
import com.example.alcocalendar.ui.addsession.screens.AddSpiritsScreen
import com.example.alcocalendar.ui.addsession.screens.AddWineScreen
import com.example.alcocalendar.ui.addsession.screens.category.ChooseCategoryScreen
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.CalendarScreen
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.navigation.Screen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlcoCalendarApp(
    calendarState: CalendarState,
    fillingSessionState: DrinkingSessionDb,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navController: NavHostController = rememberNavController(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Calendar.name,
        modifier = modifier
    ) {
        composable(route = Screen.Calendar.name) {
            CalendarScreen(
                calendarState = calendarState,
                onCalendarEvent = onCalendarEvent,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateToCategoryScreen = { navController.navigate(Screen.ChooseCategory.name) }
            )
        }
        composable(route = Screen.ChooseCategory.name) {
            ChooseCategoryScreen(
                fillingSessionState = fillingSessionState,
                onFillingSessionEvent = onFillingSessionEvent,
                onCalendarEvent = onCalendarEvent,
                onBeerClick = { navController.navigate(Screen.AddBeer.name) },
                onWineClick = { navController.navigate(Screen.AddWine.name) },
                onSpiritsClick = { navController.navigate(Screen.AddSpirits.name) },
                onOtherClick = { navController.navigate(Screen.AddOther.name) },
                navigateBack = { navController.navigateUp() },
            )
        }
        composable(route = Screen.AddBeer.name) {
            AddBeerScreen(
                fillingSessionState = fillingSessionState,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = Screen.AddWine.name) {
            AddWineScreen(
                fillingSessionState = fillingSessionState,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = Screen.AddSpirits.name) {
            AddSpiritsScreen(
                fillingSessionState = fillingSessionState,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = Screen.AddOther.name) {
            AddOtherScreen(
                fillingSessionState = fillingSessionState,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}
