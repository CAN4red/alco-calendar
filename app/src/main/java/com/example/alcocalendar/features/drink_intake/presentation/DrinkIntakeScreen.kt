package com.example.alcocalendar.features.drink_intake.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DrinkIntakeScreen(
    modifier: Modifier = Modifier,
    viewModel: DrinkIntakeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()


}

@Preview
@Composable
private fun DrinkIntakeScreenPreview() {

}