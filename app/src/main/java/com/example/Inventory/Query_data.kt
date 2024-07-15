package com.example.Inventory

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.Inventory.navigation.NavigationDestination
import com.example.Layer.Item
import com.example.Layer.NameCount

object HomesDestination : NavigationDestination {
    override val route = "homes"

}

@Composable
fun Deatails_state(viewModel: QueryViewModel= viewModel(factory = AppViewModelProvider.Factory),
             navigateTomain: () -> Unit){
    val uiState by viewModel.uiState.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Details(
            queryUiState = uiState.itemDetails
        )
    }

}
@Composable
fun Details(
    queryUiState: List<NameCount>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,

    ) {
        items(items= queryUiState) { item ->
            InventoryItems(item = item,
                modifier = Modifier
                    .padding(8.dp)
                    )
        }
    }
}

@Composable
fun InventoryItems(
    item: NameCount, modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
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
                    text = item.count.toString(),
                    style = MaterialTheme.typography.titleLarge,

                    )
                

            }


        }
    }
}

