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
import com.example.alcocalendar.db.entities.intakes.Wine
import com.example.alcocalendar.db.entities.intakes.WineIntake
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.DrinkButtonData
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddWineColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (Wine) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val drinkButtons = getWineButtonsData(
        wineIntake = fillingSessionState.wineIntake,
        onDrinkButtonClick = onDrinkButtonClick,
    )
    AddDrinkColumn(
        addDrinkButtons = drinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

private fun getWineButtonsData(
    wineIntake: WineIntake,
    onDrinkButtonClick: (Wine) -> Unit
): List<DrinkButtonData> {
    return listOf(
        DrinkButtonData("Red", Color.White, DrinkColor.WineRed) {
            onDrinkButtonClick(wineIntake.red)
        },
        DrinkButtonData("White", Color.Black, DrinkColor.WineWhite) {
            onDrinkButtonClick(wineIntake.white)
        },
        DrinkButtonData("Champagne", Color.Black, DrinkColor.WineChampagne) {
            onDrinkButtonClick(wineIntake.champagne)
        },
        DrinkButtonData("Rose", Color.Black, DrinkColor.WineRose) {
            onDrinkButtonClick(wineIntake.rose)
        },
        DrinkButtonData("Port", Color.White, DrinkColor.WinePort) {
            onDrinkButtonClick(wineIntake.port)
        },
        DrinkButtonData("Vermouth", Color.Black, DrinkColor.WineVermouth) {
            onDrinkButtonClick(wineIntake.vermouth)
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun AddWineScreenPreview() {
    AddWineColumn(
        fillingSessionState = DrinkingSessionDb(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
