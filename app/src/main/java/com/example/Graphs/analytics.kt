package com.example.Graphs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Inventory.navigation.NavigationDestination

object AnalyticsDestination : NavigationDestination {
    override val route = "Analytics"

}
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
                leadingIcon ={  Icon(
                    Icons.Default.List, "Correct", tint = androidx.compose.ui.graphics.Color.Blue
                ) },
                label = { Text(text = "Enter List") },
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.state.height,
                onValueChange = { viewModel.changeHeight(it) },
                leadingIcon ={  Icon(Icons.Default.CalendarMonth, "Correct", tint = androidx.compose.ui.graphics.Color.Blue
                ) },
                label = { Text(text = "Enter month ") },)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                /**here*/  "Prediction: ${viewModel.state.lowerWeightBound}",
            )
            Spacer(modifier = Modifier.height(16.dp))

            Test(viewModel.state.team)
        }
    }

@Composable
fun Test(data: List<Float>) {
    val maxDataValue = data.maxOrNull() ?: 0f // Handle an empty list or list with 0 values
    val scale = 1000f / maxDataValue // Calculate scaling factor

    Canvas(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {
        val barWidth = 50f // Adjust for desired bar width

        data.forEachIndexed { index, value ->
            val barHeight = value * scale // Calculate bar height based on data and scaling

            drawRect(
                color = Color.Red,
                size = Size(barWidth, barHeight),
                topLeft = Offset( 80+ index *200f,y = 1400f - barHeight // Draw bars from top to bottom)
                )
            )
        }
    }
}