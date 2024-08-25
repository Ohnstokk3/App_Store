package com.example.Human_Resource

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Layer.ItemsRepository
import com.example.Layer.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class result_viewmodel @Inject constructor(itemsRepository: ItemsRepository) : ViewModel() {

        /**
         * Holds home ui state. The list of items are retrieved from [ItemsRepository] and mapped to
         * [HomeUiState]
         */
        val resultUiState: StateFlow<ResultUiState> =
            itemsRepository.findUsersBornOnDate().map { ResultUiState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                    initialValue = ResultUiState()
                )

        companion object {
            private const val TIMEOUT_MILLIS = 5_000L
        }
    }

    /**
     * Ui State for HomeScreen
     */
    data class ResultUiState(
        val reList: List<User> = listOf())


