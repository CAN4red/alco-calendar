package com.example.alcocalendar.ui.addsession.screens.columns

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.Spirits
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.DrinkButtonData
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddSpiritsColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (Spirits) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val drinkButtons = listOf(
        DrinkButtonData("Vodka", Color.Black, DrinkColor.SpiritsVodka) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.vodka)
        },
        DrinkButtonData("Whiskey", Color.Black, DrinkColor.SpiritsWhiskey) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.whiskey)
        },
        DrinkButtonData("Cognac", Color.Black, DrinkColor.SpiritsCognac) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.cognac)
        },
        DrinkButtonData("Rum", Color.Black, DrinkColor.SpiritsRum) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.rum)
        },
        DrinkButtonData("Tequila", Color.Black, DrinkColor.SpiritsTequila) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.tequila)
        },
        DrinkButtonData("Gin", Color.Black, DrinkColor.SpiritsGin) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.gin)
        },
        DrinkButtonData("Absinthe", Color.Black, DrinkColor.SpiritsAbsinthe) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.absinthe)
        },
        DrinkButtonData("Liquor", Color(0xFFFC510E), DrinkColor.SpiritsLiquor) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.liquor)
        },
        DrinkButtonData("Brandy", Color.Black, DrinkColor.SpiritsBrandy) {
            onDrinkButtonClick(fillingSessionState.spiritsIntake.brandy)
        }
    )

    AddDrinkColumn(
        addDrinkButtons = drinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun AddSpiritsScreenPreview() {
    AddSpiritsColumn(
        fillingSessionState = DrinkingSession(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
