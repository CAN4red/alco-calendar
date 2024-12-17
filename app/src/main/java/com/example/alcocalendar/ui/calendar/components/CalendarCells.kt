package com.example.alcocalendar.ui.calendar.components


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import com.example.alcocalendar.model.DrinkingSessionWrapper
import com.example.alcocalendar.model.SessionOrder
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateCell(
    session: DrinkingSessionWrapper,
    onClick: (LocalDate) -> Unit,
    modifier: Modifier = Modifier,
) {
    val day = session.date.formatToStringDay()
    val color = getCellColor(session)
    val shape = getCellShape(session)

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp)
            .background(
                shape = shape,
                color = color
            )
            .clip(shape)
            .clickable(onClick = { onClick(session.date) })
    ) {
        Text(
            text = day,
            style = MaterialTheme.typography.bodyLarge,
            color = lightColorScheme().onSecondaryContainer,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

private fun getCellColor(session: DrinkingSession): Color {
    return when (session.isEmpty) {
        true -> Color.Transparent
        false -> Color.Red
    }
}

private fun getCellShape(session: DrinkingSessionWrapper): RoundedCornerShape {
    return when (session.sessionOrder) {
        SessionOrder.SINGLE_SESSION -> CircleShape
        SessionOrder.FIRST_IN_ROW -> RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp)
        SessionOrder.MIDDLE_IN_ROW -> RoundedCornerShape(0.dp)
        SessionOrder.LAST_IN_ROW -> RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp)
        SessionOrder.EMPTY_SESSION -> CircleShape
    }

}

@RequiresApi(Build.VERSION_CODES.O)
private fun LocalDate.formatToStringDay(): String {
    val formatter = DateTimeFormatter.ofPattern("d", Locale.getDefault())
    return this.format(formatter)
}


@Composable
fun SmallDateCell(
    session: DrinkingSession,
    modifier: Modifier = Modifier,
) {
    val color = if (session.isEmpty)
        lightColorScheme().secondaryContainer.copy(alpha = 0.7f)
    else
        Color.Red

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .background(
                shape = CircleShape,
                color = color
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
            style = MaterialTheme.typography.bodyLarge,
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

    return dayOfWeek.getDisplayName(TextStyle.NARROW, locale).uppercase()
}


@SuppressLint("NewApi")
@Preview
@Composable
fun DateCellPreview() {
    DateCell(
        session = DrinkingSessionWrapper(DrinkingSessionDb(LocalDate.now())),
        onClick = {}
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
    SmallDateCell(session = DrinkingSessionDb(LocalDate.now()))
}
