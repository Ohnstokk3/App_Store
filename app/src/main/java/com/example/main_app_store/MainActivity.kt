package com.example.main_app_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.Graphs.Analytics


import com.example.Imagepicker.PhotoSelectorView

import com.example.Inventory.ItemEntryBody
import com.example.Inventory.navigation.InventoryNavHost
import com.example.Layer.Item
import com.example.main_app_store.Front_End.Home

import com.example.main_app_store.ui.theme.Main_App_StoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main_App_StoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Analytics()
                }
            }
        }
    }
}

