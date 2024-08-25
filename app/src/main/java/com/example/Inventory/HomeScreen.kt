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
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.Inventory.navigation.NavigationDestination
import com.example.Layer.Item


object HomeDestination : NavigationDestination {
    override val route = "home"

}

/**
 * Entry route for Home screen
 */
@Composable
fun HomeBody(viewModel: HomeViewModel = hiltViewModel(),
             navigateToItem: (Int) -> Unit,

             modifier: Modifier = Modifier,
             contentPadding: PaddingValues = PaddingValues(0.dp),
) {val homeUiState by viewModel.homeUiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {

        InventoryList(
            itemList = homeUiState.itemList,
            onItemClick = { navigateToItem(it.id) },
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
        items(items=itemList, key = { it.id }) { item ->
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
) {   /**move state to Homeviewmodel**/
    var selectedImages by remember {
    mutableStateOf<Uri?>(null)
}


    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { selectedImages=it }
    )
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
                text = "in stock, ${item.quantity}",
                style = MaterialTheme.typography.titleMedium
            )
            /**image picker is from here->**/
            Button(modifier=Modifier.padding(start = 190.dp),onClick = {
                singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }) {
                Text("pick image")
            }
            AsyncImage(
                model = selectedImages,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            /**<-to here**/
        }
    }
}

