package com.vitrina.internal.materials.domain_api

import com.vitrina.internal.materials.domain_impl.MaterialsRepository

class GetMaterialsUseCase(
    private val materialRepository: MaterialsRepository
) {
    suspend operator fun invoke() = materialRepository.getMaterialList()
}