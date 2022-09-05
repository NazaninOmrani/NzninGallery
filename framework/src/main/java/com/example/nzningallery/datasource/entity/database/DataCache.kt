package com.example.nzningallery.datasource.entity.database

import io.realm.RealmList
import io.realm.RealmObject

/**
 * This class is Realm model for Data entity
 */

open class DataCache(
    var posts: RealmList<ImageCache>? = null,
    var totalPage: Long? = 0
) : RealmObject()