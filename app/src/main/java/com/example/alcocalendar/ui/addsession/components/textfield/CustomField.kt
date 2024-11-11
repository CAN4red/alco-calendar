package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomField(
    textValue: String,
    modifier: Modifier = Modifier
) {
    val displayedTextValue = textValue.ifEmpty { "0" }

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .size(312.dp, 50.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 3.dp,
                color = Color.Black,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .horizontalScroll(
                    state = rememberScrollState(),
                    reverseScrolling = true
                )
        ) {
            Text(
                text = "$displayedTextValue L",
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(2.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}