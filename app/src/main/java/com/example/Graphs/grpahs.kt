package com.example.Graphs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**Graphics test*/
@Composable
fun Graph() {
    Canvas(modifier = Modifier.fillMaxSize()) {

        drawCircle(
            Color.Red,
            center= Offset(
                260.dp.toPx(),
                /**x direction*/
                /**x direction*/
                /**x direction*/
                /**x direction*/
                70.dp.toPx()
                /**y direction*/
                /**y direction*/
                /**y direction*/
                /**y direction*/
            )
        )
    }
}

