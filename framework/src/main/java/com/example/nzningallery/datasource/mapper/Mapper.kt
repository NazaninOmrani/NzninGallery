package com.example.nzningallery.datasource.mapper

/**
 * This Interface class is for mapping data from Entity AND to entity
 */

interface Mapper<Entity, DomainModel> {

    fun mapToModel(entity: Entity): DomainModel
    fun mapFromModel(domainModel: DomainModel): Entity

}