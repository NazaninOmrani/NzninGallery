package com.example.nzningallery.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.business.domain.Data
import com.example.business.interactors.UseCases
import com.example.business.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * this viewModel is for get data from repository and handle response
 */

@HiltViewModel
class ImageViewModel
@Inject
constructor(
    private val usecases: UseCases,
) : ViewModel() {

    val postListLiveData = MutableLiveData<DataState<Data>>()

    fun getPostList() {
        postListLiveData.value = DataState.Loading()
        usecases.getData().onEach {
            postListLiveData.value = it
        }.launchIn(viewModelScope)
    }
}


