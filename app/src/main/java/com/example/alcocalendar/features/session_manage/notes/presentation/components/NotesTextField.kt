package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState
import java.time.LocalDate

@Composable
fun NotesTextField(
    state: NotesState,
    onEvent: (NotesEvent) -> Unit,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val isKeyboardOpen by keyboardAsState()

    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(text = state.note.content))
    }

    BackHandler(enabled = isKeyboardOpen) {
        focusManager.clearFocus()
        keyboardController?.hide()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    focusManager.moveFocus(FocusDirection.Up)
                    textFieldValue = textFieldValue.getFocusedOnLastLine()
                }
            )
    ) {
        BasicTextField(
            value = textFieldValue,
            onValueChange = { newValue ->
                textFieldValue = newValue
                onEvent(NotesEvent.SetNoteContent(newValue.text))
            },
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.None,
            ),
            singleLine = false,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun keyboardAsState(): State<Boolean> {
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    return rememberUpdatedState(isImeVisible)
}

private fun TextFieldValue.getFocusedOnLastLine(): TextFieldValue {
    return this.copy(selection = TextRange(this.text.length))
}

@Preview
@Composable
private fun NotesTextFieldPreview() {
    NotesTextField(
        state = NotesState(
            note = Note(
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
            )
        ),
        onEvent = {},
        textStyle = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
        modifier = Modifier.fillMaxWidth()
    )
}