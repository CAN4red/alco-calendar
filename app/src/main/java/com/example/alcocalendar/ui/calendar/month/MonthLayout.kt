package com.example.alcocalendar.ui.calendar.month

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alcocalendar.ui.model.structure.CalendarEvent
import com.example.alcocalendar.ui.model.structure.CalendarState
import kotlinx.coroutines.launch

@SuppressLint("NewApi")
@Composable
fun MonthLayout(
    calendarState: CalendarState,
    onEvent: (CalendarEvent) -> Unit,
    navigateToYear: () -> Unit,
    startFromSunday: Boolean,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(
        initialPage = calendarState.currentMonthIndex,
        pageCount = { calendarState.monthsCount }
    )

    val month = calendarState.getMonthByIndex(pagerState.currentPage).month
    val year = calendarState.getMonthByIndex(pagerState.currentPage).year
    val titleString = "$month $year"

    Column(
        modifier = modifier,
    ) {
        CalendarNavigationBar(
            titleString = titleString,
            onTitleClick = navigateToYear,
            enabledPrev = calendarState.hasPrevMonth(),
            enabledNext = calendarState.hasNextMonth(),
            onBackNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            },
            onForwardNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            },
        )

        MonthPager(
            calendarState = calendarState,
            pagerState = pagerState,
            startFromSunday = startFromSunday,
            onEvent = onEvent,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CalendarNavigationBar(
    titleString: String,
    onTitleClick: () -> Unit,
    enabledPrev: Boolean,
    enabledNext: Boolean,
    onBackNavigationClick: suspend () -> Unit,
    onForwardNavigationClick: suspend () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        NavigationButton(
            enabled = enabledPrev,
            onClick = { coroutineScope.launch { onBackNavigationClick() } },
            icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back"
        )

        TextButton(onClick = onTitleClick) {
            Text(
                text = titleString,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        NavigationButton(
            enabled = enabledNext,
            onClick = { coroutineScope.launch { onForwardNavigationClick() } },
            icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Forward"
        )
    }
}

@Composable
fun NavigationButton(
    enabled: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String
) {
    IconButton(
        enabled = enabled,
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}


//@Preview
//@Composable
//@RequiresApi(Build.VERSION_CODES.O)
//fun MonthLayoutPreview() {
//    MonthLayout(
//        onClick = {},
//        onTitleClick = {},
//        startFromSunday = false
//    )
//}