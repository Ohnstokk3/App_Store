package com.example.main_app_store.Front_End

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main_app_store.Implementation.Box_main
import com.example.main_app_store.Implementation.Cardi_Main
import com.example.main_app_store.repository.BoxRepository
import com.example.main_app_store.repository.CardiRepository

//Todo:Add a Drop menue in Top_Menue
//Todo:Correct LazyColumn Positioning
@Composable
fun Top_Menue() {
    val MyAppIcons = Icons.Rounded

    Row(  horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,){
        Icon(Icons.Rounded.Menu, contentDescription = "Top menue icon", modifier = Modifier.padding(start=16.dp, top = 20.dp))
    }
}
@Composable
fun Welcome_Text(){
    Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(top = 60.dp, start = 16.dp)){
        Text(text = "Welcome,Nateli",fontWeight = FontWeight.Bold,fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "OPERATIONS")
    }
}

@Composable
fun Box1() {
    val BoxRepository = BoxRepository()
    val getBox = BoxRepository.getBox()
    LazyVerticalGrid(   columns = GridCells.Fixed(2),verticalArrangement = Arrangement.spacedBy(26.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp), modifier = Modifier.padding(top = 140.dp, end = 20.dp)) {
        items(items = getBox) { boxi ->
            Box_main(boxi = boxi)
        }
    }
}
@Composable
fun InventoryText(){
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize().padding(start = 16.dp, top = 325.dp)){
        Text("Inventory", fontWeight = FontWeight.Bold,fontSize = 20.sp,)
    }
}
@Composable
fun Inventory2() {
    val CardiRepository = CardiRepository()
    val getCardi = CardiRepository.getCardi()
    LazyColumn (verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(top = 580.dp)
        /** Not Acceptable find a way to move LazyColumn down with out using padding**/

    ){
        items(items = getCardi) {cardi ->
            Cardi_Main(cardi=cardi)
        }
    }
}

