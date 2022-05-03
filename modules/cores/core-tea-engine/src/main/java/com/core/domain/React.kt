package com.core.domain

sealed class React<out T> {

    data class Success<out T>(val data: T) : React<T>()
    data class Error(val exception: Exception) : React<Nothing>()

    companion object {

        inline fun <T> on(resultCreator: () -> T): React<T> {
            return try {
                Success(data = resultCreator.invoke())
            } catch (e: Exception) {
                Error(exception = e)
            }
        }
    }
}