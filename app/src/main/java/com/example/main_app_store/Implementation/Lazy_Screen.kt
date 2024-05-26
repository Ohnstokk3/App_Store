package com.example.main_app_store.Implementation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.main_app_store.Data.Boxi
import com.example.main_app_store.Data.Cardi
import com.example.main_app_store.Data.Items
import com.example.main_app_store.Data.Store
import com.example.main_app_store.Data.Texti

//Todo: Add navigation to the RowItems and imagesample
//Todo: Add navigation that connects First page and Secound page
//Todo: Add proper search for First page

@Composable
fun Cardi_Main(cardi: Cardi) {

    Column( modifier = Modifier.fillMaxSize().padding(start = 16.dp)) {
        Card(

            modifier = Modifier
                .size(width = 350.dp, height = 60.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)

        ) {

            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
            {
                Icon(
                    cardi.image, contentDescription = "Top menue icon", modifier = Modifier
                        .align(Alignment.CenterStart)
                )
                Icon(
                    cardi.secound_Image, contentDescription = "Top menue icon", modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ) {

                    Text(
                        text = "${cardi.Master}", modifier = Modifier.padding(start = 40.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun Box_main(boxi: Boxi) {
    Column(modifier = Modifier.fillMaxSize().padding(start = 15.dp)){
        //Todo: Change the Box color using material theme//
        /**check if you can use a card with the box **/
        /**check if you can use a card with the box **/
        Box(modifier = Modifier.size(180.dp).clip(RoundedCornerShape(16.dp)).background(Color.LightGray,)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .clip(RoundedCornerShape(25.dp))
                ,
                painter = painterResource(boxi.image),
                contentDescription ="",
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "${boxi.Cycle}", modifier = Modifier.padding(start = 10.dp, top = 120.dp)
            )
            Text(
                text = "${boxi.Project}", modifier = Modifier.padding(start = 10.dp, top = 140.dp)
            )

        }
    }
}
@Composable
fun imagesample(store: Store){
    /**add Navigation **/
    Row(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.BottomStart)
    ){
        /**add Navigation **/
        /**add Navigation **/
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clip(RoundedCornerShape(25.dp))
                .clickable {/**add Navigation **/  },
            painter = painterResource(id=store.image),
            contentDescription ="",
            contentScale = ContentScale.Crop,

            )

        Text(
            text = "${store.words}", modifier = Modifier.padding(start = 10.dp)
        )
    }
}
@Composable
fun textSample(text: Texti) {
    Row(modifier = Modifier.fillMaxWidth().padding(14.dp)){
        Text(
            text="${text.mainText}"
        )


    }
}
@Composable
fun RowItems(items: Items){
    /**add Navigation **/
    Column(
        modifier = Modifier

            .padding(top=15.dp),

        ){
        /**add Navigation **/
        /**add Navigation **/
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable {/**add Navigation **/  },
            painter = painterResource(id=items.image),
            contentDescription ="",
            contentScale = ContentScale.Crop
        )
        Text(
            text = "${items.description}"
        )
        Spacer(modifier = Modifier.height(8.dp));

    }
}
