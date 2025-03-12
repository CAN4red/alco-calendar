package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R

@Composable
fun NotesTitle(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.notes_title),
            style = MaterialTheme.typography.headlineMedium,
        )

        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.32f),
            modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
        )
    }
}
