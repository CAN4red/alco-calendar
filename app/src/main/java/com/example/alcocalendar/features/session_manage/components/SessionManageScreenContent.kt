package com.example.alcocalendar.features.session_manage.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.session_manage.common.mappers.SessionManageTargetState
import com.example.alcocalendar.features.session_manage.common.mappers.rememberSessionManageTargetState
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.dialog.AddIntakeDialog
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.DrinkIntakeState
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.media.presentation.components.expanded_pager.ExpandedMediaScreen
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesTextFieldScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SessionManageScreenContent(
    drinkIntakeState: DrinkIntakeState,
    notesState: NotesState,
    mediaState: MediaState,
    onDrinkIntakeEvent: (DrinkIntakeEvent) -> Unit,
    onNotesEvent: (NotesEvent) -> Unit,
    onMediaEvent: (MediaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val targetState = rememberSessionManageTargetState(
        notesState = notesState,
        mediaState = mediaState
    )
    val scrollState = rememberScrollState()

    SharedTransitionLayout {
        AnimatedContent(targetState = targetState) { targetState ->
            Column(
                modifier = modifier
            ) {
                when (targetState) {
                    is SessionManageTargetState.NotesExpanded -> NotesTextFieldScreen(
                        state = notesState,
                        onEvent = onNotesEvent,
                        animatedVisibilityScope = this@AnimatedContent,
                        sharedTransitionScope = this@SharedTransitionLayout,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    is SessionManageTargetState.MediaExpanded -> ExpandedMediaScreen(
                        state = mediaState,
                        onEvent = onMediaEvent,
                        animatedVisibilityScope = this@AnimatedContent,
                        sharedTransitionScope = this@SharedTransitionLayout,
                    )

                    is SessionManageTargetState.Default -> SessionManageColumnContent(
                        scrollState = scrollState,
                        drinkIntakeState = drinkIntakeState,
                        notesState = notesState,
                        mediaState = mediaState,
                        onDrinkIntakeEvent = onDrinkIntakeEvent,
                        onNotesEvent = onNotesEvent,
                        onMediaEvent = onMediaEvent,
                        animatedVisibilityScope = this@AnimatedContent,
                        sharedTransitionScope = this@SharedTransitionLayout,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }

    if (drinkIntakeState.fillingIntake != null) {
        AddIntakeDialog(
            state = drinkIntakeState,
            onEvent = onDrinkIntakeEvent,
        )
    }
}


@Preview
@Composable
private fun DrinkIntakeScreenContentPreview() {
    SessionManageScreenContent(
        drinkIntakeState = DrinkIntakeState(),
        notesState = NotesState(),
        mediaState = MediaState(),
        onDrinkIntakeEvent = {},
        onNotesEvent = {},
        onMediaEvent = {},
        modifier = Modifier.fillMaxSize()
    )
}
