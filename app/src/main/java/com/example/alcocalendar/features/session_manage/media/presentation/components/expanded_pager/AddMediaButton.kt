package com.example.alcocalendar.features.session_manage.media.presentation.components.expanded_pager

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R

@Composable
fun AddMediaButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.add_media),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Preview
@Composable
private fun AddMediaButtonPreview() {
    AddMediaButton(onClick = {})
}