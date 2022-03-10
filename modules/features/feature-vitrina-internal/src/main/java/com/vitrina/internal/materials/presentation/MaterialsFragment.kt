package com.vitrina.internal.materials.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.glebjay.homy.databinding.FragmentVitrinaBinding
import com.vitrina.internal.di.vitrinaDi
import org.koin.core.context.loadKoinModules

class VitrinaListFragment : Fragment() {

    private var _binding: FragmentVitrinaBinding? = null
    private val binding get() = _binding!!
    //private val viewModel by inject<MaterialsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(vitrinaDi)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentVitrinaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialsComposeView.setContent {
            MaterialTheme {
                MaterialsScreen()
            }
        }
    }

    @Composable
    fun MaterialsScreen(
        viewModel: MaterialsViewModel = viewModel(),
    ) {
        val uiModel by viewModel.uiModels.collectAsState()
        when {
            uiModel.materials.isNotEmpty() -> MaterialsList(uiModels = uiModel.materials)
            uiModel.errorText.isNotBlank() -> MaterialsError(errorText = uiModel.errorText)
        }
    }

    @Composable
    fun MaterialsList(
        uiModels: List<MaterialUiModel>,
    ) {
        uiModels.forEach { uiModel ->
            Row {
                MaterialItem(uiModel = uiModel)
            }
        }
    }

    @Composable
    fun MaterialItem(
        uiModel: MaterialUiModel,
    ) {
        Column {
            Text(text = uiModel.header)
            Text(text = uiModel.description)
        }
    }

    @Composable
    fun MaterialsError(
        errorText: String,
    ) {
        Text(text = errorText)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}