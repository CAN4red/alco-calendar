package com.example.alcocalendar.features.session_manage.components

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.date_title.DateTitle
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.drink_list.DrinkListsColumn
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.intake_tag.IntakesFlowRow
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.DrinkIntakeState
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.media.presentation.components.collapsed_pager.CollapsedMediaPager
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState
import com.example.alcocalendar.features.session_manage.notes.presentation.components.NotesField

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SessionManageColumnContent(
    drinkIntakeState: DrinkIntakeState,
    notesState: NotesState,
    mediaState: MediaState,
    onDrinkIntakeEvent: (DrinkIntakeEvent) -> Unit,
    onNotesEvent: (NotesEvent) -> Unit,
    onMediaEvent: (MediaEvent) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    Column {
        Box {
            CollapsedMediaPager(
                state = mediaState,
                onEvent = onMediaEvent,
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope,
                modifier = Modifier.fillMaxWidth()
            )

            DateTitle(
                state = drinkIntakeState,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.TopCenter)
                    .zIndex(1f)
            )
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            DrinkListsColumn(
                state = drinkIntakeState,
                onEvent = onDrinkIntakeEvent,
            )

            Spacer(Modifier.padding(8.dp))

            IntakesFlowRow(
                intakes = drinkIntakeState.intakes,
                onEvent = onDrinkIntakeEvent,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.padding(16.dp))

            Spacer(Modifier.weight(1f))

            NotesField(
                onClick = { onNotesEvent(NotesEvent.ExpandNote) },
                content = notesState.note.content,
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope,
                modifier = Modifier.fillMaxSize()
            )

        }
    }
}