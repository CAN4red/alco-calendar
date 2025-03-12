package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Text(
            text = stringResource(R.string.notes_title),
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(Modifier.size(6.dp))

        Text(
            text = content,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
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