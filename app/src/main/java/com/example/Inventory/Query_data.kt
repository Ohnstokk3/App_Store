package com.example.Inventory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Deatails_state(viewModel: QueryViewModel= viewModel(factory = AppViewModelProvider.Factory)){
    val uiState = viewModel.uiState.collectAsState()
    Details(
        queryUiState = uiState.value
    )
}
@Composable
fun Details(
    queryUiState: QueryUiState ) {
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
                    text = "${ queryUiState.outOfStock}"
                )

            }

        }

    }
}