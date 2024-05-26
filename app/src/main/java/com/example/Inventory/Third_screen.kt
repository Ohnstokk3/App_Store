package com.example.Inventory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemField(){
Column(horizontalAlignment =Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(top=240.dp)){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Item Name") }
    )
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Item Price") }
    )
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Quantity in Stock") }
    )
    OutlinedButton(onClick ={}, modifier = Modifier.padding(top = 20.dp).size(height = 50.dp, width = 300.dp)){
    Text(text="Save")
}
}
}