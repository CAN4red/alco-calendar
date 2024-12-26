package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextFieldButton(
    onClick: () -> Unit,
    color: Color,
    buttonContent: @Composable (Modifier) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .aspectRatio(1f)
            .background(color = color, shape = CircleShape)
            .clickable(onClick = onClick)
    ) {
        buttonContent(
            Modifier
                .aspectRatio(1f)
                .padding(4.dp))
    }
}

@Composable
@Preview
private fun CustomTextFieldButtonPreview() {
    CustomTextFieldButton(
        onClick = {},
        color = MaterialTheme.colorScheme.surface,
        buttonContent = {
            Text("1")
        },
        modifier = Modifier.fillMaxSize()
    )
}