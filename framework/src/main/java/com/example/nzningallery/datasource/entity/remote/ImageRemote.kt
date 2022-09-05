package com.example.nzningallery.datasource.entity.remote

import com.google.gson.annotations.SerializedName

/**
 * This class is Retrofit model for image entity
 */

data class ImageRemote(

    @SerializedName("likeStatus")
    var likeStatus: Boolean? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("portrait")
    var portrait: String? = null
)
