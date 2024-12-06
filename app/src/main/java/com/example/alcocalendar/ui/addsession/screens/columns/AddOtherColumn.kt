package com.example.alcocalendar.ui.addsession.screens.columns

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.OtherDrink
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.getAddDrinkButtonComposable
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddOtherColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (OtherDrink) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val addDrinkButtons = listOf(
        getAddDrinkButtonComposable(
            title = "Cocktails",
            titleColor = Color.White,
            backgroundColor = DrinkColor.OtherCocktails,
            onClick = { onDrinkButtonClick(fillingSessionState.otherIntake.cocktails) },
        ),
        getAddDrinkButtonComposable(
            title = "Shots",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.OtherShots,
            onClick = { onDrinkButtonClick(fillingSessionState.otherIntake.shots) },
        ),
        getAddDrinkButtonComposable(
            title = "Moonshine",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.OtherMoonshine,
            onClick = { onDrinkButtonClick(fillingSessionState.otherIntake.moonshine) },
        ),
    )

    AddDrinkColumn(
        addDrinkButtons = addDrinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun AddOtherScreenPreview() {
    AddOtherColumn(
        fillingSessionState = DrinkingSession(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}