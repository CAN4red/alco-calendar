package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R

@Composable
fun NotesField(
    onClick: () -> Unit,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = getMinNotesSize())
            .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
            .background(MaterialTheme.colorScheme.surface)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .padding(12.dp)
    ) {
        NotesTitle()
        Text(
            text = content.ifBlank { stringResource(R.string.default_note) },
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}

@Composable
fun getMinNotesSize(): Dp {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    return (screenHeight * 0.24).dp
}

@Preview
@Composable
private fun NotesFieldPreview() {
    NotesField(
        onClick = {},
        content = "Lorem Ipsum is simply dummy text of" +
                "the printing and typesetting industry." +
                "Lorem Ipsum has been the industry's" +
                "standard dummy text ever since the" +
                "1500s, when an unknown printer took a" +
                "galley of type and scrambled it to make a" +
                "type specimen book. \n" +
                "\n" +
                "It has survived not only five centuries," +
                "but also the leap into electronic" +
                "typesetting, remaining essentially..."
    )
}