package com.example.Layer

import android.app.Application

class InventoryApplication: Application() {
    lateinit var  container:AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppContainer.AppDataContainer(this)
    }
}