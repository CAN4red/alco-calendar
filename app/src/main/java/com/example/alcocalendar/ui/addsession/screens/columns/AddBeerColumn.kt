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
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.BeerIntake
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.DrinkButtonData
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddBeerColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (Beer) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val drinkButtons = getBeerButtonsData(
        beerIntake = fillingSessionState.beerIntake,
        onDrinkButtonClick = onDrinkButtonClick,
    )
    AddDrinkColumn(
        addDrinkButtons = drinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

private fun getBeerButtonsData(
    beerIntake: BeerIntake,
    onDrinkButtonClick: (Beer) -> Unit
): List<DrinkButtonData> {
    return listOf(
        DrinkButtonData("Light", Color.Black, DrinkColor.BeerLight) {
            onDrinkButtonClick(beerIntake.light)
        },
        DrinkButtonData("Dark", Color.White, DrinkColor.BeerDark) {
            onDrinkButtonClick(beerIntake.dark)
        },
        DrinkButtonData("Cider", Color.Black, DrinkColor.BeerCider) {
            onDrinkButtonClick(beerIntake.cider)
        },
        DrinkButtonData("Unfiltered", Color.Black, DrinkColor.BeerUnfiltered) {
            onDrinkButtonClick(beerIntake.unfiltered)
        },
        DrinkButtonData("El", Color.Black, DrinkColor.BeerEl) {
            onDrinkButtonClick(beerIntake.el)
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun AddBeerScreenPreview() {
    AddBeerColumn(
        fillingSessionState = DrinkingSessionDb(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
