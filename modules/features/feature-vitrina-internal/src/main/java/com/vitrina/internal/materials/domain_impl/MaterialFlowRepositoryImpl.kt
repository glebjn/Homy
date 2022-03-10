package com.vitrina.internal.materials.domain_impl

import com.vitrina.internal.materials.domain_api.MaterialModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MaterialFlowRepositoryImpl : MaterialFlowRepository {

    override fun getMaterialList(): Flow<List<MaterialModel>> {
        return flow {
            emit(emptyList())
        }
    }
}