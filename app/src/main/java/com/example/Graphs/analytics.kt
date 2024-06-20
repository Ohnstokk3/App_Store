package com.example.Graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun array(){
    val numbers= intArrayOf(1,2,3,4,5,6,7)
    var store=1
    for (num in numbers){
        store*=num
    }
    Column(modifier = Modifier) {
        Text(text = "the answer is $store")
    }
}