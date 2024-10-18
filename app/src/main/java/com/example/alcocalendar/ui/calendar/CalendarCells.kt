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
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.viewmodel.events.CalendarEvent
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@SuppressLint("NewApi")
@Composable
fun DateCell(
    session: DrinkingSession,
    onCalendarEvent: (CalendarEvent) -> Unit,
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
            .clickable(onClick = { onCalendarEvent(CalendarEvent.OnDateClick) })
    ) {
        Text(
            text = day,
            color = lightColorScheme().onSecondaryContainer,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}


@SuppressLint("NewApi")
private fun LocalDate.formatToStringDay(): String {
    val formatter = DateTimeFormatter.ofPattern("d", Locale.getDefault())
    return this.format(formatter)
}


@Composable
fun SmallDateCell(
    session: DrinkingSession,
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
    dayOfWeek: DayOfWeek,
    modifier: Modifier = Modifier,
) {
    val text = getDayOfWeekAbbreviation(
        dayOfWeek = dayOfWeek,
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
    dayOfWeek: DayOfWeek,
    language: String,
): String {
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
        session = DrinkingSession(LocalDate.now()),
        onCalendarEvent = { }
    )
}


@SuppressLint("NewApi")
@Preview
@Composable
fun WeekdayCellPreview() {
    WeekdayCell(dayOfWeek = DayOfWeek.of(1))
}


@SuppressLint("NewApi")
@Preview
@Composable
fun SmallDateCellPreview() {
    SmallDateCell(session = DrinkingSession(LocalDate.now()))
}
