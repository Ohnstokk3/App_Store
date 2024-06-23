package com.example.Graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Inventory.ItemUiState

@Composable
fun Analytics(viewModel: AnalyticsViewModel = viewModel(),
       ){
    var calculate by remember { mutableStateOf("") }/**Remember user input*/

    val calculateList:List<String> = calculate.split(",")/**Convert to list and use , as indicator for the next number the user entered */

    val ConvertListIntoDouble=calculateList.map { it.toDoubleOrNull() }/**We use the map operator to convert the String list
                                                                        into a Double List or the user enters a letter the considered a null */

    Column(modifier = Modifier.padding(40.dp)) {
      }
        OutlinedTextField(value=calculate, onValueChange = {calculate=it})
Text(text = "amount is $ConvertListIntoDouble")
    }
