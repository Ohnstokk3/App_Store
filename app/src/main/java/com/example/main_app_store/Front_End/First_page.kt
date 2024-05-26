package com.example.main_app_store.Front_End

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main_app_store.Implementation.RowItems
import com.example.main_app_store.Implementation.imagesample
import com.example.main_app_store.Implementation.textSample
import com.example.main_app_store.R
import com.example.main_app_store.repository.ImageRepository
import com.example.main_app_store.repository.ItemsRepository
import com.example.main_app_store.repository.NavigationRepository
import com.example.main_app_store.repository.TextRepository
import com.example.main_app_store.ui.theme.Main_App_StoreTheme

//Todo: Add scroll to First and Secound screen so you can scroll down and see more content
//Todo: fix the positioning of the search bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){
    Main_App_StoreTheme  {
        var selected by remember{
            mutableStateOf(0)
        }
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background

        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        NavigationRepository.forEachIndexed { index, nav ->
                            NavigationBarItem(
                                selected = index==selected,
                                onClick ={selected= index},
                                icon = {
                                    BadgedBox(badge ={
                                        if(nav.badges!=0) {
                                            Badge{
                                                Text(text = nav.badges.toString())
                                            }
                                        }else if (nav.hasNews){
                                            Badge ()
                                        }
                                    }
                                    ){
                                        Icon(
                                            imageVector =
                                            if (index==selected)
                                                nav.selectedIcon
                                            else
                                                nav.unselectedIcon,
                                            contentDescription = nav.title
                                        )
                                    }
                                },
                                label = {
                                    Text(text = nav.title)
                                }


                            )
                        }
                    }
                },


                ){
                    padding->
                Column (modifier = Modifier.padding()){SearchBar()
                    TextLazyRow()
                    recommendedText()
                    IconLazyRow()
                    Suggestedforyou()
                    TextandimageLazyGrid()
                }
            }
        }
    }
}
@Composable
fun Suggestedforyou(){
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top){
        Text("Suggested for you", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 20.dp, start = 7.dp))
    }
}

@Composable
fun recommendedText(){
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,){
        Text("Recommended for you", fontWeight = FontWeight.Bold,fontSize = 20.sp, modifier = Modifier.padding(top = 7.dp, start = 7.dp))
    }
}
@OptIn(ExperimentalMaterial3Api::class)

//work on this part //
@Preview
@Composable
fun SearchBar(
){/** fix the positioning of the search bar **/
    Row (horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ){
        var value by remember { mutableStateOf("") }

        TextField(
            value = value,
            onValueChange = { value = it },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
        )

        Icon(
            painterResource(id= R.drawable.outline_arrow_circle_up_24),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}
//work on this as well //
@Composable
fun TextandimageLazyGrid() {
    val ImageRepository = ImageRepository()
    val getAllData = ImageRepository.getAllData()

    LazyHorizontalGrid(rows = GridCells.Fixed(3), modifier = Modifier.padding(
        top=7.dp, bottom = 100.dp, start = 7.dp)

    ) {
        items(items = getAllData) { store ->
            imagesample(store=store)
        }
    }
}

@Composable
fun TextLazyRow() {
    val TextRepository = TextRepository()
    val getText = TextRepository.getText()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.Top,
        modifier = Modifier.padding(top = 30.dp)
    ) {
        items(items = getText) { text ->
            textSample(text = text)
        }
    }
}


@Composable
fun IconLazyRow() {
    val ItemsRepository = ItemsRepository()
    val getAlData = ItemsRepository.getAllData()
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 4.dp, start = 7.dp)) {
        items(items = getAlData) { item ->
            RowItems(items = item,)
        }
    }
}

