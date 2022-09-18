package com.example.business.interactors

import com.example.business.data.Repository
import com.example.business.domain.Data
import com.example.business.domain.Image
import com.example.business.util.DataState
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class UseCasesTest {

    lateinit var useCases: UseCases
    lateinit var repository: Repository
    private lateinit var images: List<Image>

    @Before
    fun setup() {
        repository = mock()
        useCases = UseCases(repository)
        images = mock()
    }

    @Test
    fun verifyGetDataFromRepository() {
        useCases.getData()
        verify(repository).getData()
    }

    @Test
    fun verifyUseCasesReturnValue() {
        val repositoryValue = flow<DataState<Data>> {
            emit(
                DataState.Success(
                    Data(images, 1)
                )
            )
        }

        whenever(repository.getData()).thenReturn(
            repositoryValue
        )
        val useCasesReturned = useCases.getData()

        assert(repositoryValue == useCasesReturned)
    }
}