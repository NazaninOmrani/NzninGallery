package com.example.nzningallery.datasource.entity.database

import io.realm.RealmObject

/**
 * This class is Realm model for Image entity
 */

open class ImageCache(
    var like: Boolean? = false,
    var names: String? = " ",
    var image: String? = " "
) : RealmObject()