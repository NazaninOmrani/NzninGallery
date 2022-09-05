package com.example.business.domain

/**
 * This class is model for image
 */

data class Image(
    var likeStatus: Boolean? = false,
    var name: String? = "",
    var portrait: String? = ""
)