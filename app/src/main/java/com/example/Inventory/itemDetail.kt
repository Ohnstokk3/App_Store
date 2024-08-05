package com.example.Inventory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Inventory.navigation.NavigationDestination

object ItemDetailsDestination : NavigationDestination {
    override val route = "item_details"
}
@Composable
fun Deatail_state(viewModel: ItemDetailViewModel= hiltViewModel()){
    val uiState = viewModel.uiState.collectAsState()
    Detail(
        itemDetailsUiState = uiState.value
    )
}
@Composable
fun Detail(
    itemDetailsUiState: ItemDetailsUiState ) {
    Column() {
        Card(
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(
                    18.dp
                )
            ) {

                Text(
                    itemDetailsUiState.itemDetails.name
                )
                Text(
                    itemDetailsUiState.itemDetails.quantity
                )
            }

        }
        Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(20.dp)) {
            Text(text = "enter")
        }
    }
}
