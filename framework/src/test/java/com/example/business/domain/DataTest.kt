package com.example.business.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock

@RunWith(MockitoJUnitRunner::class)
class DataTest {

    private lateinit var data: Data
    private lateinit var image: List<Image>

    @Before
    fun setup() {
        image = mock()
        data = Data(null, 0)
    }

    @Test
    fun dataShouldHaveDefaultEmptyValue() {
        assertEquals(data.images, null)
        assertEquals(data.totalPage, 0L)
    }


    @Test
    fun verifyDataObject() {
        val _data = Data(data.images, data.totalPage)

        assertEquals(
            _data.images,
            data.images
        )

        assertEquals(
            _data.totalPage,
            data.totalPage
        )
    }

    @Test
    fun verifyDataObjectNotAssert() {
        val _data = Data(image, 2)

        assertNotEquals(
            _data.images,
            data.images
        )

        assertNotEquals(
            _data.totalPage,
            data.totalPage
        )
    }
}