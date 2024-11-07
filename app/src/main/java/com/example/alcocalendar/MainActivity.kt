package com.example.alcocalendar

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.alcocalendar.db.DrinkingSessionDatabase
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionViewModel
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarViewModel
import com.example.alcocalendar.ui.theme.AlcoCalendarTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = DrinkingSessionDatabase.getInstance(this).drinkingSessionsDao
        val calendarViewModel: CalendarViewModel by viewModels {
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CalendarViewModel(dao) as T
                }
            }
        }
        val fillingSessionViewModel: FillingSessionViewModel by viewModels {
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T: ViewModel> create(modelClass: Class<T>): T {
                    return FillingSessionViewModel(dao) as T
                }
            }
        }

        enableEdgeToEdge()

        setContent {
            val calendarState by calendarViewModel.calendarState.collectAsState()
            val fillingSessionState by fillingSessionViewModel.fillingSessionState.collectAsState()

            AlcoCalendarTheme {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    AlcoCalendarApp(
                        calendarState = calendarState,
                        fillingSessionState = fillingSessionState,
                        onCalendarEvent = calendarViewModel::onCalendarEvent,
                        onSessionFillingEvent = fillingSessionViewModel::onSessionFillingEvent,
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
