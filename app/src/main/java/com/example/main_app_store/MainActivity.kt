package com.example.main_app_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.Graphs.Analyticsg
import com.example.Graphs.DrawCubic


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            DrawCubic()

        }
    }
}

