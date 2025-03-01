package com.example.alcocalendar.features.drink_intake.presentation.components.dialog

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import java.text.DecimalFormatSymbols

@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    clearField: () -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = TextFieldValue(
            text = value,
            selection = TextRange(value.length)
        ),
        onValueChange = { newValue ->
            if (isValidDoubleInput(newValue.text)) {
                onValueChange(newValue.text)
            }
        },
        label = { Text(stringResource(label)) },
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(32.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = stringResource(R.string.clear_text_field),
                modifier = Modifier.clickable { clearField() }
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

private fun isValidDoubleInput(input: String): Boolean {
    val decimalSeparator = DecimalFormatSymbols.getInstance().decimalSeparator

    val decimalPointCount = input.count { it == decimalSeparator }
    if (decimalPointCount > 1) return false

    val isValidCharacters = input.all { it.isDigit() || it == decimalSeparator }
    if (!isValidCharacters) return false

    return true
}