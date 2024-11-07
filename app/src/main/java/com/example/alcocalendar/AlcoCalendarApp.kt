package com.example.alcocalendar

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.ui.calendar.month.MonthLayout
import com.example.alcocalendar.ui.calendar.viewmodel.events.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.events.SessionFillingEvent
import com.example.alcocalendar.ui.calendar.viewmodel.states.CalendarState
import com.example.alcocalendar.ui.calendar.year.YearLayout
import com.example.alcocalendar.ui.navigation.CalendarScreen


@Composable
fun AlcoCalendarApp(
    calendarState: CalendarState,
    fillingSessionState: DrinkingSession,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onSessionFillingEvent: (SessionFillingEvent) -> Unit,
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
    }
//    if (calendarState.isShowingSessionEditMenu) {
//        ModalBottomSheet(onDismissRequest = {
//            onSessionFillingEvent(SessionFillingEvent.DismissSession)
//        }) {
//            Column {
//                Row {
//                    Button(onClick = {
//                        onSessionFillingEvent(
//                            SessionFillingEvent.AddBeerDrink(
//                                Light(liters = 1.0)
//                            )
//                        )
//                    }) {
//                        Text(text = "Light")
//                    }
//                }
//            }
//        }
//    }
}
