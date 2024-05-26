package com.example.main_app_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.main_app_store.Front_End.Box1
import com.example.main_app_store.Front_End.Home
import com.example.main_app_store.Front_End.Inventory2
import com.example.main_app_store.Front_End.InventoryText
import com.example.main_app_store.Front_End.Top_Menue
import com.example.main_app_store.Front_End.Welcome_Text
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
                    Top_Menue()
                    Welcome_Text()
                    Box1()
                    InventoryText()
                    Inventory2()
                }
            }
        }
    }
}

