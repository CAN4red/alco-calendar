package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = getIndicatorColor(pagerState, iteration)
            Box(
                modifier = Modifier
                    .padding(3.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)
            )
        }
    }
}

@Composable
private fun getIndicatorColor(pagerState: PagerState, iteration: Int): Color {
    return if (pagerState.currentPage == iteration) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    }
}