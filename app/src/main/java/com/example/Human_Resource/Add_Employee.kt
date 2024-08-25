package com.example.Human_Resource


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.Inventory.navigation.NavigationDestination
import kotlinx.coroutines.launch

object Add_EmployeeDestination : NavigationDestination {
        override val route = "Add_Employee"

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Employee(viewModel: EmployeeViewModel = hiltViewModel(), navigatemain: () -> Unit) {
        Column(
                modifier = Modifier.fillMaxSize().padding(start = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
        ) {
                val coroutineScope = rememberCoroutineScope()
                TextField(
                        value = viewModel.state.Name,
                        onValueChange = { viewModel.ChangeName(it) },
                        leadingIcon = {
                                Icon(
                                        Icons.Default.Person,
                                        "Correct",
                                        tint = androidx.compose.ui.graphics.Color.Blue
                                )
                        },
                        label = { Text("EMPLOYEE NAME") }
                )
                Button(
                        onClick = {
                                coroutineScope.launch {
                                        viewModel.save()

                                }
                        }
                ){
                        Text(text = "enter name")
                }


        }

}