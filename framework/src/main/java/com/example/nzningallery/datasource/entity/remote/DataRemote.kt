package com.example.nzningallery.datasource.entity.remote

import com.google.gson.annotations.SerializedName

/**
 * This class is Retrofit model for Data entity
 */

data class DataRemote(

    @SerializedName("data")
    var posts: List<ImageRemote>? = null,

    @SerializedName("totalPage")
    var totalPage: Long? = null
)