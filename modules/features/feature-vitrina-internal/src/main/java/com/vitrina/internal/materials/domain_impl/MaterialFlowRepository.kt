package com.vitrina.internal.materials.domain_impl

import com.vitrina.internal.materials.domain_api.MaterialModel
import kotlinx.coroutines.flow.Flow

interface MaterialFlowRepository {
    fun getMaterialList(): Flow<List<MaterialModel>>
}