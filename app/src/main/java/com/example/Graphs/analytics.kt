package com.example.Graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.Inventory.ItemUiState

@Composable
fun Analytics(viewModel: AnalyticsViewModel = viewModel(),
       ){
    var calculate by remember { mutableStateOf("") }/**Remember user input*/

    val calculateList:List<String> = calculate.split(",")/**Convert to list and use , as indicator for the next number the user entered */

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
    val c= b/numbersInTheArray
    val prediction=msum*6+c/**here we are using 6 but we can let the user enter a value they want*/

    Column(modifier = Modifier.padding(40.dp)) {

        OutlinedTextField(value=calculate, onValueChange = {calculate=it})
        Text(" sum x: $xsum")
        Text("sum y: $ysum")
        Text("total xy: $xysum")
        Text("total square: $square")
        Text("total sum 1: $sumof")
        Text("total sum 2: $sumof2")
        Text("total m: $msum")
        Text("total b: $b")
        Text("total c: $c")
        Text("total prediction: $prediction")}
    }
