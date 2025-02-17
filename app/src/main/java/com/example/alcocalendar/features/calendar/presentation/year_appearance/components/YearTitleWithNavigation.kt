package com.example.alcocalendar.features.calendar.presentation.year_appearance.components

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
import java.time.Year

@Composable
fun YearTitleWithNavigation(
    year: Year,
    scrollToPrevYear: suspend () -> Unit,
    scrollToNextYear: suspend () -> Unit,
    navigateToMonthCalendar: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { coroutineScope.launch { scrollToPrevYear() } }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Left Arrow"
            )
        }

        YearTitle(year, navigateToMonthCalendar)

        IconButton(onClick = { coroutineScope.launch { scrollToNextYear() } }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Right Arrow"
            )
        }
    }
}

@Composable
private fun YearTitle(
    year: Year,
    navigateToMonthCalendar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = year.toString(),
        textAlign = TextAlign.Center,
        modifier = modifier.clickable { navigateToMonthCalendar() }
    )
}


@Preview
@Composable
private fun MonthTitleWithNavigationPreview() {
    YearTitleWithNavigation(
        year = Year.now(),
        scrollToPrevYear = {},
        scrollToNextYear = {},
        navigateToMonthCalendar = {}
    )
}