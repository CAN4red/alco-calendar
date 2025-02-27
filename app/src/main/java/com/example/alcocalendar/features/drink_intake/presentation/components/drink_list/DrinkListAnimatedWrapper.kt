package com.example.alcocalendar.features.drink_intake.presentation.components.drink_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeEvent

@Composable
inline fun <reified T> DrinkListAnimatedWrapper(
    crossinline onEvent: (DrinkIntakeEvent) -> Unit,
    isListExpanded: Boolean,
    modifier: Modifier = Modifier
) where T : Enum<T>, T : DrinkType {
    val density = LocalDensity.current

    AnimatedVisibility(
        visible = isListExpanded,
        enter = slideInVertically { with(density) { -40.dp.roundToPx() } } +
                expandVertically(expandFrom = Alignment.Top) +
                fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        modifier = modifier
    ) {
        DrinkList<T>(onEvent = onEvent)
    }
}