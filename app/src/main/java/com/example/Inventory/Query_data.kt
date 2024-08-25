package com.example.Inventory


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.Inventory.navigation.NavigationDestination



object QueryDestination : NavigationDestination {
    override val route = "homes"

}

@Composable
fun Deatails_state(viewModel: QueryViewModel= hiltViewModel(),
                   navigateTomain: () -> Unit){
    val uiState = viewModel.uiState.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Details(
            queryUiState = uiState.value
        )
    }

}
@Composable
fun Details(
    queryUiState: QueryUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(
                18.dp
            )
        ) {

            Text(
                text = "name is ${queryUiState.itemDetails}"
            )
        }
    }
}


