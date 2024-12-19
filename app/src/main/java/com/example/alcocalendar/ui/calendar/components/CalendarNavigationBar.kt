package com.example.alcocalendar.ui.calendar.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


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
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        NavigationButton(
            enabled = enabledPrev,
            onClick = { coroutineScope.launch { onBackNavigationClick() } },
            icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back",
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        TextButton(onClick = onTitleClick) {
            Text(
                text = titleString,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        NavigationButton(
            enabled = enabledNext,
            onClick = { coroutineScope.launch { onForwardNavigationClick() } },
            icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Forward",
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}


@Composable
private fun NavigationButton(
    enabled: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    IconButton(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
private fun CalendarNavigationBarPreview() {
    CalendarNavigationBar(
        titleString = "December 2024",
        onTitleClick = { },
        enabledPrev = true,
        enabledNext = true,
        onBackNavigationClick = { }
    ) {

    }
}
