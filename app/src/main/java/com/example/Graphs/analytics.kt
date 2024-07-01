package com.example.Graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Inventory.ItemUiState

    @Composable
    fun Analyticsg(
        viewModel: MainViewModel = viewModel(),
    ) {
        Column(modifier = Modifier.padding(40.dp)) {
            TextField(value = viewModel.state.height, onValueChange = { viewModel.changeHeight(it) })
            Text(
                /**here*/   "${viewModel.state.lowerWeightBound}",
            )

        }
    }

