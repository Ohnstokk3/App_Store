package com.example.Inventory

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Inventory.navigation.NavigationDestination
import com.example.Layer.Item


object HomeDestination : NavigationDestination {
    override val route = "home"

}

/**
 * Entry route for Home screen
 */
@Composable
fun HomeBody(  viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
               navigateToItem: () -> Unit,

               modifier: Modifier = Modifier,
               contentPadding: PaddingValues = PaddingValues(0.dp),
) {val homeUiState by viewModel.homeUiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {

        InventoryList(
            itemList = homeUiState.itemList,
            onItemClick = { navigateToItem() },
            contentPadding = contentPadding,
            modifier = Modifier.padding(horizontal =8.dp)
        )
    }
}


@Composable
fun InventoryList(
    itemList: List<Item>,
    onItemClick: (Item) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items=itemList, key = {it.id}) { item ->
            InventoryItem(item = item,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onItemClick(item) })
        }
    }
}

@Composable
fun InventoryItem(
    item: Item, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = item.formatePrice(),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = "in_stock, ${item.quantity}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

