package com.example.main_app_store.Data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class Cardi(
    val image: ImageVector,
    val secound_Image: ImageVector,
    val Master:String,

    )
data class Boxi(
    @DrawableRes val image:Int,
    val Cycle:String,
    val Project:String,
)
