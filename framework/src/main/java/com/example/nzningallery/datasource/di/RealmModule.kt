package com.example.nzningallery.datasource.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

/**
 * This Module is for provide realm instance for app
 */

@Module
@InstallIn(SingletonComponent::class)
object RealmModule {

    @Singleton
    @Provides
    fun provideRealm(
        @ApplicationContext context: Context
    ): Realm {
        Realm.init(context)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        Realm.compactRealm(config)
        return Realm.getDefaultInstance()
    }
}