package com.example.Graphs

import android.provider.ContactsContract.Data

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.Inventory.ItemDetails
import com.example.Inventory.ItemUiState
import com.example.Layer.ItemsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
data class BmiState(
val weight:String = "",
val height:String = "",
val BMI:Float = 0f,
val lowerWeightBound:Double=0.0,
val higherWeightBound:Float = 0f
)

class MainViewModel: ViewModel() {
    var state by mutableStateOf(BmiState())

    private fun calculateWeightBounds(){


        val calculateList:List<String> = state.height.split(",")/**Convert to list and use , as indicator for the next number the user entered */

        val ConvertListIntoDouble=calculateList.map { it.toDoubleOrNull()?:0.0 }/**We use the map operator to convert the String list
        into a Double List or the user enters a letter the considered a null */
        var xysum=0.0
        var  xsum=0.0
        var square=0.0
        var ysum=0.0
        val y=ConvertListIntoDouble

        val x = intArrayOf(1,2,3,4,5,6,7)
        val numbersInTheArray=x.size
        val test = if (ConvertListIntoDouble.size >=6) {
            for (i in y.indices) {
                // Multiply corresponding elements and add to the total product
                ysum +=y[i]
            }
            for (i in y.indices) {
                // Multiply corresponding elements and add to the total product
                xysum += x[i] *y[i]
            }
            for(num in x.indices){
                square+=x[num]*x[num]
            }
            for(num in x){
                xsum+=num
            }
        } else {
            0.0 // Or a default value you prefer
        }
        val sumof=numbersInTheArray*xysum-xsum*ysum
        val sumof2=numbersInTheArray*square-xsum*xsum
        val msum =sumof/sumof2
        val b =ysum-msum*xsum
        val ctotal= b/numbersInTheArray
        val prediction=msum*6+ctotal/**here we are using 6 but we can let the user enter a value they want*/
        val lWeight = (prediction)/***here**/
        state = state.copy(
            lowerWeightBound = lWeight,

            )
    }




    fun changeHeight(height:String){
        state = state.copy(
            height = height
        )
        calculateWeightBounds()
    }
}




