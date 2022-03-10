package com.vitrina.internal.materials.domain_impl

import com.vitrina.internal.materials.domain_api.MaterialModel

interface MaterialsRepository {
    suspend fun getMaterialList(): Result<List<MaterialModel>>
}