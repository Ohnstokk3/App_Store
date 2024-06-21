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
    val numbersInTheArray=x.size
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

    val sumof=numbersInTheArray*xysum-xsum*ysum
 val sumof2=numbersInTheArray*square-xsum*xsum
val msum =sumof/sumof2
    val b =ysum-msum*xsum
    val c= b/numbersInTheArray
    val pridiction=msum*6+c/**here we are using 6 but we can let the user enter a value they want*/
Column {
    Text(" sum x: $xsum")
    Text("sum y: $ysum")
    Text("total xy: $xysum")
    Text("total square: $square")
    Text("total sum 1: $sumof")
    Text("total sum 2: $sumof2")
    Text("total m: $msum")
    Text("total b: $b")
    Text("total c: $c")
    Text("total pridiction: $pridiction")/**user can enter a number as the x value and it will give the y corresponding y value */


}
}