package com.example.nzningallery.datasource.di
import com.example.nzningallery.datasource.Api
import com.example.nzningallery.datasource.RepositoryImpl
import com.example.nzningallery.datasource.mapper.CacheMapper
import com.example.nzningallery.datasource.mapper.RemoteMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import javax.inject.Singleton

/**
 * This Module is for provide Repositories instance for app
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepositoryImpl(
        realm: Realm,
        api: Api,
        cacheMapper: CacheMapper,
        remoteMapper: RemoteMapper
    ): RepositoryImpl {
        return RepositoryImpl(realm, api, cacheMapper, remoteMapper)
    }

}