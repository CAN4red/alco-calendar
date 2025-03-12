package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent

@Composable
fun SaveNoteButton(
    onEvent: (NotesEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = Icons.Default.Check,
        contentDescription = stringResource(R.string.save_note_button),
        tint = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .clickable(
                onClick = {
                    onEvent(NotesEvent.SaveNote)
                    onEvent(NotesEvent.CollapseNote)
                }
            )
            .padding(4.dp)
    )

}

@Preview
@Composable
private fun SaveNoteButtonPreview() {
    SaveNoteButton(
//        state = NotesState(),
        onEvent = {}
    )
}