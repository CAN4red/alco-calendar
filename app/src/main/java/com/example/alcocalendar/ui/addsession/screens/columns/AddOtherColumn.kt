package com.example.alcocalendar.ui.addsession.screens.columns

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import com.example.alcocalendar.db.entities.intakes.OtherDrink
import com.example.alcocalendar.db.entities.intakes.OtherIntake
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.DrinkButtonData
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddOtherColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (OtherDrink) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val drinkButtons = getOtherDrinkButtonsData(
        otherIntake = fillingSessionState.otherIntake,
        onDrinkButtonClick = onDrinkButtonClick,
    )
    AddDrinkColumn(
        addDrinkButtons = drinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

private fun getOtherDrinkButtonsData(
    otherIntake: OtherIntake,
    onDrinkButtonClick: (OtherDrink) -> Unit
): List<DrinkButtonData> {
    return listOf(
        DrinkButtonData("Cocktails", Color.White, DrinkColor.OtherCocktails) {
            onDrinkButtonClick(otherIntake.cocktails)
        },
        DrinkButtonData("Shots", Color.Black, DrinkColor.OtherShots) {
            onDrinkButtonClick(otherIntake.shots)
        },
        DrinkButtonData("Moonshine", Color.Black, DrinkColor.OtherMoonshine) {
            onDrinkButtonClick(otherIntake.moonshine)
        },
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun AddOtherScreenPreview() {
    AddOtherColumn(
        fillingSessionState = DrinkingSessionDb(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}