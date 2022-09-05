package com.example.nzningallery.datasource.mapper

import com.example.business.domain.Data
import com.example.business.domain.Image
import com.example.nzningallery.datasource.entity.database.DataCache
import com.example.nzningallery.datasource.entity.database.ImageCache
import io.realm.RealmList
import javax.inject.Inject

/**
 * This class is for mapping data from DomainModel to RealmModel
 * AND mapping from RealmModel to DomainModel
 */

class CacheMapper
@Inject
constructor() : Mapper<DataCache, Data> {

    override fun mapToModel(dataCache: DataCache): Data {
        return Data(
            dataCache.posts?.map { Image(it?.like, it?.names, it?.image) },
            dataCache.totalPage
        )
    }

    override fun mapFromModel(data: Data): DataCache {
        val imageCache: RealmList<ImageCache> = RealmList()
        data.images?.forEach {
            imageCache.add(
                ImageCache(
                    it.likeStatus,
                    it.name,
                    it.portrait
                )
            )
        }
        return DataCache(
            imageCache,
            data.totalPage
        )
    }
}