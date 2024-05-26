package com.example.main_app_store.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import com.example.main_app_store.Data.Boxi
import com.example.main_app_store.Data.Cardi
import com.example.main_app_store.R

//Todo:Changethe image icons to something more appropriate
class CardiRepository {
    fun getCardi(): List<Cardi> {
        return listOf(
            Cardi(
                Master = "Master Item",
                secound_Image= Icons.Filled.ArrowForward,
                /**here->*/ image = Icons.Filled.Home

            ),
            Cardi(
                Master = "QOH",
                secound_Image= Icons.Filled.ArrowForward,
                /**here->*/  image = Icons.Filled.Call
            ),
            Cardi(
                Master = "Printing",
                secound_Image= Icons.Filled.ArrowForward,
                /**here->*/  /**here->*/
                image = Icons.Filled.Notifications
            ),

            )
    }
}
//Todo:Change the images to something more appropriate
class BoxRepository{
    fun getBox():List<Boxi>{
        return listOf(
            Boxi(
                image= R.drawable.capcut,
                Cycle="Cycle Count",
                Project="3 Open Projects"
            ),
            Boxi(
                image= R.drawable.capcut,
                Cycle="Receiving",
                Project="3 Open Projects"
            ),
            Boxi(
                image= R.drawable.capcut,
                Cycle="Transfer",
                Project="3 Open Projects"
            ),
            Boxi(
                image= R.drawable.capcut,
                Cycle="Adjustment",
                Project="3 Open Projects"
            ),

            )
    }
}
