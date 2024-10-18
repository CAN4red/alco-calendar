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
import androidx.navigation.compose.rememberNavController
import com.example.alcocalendar.viewmodel.CalendarViewModel
import com.example.alcocalendar.ui.theme.AlcoCalendarTheme


class MainActivity : ComponentActivity() {

    private val viewModel: CalendarViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val calendarState by viewModel.calendarState.collectAsState()

            AlcoCalendarTheme {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    AlcoCalendarApp(
                        calendarState = calendarState,
                        onCalendarEvent = viewModel::onCalendarEvent,
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
