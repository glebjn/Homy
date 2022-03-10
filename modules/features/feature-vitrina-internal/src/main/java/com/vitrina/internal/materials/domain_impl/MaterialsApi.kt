package com.vitrina.internal.materials.domain_impl

import com.vitrina.internal.materials.domain_api.MaterialModel

interface MaterialsApi {

    fun getMaterials(): List<MaterialModel>
}