package com.example.Inventory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Home(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),

){
val homeUiState by viewModel.homeUiState.collectAsState()

}