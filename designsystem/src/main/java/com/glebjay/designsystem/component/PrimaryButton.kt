package com.glebjay.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.glebjay.designsystem.domain.ButtonUiModel

@Composable
fun PrimaryButton(
    id: String? = null,
    uiModel: ButtonUiModel,
    text: String,
    onClick: (() -> Unit)? = null,
) {
    val isSelected = remember { mutableStateOf(false) }
    val buttonState = if (isSelected.value) {
        uiModel.selectedState
    } else {
        uiModel.normalState
    }

    Button(
        onClick = {
            onClick?.invoke()
        },
        modifier = Modifier
            .selectable(isSelected.value, onClick = { isSelected.value = !isSelected.value })
            .background(buttonState.backgroundColor)
            .border(width = buttonState.borderWidth, color = buttonState.borderColor),
        shape = RoundedCornerShape(buttonState.borderRadius)
    ) {
        Text(
            text = text,
            color = buttonState.textColor
        )
    }
}