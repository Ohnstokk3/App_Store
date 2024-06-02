package com.example.Inventory

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.Layer.InventoryApplication

class AppViewModelProvider {
    object AppViewModelProvider {
        val Factory = viewModelFactory {
            // Initializer for ItemEditViewModel

            // Initializer for ItemEntryViewModel
            initializer {
                MainViewModel(inventoryApplication().container.itemsRepository)
            }

        }
    }
}
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)
