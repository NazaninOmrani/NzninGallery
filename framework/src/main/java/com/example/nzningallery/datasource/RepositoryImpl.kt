package com.example.nzningallery.datasource

import com.example.business.data.Repository
import com.example.business.domain.Data
import com.example.business.util.DataState
import com.example.business.util.ProgressState
import com.example.nzningallery.datasource.mapper.CacheMapper
import com.example.nzningallery.datasource.mapper.RemoteMapper
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * This Repository implementation class is for send request and get data and insert data to realm database
 * then map in to domain model to emit for useCase
 */

class RepositoryImpl
@Inject
constructor(
    private val realm: Realm,
    private val api: Api,
    private val cacheMapper: CacheMapper,
    private val networkMapper: RemoteMapper
) : Repository {

    override fun getData(): Flow<DataState<Data>> = flow {
        try {
            emit(DataState.Loading(ProgressState.Loading))
            val data = api.getData().let {
                networkMapper.mapToModel(it)
            }.let {
                cacheMapper.mapFromModel(it)
            }

            realm.executeTransactionAwait { realm1 ->
                realm1.insertOrUpdate(data)
            }

            emit(DataState.Success(cacheMapper.mapToModel(data)))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}