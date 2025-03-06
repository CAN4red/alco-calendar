package com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.date_title

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeState
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.Formatter.formatDayMonth

@Composable
fun DateTitle(
    state: DrinkIntakeState,
    modifier: Modifier = Modifier
) {
    val date = state.date

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = date.formatDayMonth(LocalContext.current),
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = date.year.toString(),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Preview
@Composable
private fun DateTitlePreview() {
    DateTitle(
        state = DrinkIntakeState()
    )
}