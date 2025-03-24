package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NotesField(
    onClick: () -> Unit,
    content: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    modifier: Modifier = Modifier
) {
    with(sharedTransitionScope) {
        Column(
            modifier = modifier
                .sharedElement(
                    rememberSharedContentState(key = "text_field"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .fillMaxWidth()
                .heightIn(min = getMinNotesSize())
                .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                .background(MaterialTheme.colorScheme.surface)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClick
                )
                .padding(horizontal = 22.dp, vertical = 14.dp)
        ) {
            NotesTitle()
            Text(
                text = content.ifBlank { stringResource(R.string.default_note) },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
fun getMinNotesSize(): Dp {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    return (screenHeight * 0.24).dp
}
