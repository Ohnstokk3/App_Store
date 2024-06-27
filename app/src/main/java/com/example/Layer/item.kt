package com.example.Layer
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int,

)

@Entity(tableName = "result")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prediction: Double,
)