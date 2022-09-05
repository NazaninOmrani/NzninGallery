package com.example.business.data

import com.example.business.domain.Data
import com.example.business.util.DataState
import kotlinx.coroutines.flow.Flow

/**
 * This interface class is for implementing the logic of the program in the framework
 */

interface Repository {
    fun getData(): Flow<DataState<Data>>
}