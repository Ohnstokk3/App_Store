package com.example.main_app_store.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import com.example.main_app_store.Data.Items
import com.example.main_app_store.Data.Nav
import com.example.main_app_store.Data.Store
import com.example.main_app_store.Data.Texti
import com.example.main_app_store.R

//Todo:Change the images for the whole first page to something more appropriate every image here needs change

class ItemsRepository{
    fun getAllData():List<Items>{
        return listOf(
            Items(

                image = R.drawable.snapchat,
                description = "Snapchat\n4.0*"),
            Items(

                image = R.drawable.capcut,
                description = "CapCut-Video\n4.4*"),
            Items(

                image = R.drawable.disney,
                description = "Disney+\n4.4*"),
            Items(

                image = R.drawable.twitter,
                description = "x\n3.5"),
            Items(

                image = R.drawable.premier_league,
                description = "premier league \nofficial app\n3.2*"),
        )
    }
}
class ImageRepository{
    fun getAllData():List<Store>{
        return listOf(
            Store(
                image = R.drawable.apple_music,
                words = "Apple Music \n Apple Music & audio\n 3.2* "),
            Store(
                image = R.drawable.apple_music,
                words = "pokemon Go  \n" +
                        " Adventure\n" +
                        " 4.1* "),
            Store(
                image = R.drawable.microsoft,
                words = "Microsoft Outlook\nCorporation\n4.5*"),
            Store(
                image = R.drawable.pokimon_go,
                words = "Sleep logo"),
            Store(
                image = R.drawable.opera,
                words = "store logo"),
            Store(
                image = R.drawable.brave,
                words = "Apple log "),
            Store(
                image = R.drawable.brave,
                words = "Pintres logo"),
            Store(
                image = R.drawable.pokimon_go,
                words = "Uber Logo"),

        )
    }
}
val NavigationRepository=listOf(
    Nav(
        title="Home",
        route = "Home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),
    Nav(
        title="Post",
        route = "post",
        selectedIcon= Icons.Filled.Call,
        unselectedIcon = Icons.Outlined.Call,
        hasNews = false,
        badges=0
    ),
    Nav(
        title="Notifications",
        route = "notifications",
        selectedIcon= Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        badges=5
    ),
    Nav(
        title="Profile",
        route = "profile",
        selectedIcon= Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
        hasNews = false,
        badges=0
    ),

    )
class TextRepository{
    fun getText():List<Texti>{
        return listOf(
            Texti(
                id=0,
                mainText = "For you"
            ),
            Texti(
                id=1,
                mainText = "Top charts"
            ),
            Texti(
                id=2,
                mainText = "Children"
            ),
            Texti(
                id=3,
                mainText = "Categories"
            ),
            Texti(
                id=3,
                mainText = "charts and graphs"
            ),)
    }
}
