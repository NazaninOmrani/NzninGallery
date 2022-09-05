package com.example.nzningallery.datasource.di

import com.example.nzningallery.datasource.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * This Module is for provide RetrofitBuilder AND DataApi instance for app
 */

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://60f225126d44f30017788535.mockapi.io/api/test/list/")
    }

    @Singleton
    @Provides
    fun provideProductApi(
        retrofit: Retrofit.Builder
    ): Api {
        return retrofit
            .build()
            .create(Api::class.java)
    }
}