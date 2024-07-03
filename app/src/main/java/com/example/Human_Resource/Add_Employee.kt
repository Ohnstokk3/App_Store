package com.example.Human_Resource

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.Graphs.BmiState
import com.example.main_app_store.R


@Composable
fun Employee(){
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().padding(start = 10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center) {
        TextField(
            value = text,
            onValueChange = { text = it },
            leadingIcon ={  Icon(Icons.Default.Person, "Correct", tint = androidx.compose.ui.graphics.Color.Blue
            ) },
            label = { Text("EMPLOYEE NAME") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = text,
            onValueChange = { text = it },
            leadingIcon ={  Icon(Icons.Default.Phone, "Correct", tint = androidx.compose.ui.graphics.Color.Blue
            ) },
            label = { Text("Mobile Number") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Mobile Number") }

        )

    }
}

