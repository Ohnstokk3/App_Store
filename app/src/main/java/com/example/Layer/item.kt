package com.example.Layer
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int,
    val infohday: Date?
)
@Entity
data class User( @PrimaryKey(autoGenerate = true)
                 val id:Int=0,
                 val name: String,
                 val birthday: Date?)
