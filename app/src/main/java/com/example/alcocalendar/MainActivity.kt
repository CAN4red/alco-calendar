package com.example.alcocalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.alcocalendar.data.local.database.DrinkingSessionDatabase
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.data.local.entities.TotalIntake
import com.example.alcocalendar.data.local.entities.drinks.DrinkIntakeEntity
import com.example.alcocalendar.data.local.entities.drinks.types.BeerType
import com.example.alcocalendar.data.local.entities.intakes.beer.LightIntake
import com.example.alcocalendar.data.local.entities.intakes.beer.TotalBeerIntake
import com.example.alcocalendar.ui.theme.AlcoCalendarTheme
import kotlinx.coroutines.launch
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val dao = DrinkingSessionDatabase.getInstance(this).drinkingSessionDao

        lifecycleScope.launch {
            dao.insertDrinkingSession(DrinkingSessionEntity(LocalDate.now()))
            dao.deleteDrinkIntake(DrinkIntakeEntity(
                date = LocalDate.now(),
                drinkType = BeerType.LIGHT,
                liters = 1.0,
            ))
        }

        enableEdgeToEdge()
        setContent {
            AlcoCalendarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlcoCalendarTheme {
        Greeting("Android")
    }
}