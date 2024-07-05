package com.example.Human_Resource

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

data class empoyeeState(
    val Phone:String="",
    val Name:String="",
    val checked:Boolean=true,
    val shift: List<String> = listOf("Night shift", "Day shift"),
    val expanded:Boolean=false
)
class  EmployeeViewModel: ViewModel() {
    var state by mutableStateOf(empoyeeState())
         fun ChangeName(Name:String){
                state=state.copy(
                    Name=Name
                )

            }
    fun PhoneNumber(Phone: String){

        state=state.copy(
           Phone = Phone
        )
    }
    fun Checked(checked: Boolean){
state=state.copy(
    checked = checked
)
    }
}
