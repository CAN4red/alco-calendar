package com.example.alcocalendar.features.calendar.presentation.month_appearance.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun MonthTitleWithNavigation(
    month: YearMonth,
    scrollToPrevMonth: suspend () -> Unit,
    scrollToNextMonth: suspend () -> Unit,
    navigateToYearCalendar: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { coroutineScope.launch { scrollToPrevMonth() } }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Left Arrow"
            )
        }

        MonthTitle(month, navigateToYearCalendar)

        IconButton(onClick = { coroutineScope.launch { scrollToNextMonth() } }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Right Arrow"
            )
        }
    }
}

@Composable
private fun MonthTitle(
    month: YearMonth,
    navigateToYearCalendar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = month.month.getDisplayName(TextStyle.FULL, Locale.getDefault()),
        textAlign = TextAlign.Center,
        modifier = modifier.clickable { navigateToYearCalendar() }
    )
}


@Preview
@Composable
private fun MonthTitleWithNavigationPreview() {
    MonthTitleWithNavigation(
        month = YearMonth.now(),
        scrollToPrevMonth = {},
        scrollToNextMonth = {},
        navigateToYearCalendar = {},
    )
}