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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.alcocalendar.db.DrinkingSessionDatabase
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.BeerIntake
import com.example.alcocalendar.db.entities.intakes.Cider
import com.example.alcocalendar.db.entities.intakes.Light
import com.example.alcocalendar.db.entities.intakes.SpiritsIntake
import com.example.alcocalendar.db.entities.intakes.Vodka
import com.example.alcocalendar.viewmodel.CalendarViewModel
import com.example.alcocalendar.ui.theme.AlcoCalendarTheme
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Month


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = DrinkingSessionDatabase.getInstance(this).drinkingSessionsDao
        val viewModel: CalendarViewModel by viewModels {
            object : ViewModelProvider.Factory {
                @RequiresApi(Build.VERSION_CODES.O)
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CalendarViewModel(dao) as T
                }
            }
        }

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
