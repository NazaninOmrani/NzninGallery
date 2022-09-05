package com.example.nzningallery.datasource.mapper

import com.example.business.domain.Data
import com.example.business.domain.Image
import com.example.nzningallery.datasource.entity.remote.DataRemote
import com.example.nzningallery.datasource.entity.remote.ImageRemote

import javax.inject.Inject

/**
 * This class is for mapping data from DomainModel to RetrofitModel
 * AND mapping from RetrofitModel to DomainModel
 */

class RemoteMapper
@Inject
constructor() : Mapper<DataRemote, Data> {

    override fun mapToModel(dataRemote: DataRemote): Data {
        return Data(
            dataRemote.posts?.map { Image(it.likeStatus, it.name, it.portrait) },
            dataRemote.totalPage
        )
    }

    override fun mapFromModel(data: Data): DataRemote {
        return DataRemote(
            data.images?.map { ImageRemote(it.likeStatus, it.name, it.portrait) },
            data.totalPage
        )
    }
}