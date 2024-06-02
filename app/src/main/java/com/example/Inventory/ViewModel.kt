package com.example.Inventory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.Layer.Item
import com.example.Layer.ItemsRepository

class ViewModel(private val ItemsRepository:ItemsRepository) :ViewModel() {
    var itemUiState by mutableStateOf(ItemUiState())
    private set
suspend fun saveItem(){
    ItemsRepository.insertItem(itemUiState.itemdetails.toItems())
}
    fun updateUiState(itemDetails:ItemDetaills){
        itemUiState=ItemUiState(itemdetails=itemDetails)
    }
    data class ItemUiState(
        val itemdetails:ItemDetaills= ItemDetaills(),
    )
    data class ItemDetaills(
        val id:Int=0,
        val name:String="",
        val price:String="",
        val quantity:String=""
    )
    fun ItemDetaills.toItems(): Item =Item(
        id=id,
        name=name,
        price=price.toDoubleOrNull()?:0.0,
        quantity=quantity.toIntOrNull()?:0
    )
}
