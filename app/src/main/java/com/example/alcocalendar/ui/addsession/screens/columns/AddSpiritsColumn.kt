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
import com.example.alcocalendar.db.entities.intakes.Spirits
import com.example.alcocalendar.db.entities.intakes.SpiritsIntake
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
    val drinkButtons = getSpiritsButtonsData(
        spiritsIntake = fillingSessionState.spiritsIntake,
        onDrinkButtonClick = onDrinkButtonClick,
    )
    AddDrinkColumn(
        addDrinkButtons = drinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

private fun getSpiritsButtonsData(
    spiritsIntake: SpiritsIntake,
    onDrinkButtonClick: (Spirits) -> Unit
): List<DrinkButtonData> {
    return listOf(
        DrinkButtonData("Vodka", Color.Black, DrinkColor.SpiritsVodka) {
            onDrinkButtonClick(spiritsIntake.vodka)
        },
        DrinkButtonData("Whiskey", Color.Black, DrinkColor.SpiritsWhiskey) {
            onDrinkButtonClick(spiritsIntake.whiskey)
        },
        DrinkButtonData("Cognac", Color.Black, DrinkColor.SpiritsCognac) {
            onDrinkButtonClick(spiritsIntake.cognac)
        },
        DrinkButtonData("Rum", Color.Black, DrinkColor.SpiritsRum) {
            onDrinkButtonClick(spiritsIntake.rum)
        },
        DrinkButtonData("Tequila", Color.Black, DrinkColor.SpiritsTequila) {
            onDrinkButtonClick(spiritsIntake.tequila)
        },
        DrinkButtonData("Gin", Color.Black, DrinkColor.SpiritsGin) {
            onDrinkButtonClick(spiritsIntake.gin)
        },
        DrinkButtonData("Absinthe", Color.Black, DrinkColor.SpiritsAbsinthe) {
            onDrinkButtonClick(spiritsIntake.absinthe)
        },
        DrinkButtonData("Liquor", Color(0xFFFC510E), DrinkColor.SpiritsLiquor) {
            onDrinkButtonClick(spiritsIntake.liquor)
        },
        DrinkButtonData("Brandy", Color.Black, DrinkColor.SpiritsBrandy) {
            onDrinkButtonClick(spiritsIntake.brandy)
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun AddSpiritsScreenPreview() {
    AddSpiritsColumn(
        fillingSessionState = DrinkingSessionDb(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
