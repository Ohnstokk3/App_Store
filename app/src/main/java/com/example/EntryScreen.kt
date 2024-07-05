package com.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.main_app_store.R


@Composable
fun EntryScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(start = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {  Image(
            painter = painterResource(id = R.drawable.disney),
            contentDescription = "",
            contentScale = ContentScale.Fit,

            )

            Image(modifier = Modifier.padding(start = 20.dp),
                painter = painterResource(id = R.drawable.microsoft),
                contentDescription = "",
                contentScale = ContentScale.Fit,

                )
            Image(modifier = Modifier.padding(start = 20.dp),
                painter = painterResource(id = R.drawable.brave),
                contentDescription = "",
                contentScale = ContentScale.Fit,

                )
        }

    }
}

