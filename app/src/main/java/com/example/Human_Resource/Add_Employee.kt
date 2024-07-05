package com.example.Human_Resource

import android.graphics.drawable.Icon
import android.text.style.ClickableSpan
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Graphs.BmiState
import com.example.Graphs.MainViewModel
import com.example.main_app_store.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Employee(viewModel: EmployeeViewModel = viewModel()) {
        Column(
                modifier = Modifier.fillMaxSize().padding(start = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
        ) {
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
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = viewModel.state.Phone,
                        onValueChange = { viewModel.PhoneNumber(it) },
                        leadingIcon = {
                                Icon(
                                        Icons.Default.Person,
                                        "Correct",
                                        tint = androidx.compose.ui.graphics.Color.Blue
                                )
                        },
                        label = { Text("PHONE NUMBER") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Row {
                        Checkbox(checked = viewModel.state.checked, onCheckedChange = { viewModel.Checked( it)  })

                        Text(text = "Allow employee to clock in")
                }

        }

}