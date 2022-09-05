package com.example.nzningallery.datasource

import com.example.nzningallery.datasource.entity.remote.DataRemote
import retrofit2.http.GET

/**
 * This class is for retrofit api calling
 */

interface Api {

    @GET(" ")
    suspend fun getData(): DataRemote

}