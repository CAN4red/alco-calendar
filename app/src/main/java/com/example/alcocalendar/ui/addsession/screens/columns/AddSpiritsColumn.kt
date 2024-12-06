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
import com.example.alcocalendar.ui.addsession.components.getAddDrinkButtonComposable
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddSpiritsColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (Spirits) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val addDrinkButtons = listOf(
        getAddDrinkButtonComposable(
            title = "Vodka",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsVodka,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.vodka) },
        ),
        getAddDrinkButtonComposable(
            title = "Whiskey",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsWhiskey,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.whiskey) },
        ),
        getAddDrinkButtonComposable(
            title = "Cognac",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsCognac,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.cognac) },
        ),
        getAddDrinkButtonComposable(
            title = "Rum",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsRum,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.rum) },
        ),
        getAddDrinkButtonComposable(
            title = "Tequila",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsTequila,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.tequila) },
        ),
        getAddDrinkButtonComposable(
            title = "Gin",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsGin,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.gin) },
        ),
        getAddDrinkButtonComposable(
            title = "Absinthe",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsAbsinthe,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.absinthe) },
        ),
        getAddDrinkButtonComposable(
            title = "Liquor",
            titleColor = Color(0xFFFC510E),
            backgroundColor = DrinkColor.SpiritsLiquor,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.liquor) },
        ),
        getAddDrinkButtonComposable(
            title = "Brandy",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsBrandy,
            onClick = { onDrinkButtonClick(fillingSessionState.spiritsIntake.brandy) },
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
private fun AddSpiritsScreenPreview() {
    AddSpiritsColumn(
        fillingSessionState = DrinkingSession(LocalDate.now()),
        onDrinkButtonClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
