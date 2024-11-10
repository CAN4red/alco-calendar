package com.example.alcocalendar.ui.addsession.components

import androidx.compose.foundation.layout.ColumnScope
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.ui.addsession.screens.bottomsheets.SheetContent
import com.example.alcocalendar.ui.addsession.screens.columns.AddBeerColumn

@Composable
fun AddDrinkScreen(
    sheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
    screenContent: @Composable (Modifier) -> Unit,
    modifier: Modifier = Modifier
) {
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = sheetContent
    ) {
        screenContent(modifier)
    }
}
