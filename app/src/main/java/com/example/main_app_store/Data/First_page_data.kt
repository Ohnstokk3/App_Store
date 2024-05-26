package com.example.main_app_store.Data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class Texti(

    val id:Int,
    val mainText:String
)
data class Items(
    @DrawableRes val image:Int,
    val description:String,
)
data class Store(
    @DrawableRes val image:Int,
    val words:String,
)
data class Nav(
    val title:String,
    val route:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews:Boolean,
    val badges:Int,
)