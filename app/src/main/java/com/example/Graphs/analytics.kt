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

    Column(modifier = Modifier.padding(40.dp)) {

        OutlinedTextField(value=calculate, onValueChange = {calculate=it})
        Text(" sum x: $xsum")
        Text("sum y: $ysum")
        Text("total xy: $xysum")
        Text("total square: $square")
        Text("total sum 1: $sumof")
        Text("total sum 2: $sumof2")
        Text("total m: $msum")
        Text("total b: $b")
        Text("total c: $c")
        Text("total prediction: $prediction")}
    }
