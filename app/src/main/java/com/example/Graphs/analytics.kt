package com.example.Graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
/**linear regression*/
@Composable
fun ShowArraySums(modifier: Modifier = Modifier) {
    val x = intArrayOf(1,2,3,4,5,6,7)
    val y = doubleArrayOf(1.5, 3.8, 6.7, 9.0, 11.2, 13.6, 16.0) // Array of doubles
    var xsum=0
    var ysum = 0.0
    var xysum = 0.0
var square=0.0
// Iterate through the arrays using a for loop
    for (i in x.indices) {
        // Multiply corresponding elements and add to the total product
       xysum += x[i] *y[i]
    }

for(num in x.indices){
    square+=x[num]*x[num]
}

for(num in x){
    xsum+=num
}
    for (num in y) {
        ysum += num
    }
    val sumof=xysum-xsum*ysum
 val sumof2=square-xsum*xsum
val simof3 =sumof/sumof2
Column {
    Text(" sum x: $xsum")
    Text("sum y: $ysum")
    Text("total xy: $xysum")
    Text("total square: $square")
    Text("total: $sumof")
    Text("total: $sumof2")
    Text("total: $simof3")


}
}