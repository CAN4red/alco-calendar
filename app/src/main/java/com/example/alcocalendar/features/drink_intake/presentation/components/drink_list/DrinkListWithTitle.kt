package com.example.alcocalendar.features.drink_intake.presentation.components.drink_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.core.data.local.entities.drink_types.WineType
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.drink_intake.presentation.utils.DrinkTypeToStringMapper.headlineName

@Composable
inline fun <reified T> DrinkListWithTitle(
    crossinline onEvent: (DrinkIntakeEvent) -> Unit,
    isListExpanded: Boolean,
    modifier: Modifier = Modifier
) where T : Enum<T>, T : DrinkType {

    val onHeadlineClick = {
        val expandedDrinkType = if (isListExpanded) null else T::class.java
        onEvent(DrinkIntakeEvent.SetExpandedIntake(expandedDrinkType))
    }

    Column(modifier = modifier.fillMaxWidth()) {
        DrinkListHeadline(
            headline = headlineName<T>(),
            onClick = onHeadlineClick,
            isListExpanded = isListExpanded,
        )
        DrinkListAnimatedWrapper<T>(
            onEvent = onEvent,
            isListExpanded = isListExpanded,
        )
    }
}

@Preview
@Composable
private fun DrinkListWithTitlePreview() {
    DrinkListWithTitle<WineType>(
        onEvent = {},
        isListExpanded = true,
    )
}