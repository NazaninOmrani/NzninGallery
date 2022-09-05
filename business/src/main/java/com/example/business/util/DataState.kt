package com.example.business.util

/**
 * this class is for data state
 */

sealed class DataState<T> {
    data class Success<T>(val data: T) : DataState<T>()
    data class Error<T>(val exception: Exception) : DataState<T>()
    data class Loading<T>(val progressState: ProgressState = ProgressState.Idle) : DataState<T>()
}