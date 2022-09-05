package com.example.nzningallery.datasource.di

import com.example.business.interactors.UseCases
import com.example.nzningallery.datasource.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * This Module is for provide UseCases for ViewModel
 */

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun providePostInteractor(repositoryImpl: RepositoryImpl): UseCases =
        UseCases(repositoryImpl)
}