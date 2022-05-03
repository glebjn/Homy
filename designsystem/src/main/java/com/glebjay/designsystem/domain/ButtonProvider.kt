package com.glebjay.designsystem.domain

interface Provider<out T> {
    fun provide(): T
}

class ButtonProvider(
    private val designSystemRepository: DesignSystemRepository
) : Provider<ButtonUiModel> {

    override fun provide() = designSystemRepository.getDesignSystemButton()
}