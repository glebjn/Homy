package com.vitrina.internal.materials.domain_impl

import com.vitrina.internal.materials.domain_api.MaterialModel

internal class MaterialRepositoryImpl(
    private val materialsApi: MaterialsApi
) : MaterialsRepository {

    override suspend fun getMaterialList(): Result<List<MaterialModel>> {
        return kotlin.runCatching { materialsApi.getMaterials() }
    }
}