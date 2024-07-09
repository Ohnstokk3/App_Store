package com.example.Inventory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Layer.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class QueryViewModel( itemsRepository: ItemsRepository) : ViewModel() {



    val uiState: StateFlow<QueryUiState> =
        itemsRepository.getiteCount().map { QueryUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = QueryUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}
data class QueryUiState(
    val outOfStock: Int = 0,

    )