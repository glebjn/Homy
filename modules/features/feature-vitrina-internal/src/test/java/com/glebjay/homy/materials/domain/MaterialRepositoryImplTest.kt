package com.glebjay.homy.materials.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.vitrina.internal.materials.domain_api.MaterialModel
import com.vitrina.internal.materials.domain_impl.MaterialRepositoryImpl
import com.vitrina.internal.materials.domain_impl.MaterialsApi
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MaterialRepositoryImplTest {
    private val materialApi = mockk<MaterialsApi>(relaxed = true)
    private val repository = MaterialRepositoryImpl(materialApi)

    @Test
    fun `check get materials return success result`() = runTest {
        every { materialApi.getMaterials() } returns emptyList()
        val expected = Result.success(emptyList<MaterialModel>())

        val actual = repository.getMaterialList()

        assertThat(actual).isEqualTo(expected)
        verify { materialApi.getMaterials() }
    }

    @Test
    fun `check get materials return failure result`() = runTest {
        every { materialApi.getMaterials() } throws Exception("Get materials throw exception")
        val expected = Result.failure<Throwable>(Exception("Get materials throw exception"))

        val actual = repository.getMaterialList()

        assertThat(actual).isEqualTo(expected)
        verify { materialApi.getMaterials() }
    }
}