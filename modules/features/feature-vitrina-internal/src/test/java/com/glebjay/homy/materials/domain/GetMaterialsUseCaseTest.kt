package com.glebjay.homy.materials.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.vitrina.internal.materials.domain_api.GetMaterialsUseCase
import com.vitrina.internal.materials.domain_api.MaterialModel
import com.vitrina.internal.materials.domain_impl.MaterialsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetMaterialsUseCaseTest {

    private val materialRepository = mockk<MaterialsRepository>(relaxed = true)
    private val getMaterialsUseCase = GetMaterialsUseCase(materialRepository)

    @Test
    fun `check use case return success result`() = runTest {
        val expected = Result.success(emptyList<MaterialModel>())
        coEvery { materialRepository.getMaterialList() } returns Result.success(emptyList())

        val actual = getMaterialsUseCase.invoke()

        assertThat(actual).isEqualTo(expected)
        coVerify { materialRepository.getMaterialList() }
    }

    @Test
    fun `check use case return error result`() = runTest {
        val expected = Result.failure<List<MaterialModel>>(Exception("Throw error inside repository"))
        coEvery { materialRepository.getMaterialList() } returns expected

        val actual = getMaterialsUseCase.invoke()

        assertThat(actual).isEqualTo(expected)
        coVerify { materialRepository.getMaterialList() }
    }
}