package com.example.alcocalendar.ui.addsession.screens.columns

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.Wine
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.getAddDrinkButtonComposable
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddWineColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (Wine) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val addDrinkButtons = listOf(
        getAddDrinkButtonComposable(
            title = "Red",
            titleColor = Color.White,
            backgroundColor = DrinkColor.WineRed,
            onClick = { onDrinkButtonClick(fillingSessionState.wineIntake.red) },
        ),
        getAddDrinkButtonComposable(
            title = "White",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineWhite,
            onClick = { onDrinkButtonClick(fillingSessionState.wineIntake.white) },
        ),
        getAddDrinkButtonComposable(
            title = "Champagne",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineChampagne,
            onClick = { onDrinkButtonClick(fillingSessionState.wineIntake.champagne) },
        ),
        getAddDrinkButtonComposable(
            title = "Rose",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineRose,
            onClick = { onDrinkButtonClick(fillingSessionState.wineIntake.rose) },
        ),
        getAddDrinkButtonComposable(
            title = "Port",
            titleColor = Color.White,
            backgroundColor = DrinkColor.WinePort,
            onClick = { onDrinkButtonClick(fillingSessionState.wineIntake.port) },
        ),
        getAddDrinkButtonComposable(
            title = "Vermouth",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineVermouth,
            onClick = { onDrinkButtonClick(fillingSessionState.wineIntake.vermouth) },
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
private fun AddWineScreenPreview() {
    AddWineColumn(
        fillingSessionState = DrinkingSession(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
