package com.glebjay.designsystem.data

import com.glebjay.designsystem.domain.ButtonState
import com.glebjay.designsystem.domain.ButtonUiModel
import com.glebjay.designsystem.domain.DesignSystemRepository

class DesignSystemRepositoryImpl : DesignSystemRepository {

    override fun getDesignSystemButton(): ButtonUiModel {
        return ButtonUiModel(
            normalState = ButtonState(),
            focusedState = ButtonState(),
            selectedState = ButtonState(),
            disabled = ButtonState()
        )
    }
}