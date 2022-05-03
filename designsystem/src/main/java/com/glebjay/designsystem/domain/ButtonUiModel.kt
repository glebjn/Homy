package com.glebjay.designsystem.domain

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ButtonUiModel(
    val normalState: ButtonState,
    val focusedState: ButtonState,
    val selectedState: ButtonState,
    val disabled: ButtonState
)

data class ButtonState(
    val backgroundColor: Color = Color.Blue,
    val textColor: Color = Color.White,
    val font: FontFamily = FontFamily.Serif,
    val borderRadius: Dp = 8.dp,
    val borderWidth: Dp = 1.dp,
    val borderColor: Color = Color.Green
)