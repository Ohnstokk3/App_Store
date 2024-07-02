package com.example.Graphs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Inventory.ItemUiState

    @Composable
    fun Analytics(
        viewModel: MainViewModel = viewModel(),
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            TextField(
                value = viewModel.state.height,
                onValueChange = { viewModel.changeHeight(it) },
                label = { Text(text = "Enter List") },
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.state.height,
                onValueChange = { viewModel.changeHeight(it) },
                label = { Text(text = "Enter month ") },)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                /**here*/  "Prediction: ${viewModel.state.lowerWeightBound}",
            )
            Spacer(modifier = Modifier.height(16.dp))
            Canvas(modifier = Modifier.size(200.dp)) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                drawLine(
                    start = Offset(x = canvasWidth, y = 0.9f),
                    end = Offset(x = 0f, y = canvasHeight),
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        }
    }
