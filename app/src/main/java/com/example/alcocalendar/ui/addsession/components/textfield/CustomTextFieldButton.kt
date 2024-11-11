package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextFieldButton(
    onClick: () -> Unit,
    buttonContent: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(horizontal = 4.dp)
    ) {
        buttonContent()
    }
}

@Composable
@Preview
private fun CustomTextFieldButtonPreview() {
    CustomTextFieldButton(onClick = {}, buttonContent = {Text("1")})
}