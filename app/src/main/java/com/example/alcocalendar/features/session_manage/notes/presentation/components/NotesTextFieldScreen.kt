package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NotesTextFieldScreen(
    state: NotesState,
    onEvent: (NotesEvent) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onEvent(NotesEvent.SaveNote)
        onEvent(NotesEvent.CollapseNote)
    }
    with(sharedTransitionScope) {
        Column(
            modifier = modifier
                .sharedElement(
                    rememberSharedContentState(key = "text_field"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize()
                .padding(horizontal = 22.dp, vertical = 14.dp)
        ) {
            NotesTitle()

            Box(modifier = Modifier.imePadding()) {
                NotesTextField(
                    state = state,
                    onEvent = onEvent,
                    textStyle = MaterialTheme.typography.bodySmall
                        .copy(color = MaterialTheme.colorScheme.onSurface),
                )

                SaveNoteButton(
                    onEvent = onEvent,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
    }
}
