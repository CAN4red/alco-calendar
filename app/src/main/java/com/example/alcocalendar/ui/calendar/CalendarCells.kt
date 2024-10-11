package com.example.alcocalendar.ui.calendar


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import java.time.format.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.model.DrinkingSessionModel
import com.example.alcocalendar.viewmodel.CalendarEvent
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@SuppressLint("NewApi")
private fun LocalDate.formatToStringDay(): String {
    val formatter = DateTimeFormatter.ofPattern("d", Locale.getDefault())
    return this.format(formatter)
}

@SuppressLint("NewApi")
@Composable
fun DateCell(
    session: DrinkingSessionModel,
    signal: Boolean,
    onEvent: (CalendarEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val day = session.date.formatToStringDay()

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .background(
                shape = RoundedCornerShape(CornerSize(8.dp)),
                color = lightColorScheme().secondaryContainer
            )
            .clip(RoundedCornerShape(CornerSize(8.dp)))
            .clickable(onClick = { onEvent(CalendarEvent.OnDateClick) })
    ) {
        if (signal) {
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(8.dp)
                    .background(
                        shape = CircleShape,
                        color = lightColorScheme().tertiaryContainer.copy(alpha = 0.7f)
                    )
            )
        }
        Text(
            text = day,
            color = lightColorScheme().onSecondaryContainer,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Composable
fun SmallDateCell(
    session: DrinkingSessionModel,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .background(
                shape = CircleShape,
                color = lightColorScheme().tertiaryContainer.copy(alpha = 0.7f)
            )
            .clip(CircleShape)
    )
}

@Composable
fun EmptyCell(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .background(
                color = Color.Transparent
            )
            .clip(RectangleShape)
    ) {}
}

@SuppressLint("NewApi")
@Composable
fun WeekdayCell(
    weekday: Int,
    modifier: Modifier = Modifier,
) {
    val text = getDayOfWeekAbbreviation(
        day = weekday,
        month = LocalDate.now().monthValue,
        year = LocalDate.now().year,
        language = "en"
    )

    Box(
        modifier = modifier
            .aspectRatio(4 / 3f)
            .padding(2.dp)
            .background(color = lightColorScheme().onPrimaryContainer)
    ) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@SuppressLint("NewApi")
fun getDayOfWeekAbbreviation(
    day: Int,
    month: Int,
    year: Int,
    language: String,
): String {
    val date = LocalDate.of(year, month, day)
    val dayOfWeek = date.dayOfWeek

    val locale = when (language.lowercase()) {
        "ru" -> Locale("ru", "RU")
        "en" -> Locale("en", "US")
        else -> Locale.getDefault()
    }

    return dayOfWeek.getDisplayName(TextStyle.SHORT, locale).uppercase()
}

@SuppressLint("NewApi")
@Preview
@Composable
fun DateCellPreview() {
    DateCell(
        session = DrinkingSessionModel(LocalDate.now()),
        signal = false,
        onEvent = { }
    )
}

@SuppressLint("NewApi")
@Preview
@Composable
fun WeekdayCellPreview() {
    WeekdayCell(weekday = 2)
}

@SuppressLint("NewApi")
@Preview
@Composable
fun SmallDateCellPreview() {
    SmallDateCell(session = DrinkingSessionModel(LocalDate.now()))
}
