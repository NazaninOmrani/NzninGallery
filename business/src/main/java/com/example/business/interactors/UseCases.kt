package com.example.business.interactors

import com.example.business.data.Repository
import com.example.business.domain.Data
import com.example.business.util.DataState
import kotlinx.coroutines.flow.Flow

/**
 * this class is useCase for get data from repository
 */

class UseCases(private val repository: Repository) {

    fun getData(): Flow<DataState<Data>> {
        return repository.getData()
    }
}