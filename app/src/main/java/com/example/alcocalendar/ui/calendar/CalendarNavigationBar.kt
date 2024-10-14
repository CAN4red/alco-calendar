package com.example.alcocalendar.ui.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
