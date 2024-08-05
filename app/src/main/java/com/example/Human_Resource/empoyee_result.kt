package com.example.Human_Resource

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

import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

import com.example.Inventory.HomeViewModel

import com.example.Inventory.formatePrice
import com.example.Inventory.navigation.NavigationDestination
import com.example.Layer.Item
import com.example.Layer.User
import dagger.hilt.android.lifecycle.HiltViewModel

object resultDestination : NavigationDestination {
    override val route = "result"

}

@Composable
fun Body(viewModel: result_viewmodel = hiltViewModel(),
         navigateToItems: () -> Unit,

         modifier: Modifier = Modifier,
         contentPadding: PaddingValues = PaddingValues(0.dp),
) {val resultUiState by viewModel.resultUiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {

        resultList(
            nameList = resultUiState.reList,
            onItemClick = { navigateToItems() },
            contentPadding = contentPadding,
            modifier = Modifier.padding(horizontal =8.dp)
        )
    }
}


@Composable
fun resultList(
  nameList: List<User>,
    onItemClick: (Item) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items=nameList) { user ->
            resultItem(user = user,
                modifier = Modifier
                    .padding(8.dp),
            )}
    }
}



@Composable
fun resultItem(
   user: User, modifier: Modifier = Modifier
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
                    text = "${user.name}",
                    style = MaterialTheme.typography.titleLarge,

                    )

                Spacer(Modifier.weight(1f))
                Text(
                    text = "${user.birthday}",
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }
    }
}

