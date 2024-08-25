package com.example.Human_Resource

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.Layer.ItemsRepository
import com.example.Layer.User
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

data class empoyeeState(
    val id: Int = 0,
    val Name:String="",
    val birthday: Date = Date()

)

fun empoyeeState.touser(): User = User(
    id = id,
    name = Name,
    birthday = birthday
)
@HiltViewModel
class  EmployeeViewModel @Inject constructor(val itemsRepository: ItemsRepository): ViewModel() {

    var state by mutableStateOf(empoyeeState())
    fun ChangeName(Name:String){
        state=state.copy(
            Name=Name
        )

    }

    suspend fun save(){
        itemsRepository.insertuser(state.touser())
    }

}
