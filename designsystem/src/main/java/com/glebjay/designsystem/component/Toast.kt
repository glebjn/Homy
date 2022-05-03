package com.glebjay.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Toast(
    msg: String
) {
    android.widget.Toast.makeText(LocalContext.current, msg, android.widget.Toast.LENGTH_LONG).show()
}