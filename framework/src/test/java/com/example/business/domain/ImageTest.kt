package com.example.business.domain

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ImageTest {
    private lateinit var image: Image

    @Before
    fun setup() {
        image = Image(false, "", "")
    }

    @Test
    fun dataShouldHaveDefaultEmptyValue() {
        Assert.assertEquals(image.likeStatus, false)
        Assert.assertEquals(image.name, "")
        Assert.assertEquals(image.portrait, "")
    }


    @Test
    fun verifyDataObject() {
        val _image = Image(image.likeStatus, image.name, image.portrait)

        Assert.assertEquals(
            _image.likeStatus,
            image.likeStatus
        )

        Assert.assertEquals(
            _image.name,
            image.name
        )

        Assert.assertEquals(
            _image.portrait,
            image.portrait
        )
    }

    @Test
    fun verifyDataObjectNotAssert() {
        val _image = Image(true, "name", "portrait")

        Assert.assertNotEquals(
            _image.likeStatus,
            image.likeStatus
        )

        Assert.assertNotEquals(
            _image.name,
            image.name
        )

        Assert.assertNotEquals(
            _image.portrait,
            image.portrait
        )
    }
}