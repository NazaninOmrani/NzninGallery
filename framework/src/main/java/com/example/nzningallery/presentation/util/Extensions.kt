package com.example.nzningallery.presentation.util

import android.content.res.Resources
import kotlin.math.ceil

/**
 * This Extension function is for convert px to dp
 */

fun Int.dp(): Int {
    return if (this == 0) {
        0
    } else ceil((Resources.getSystem().displayMetrics.density * this).toDouble()).toInt()
}