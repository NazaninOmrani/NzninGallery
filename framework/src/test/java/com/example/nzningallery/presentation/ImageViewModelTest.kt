package com.example.nzningallery.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.business.domain.Data
import com.example.business.domain.Image
import com.example.business.interactors.UseCases
import com.example.business.util.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ImageViewModelTest {

    private val dispatcher = StandardTestDispatcher()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var useCases: UseCases
    private lateinit var imageViewModel: ImageViewModel
    private lateinit var imageListLiveData: Observer<DataState<Data>>
    private lateinit var lastData: Data
    private lateinit var newData: Data
    private lateinit var images: List<Image>

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        useCases = mock()
        imageViewModel = ImageViewModel(useCases)
        imageListLiveData = mock()
        lastData = mock()
        newData = mock()
        images = mock()
    }

    @Test
    fun verifyUseCase() {
        imageViewModel.getPostList()
        verify(useCases).getData()
    }

    @Test
    fun verifyUseCasesReturnedValue() {
        whenever(useCases.getData()).thenReturn(
            flow {
                emit(
                    DataState.Success(
                        newData
                    )
                )
                imageViewModel.imageListLiveData.value = DataState.Success(lastData)
                verify(imageListLiveData).onChanged(DataState.Success(newData))
            }
        )

        imageViewModel.getPostList()
    }

    @Test
    fun verifyReturnedValidValue() {
        val responseValue = flow<DataState<Data>> {
            emit(
                DataState.Success(
                    Data(images, 5)
                )
            )
        }
        whenever(useCases.getData()).thenReturn(
            responseValue
        )
        val response = useCases.getData()

        assert(responseValue == response)
    }

}