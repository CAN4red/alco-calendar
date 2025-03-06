package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import java.time.LocalDate

@Composable
fun NotesTextField(
    state: Note,
    onEvent: (NotesEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val textFieldValue by remember {
        mutableStateOf(
            TextFieldValue(
                text = state.content,
                selection = TextRange(state.content.length)
            )
        )
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    var isFocused by remember { mutableStateOf(false) }

    BackHandler(enabled = isFocused) { keyboardController?.hide() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        BasicTextField(
            value = textFieldValue,
            onValueChange = { newValue ->
                onEvent(NotesEvent.SetNoteContent(newValue.text))
            },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState -> isFocused = focusState.isFocused }

        )
    }
}

@Preview
@Composable
private fun NotesTextFieldPreview() {
    NotesTextField(
        state = Note(
            date = LocalDate.now(),
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
        ),
        onEvent = {},
        modifier = Modifier.fillMaxWidth()
    )
}