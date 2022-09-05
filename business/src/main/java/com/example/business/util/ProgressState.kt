package com.example.business.util

/**
 * this class is for Progressbar state
 */

sealed class ProgressState {
    object Loading : ProgressState()
    object Idle : ProgressState()
}
