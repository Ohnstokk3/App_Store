package com.example.Imagepicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
/**problem it allows you to pick a image but does not load it. fix this problem *//
@Composable
fun Image_fun(){
    val selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val selectedImageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }

    val singlePhotoPickerLauncher= rememberLauncherForActivityResult(
        contract =ActivityResultContracts.PickVisualMedia() , onResult = {uri -> selectedImageUri  }
    )
    val multiplePhotoPickerLauncher= rememberLauncherForActivityResult(
        contract =ActivityResultContracts.PickMultipleVisualMedia() , onResult = {uris -> selectedImageUris  }
    )
    Column {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    Button(onClick = {singlePhotoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )}){
                        Text(text = "Pick a photo")
                    }
                    Button(onClick = { multiplePhotoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )}){
                        Text(text = "Pick two photo")
                    }
                }
            }
            item {
                AsyncImage(model =selectedImageUri ,contentDescription = null,
                    modifier = Modifier.fillMaxWidth())
            }
            items(selectedImageUris){uri->
                AsyncImage(model =uri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth())
            }
        }
    }
}