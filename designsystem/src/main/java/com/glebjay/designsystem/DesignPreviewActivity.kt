package com.glebjay.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.glebjay.designsystem.component.PrimaryButton
import com.glebjay.designsystem.domain.ButtonProvider
import com.glebjay.designsystem.ui.theme.HomyTheme
import org.koin.androidx.compose.inject

class DesignPreviewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    PreviewScreen()
                }
            }
        }
    }
}

@Composable
fun PreviewScreen() {
    val provider: ButtonProvider by inject()
    PrimaryButton(
        uiModel = provider.provide(),
        text = "Кнопка без токена"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomyTheme {
        PreviewScreen()
    }
}