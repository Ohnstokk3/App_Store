package com.example.Inventory.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.Inventory.Deatail_state
import com.example.Inventory.HomeBody
import com.example.Inventory.HomeDestination
import com.example.Inventory.ItemDetailsDestination
import com.example.Inventory.ItemEntryBody
import com.example.Inventory.ItemEntryDestination

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = ItemEntryDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeBody( navigateToItem={navController.navigate(ItemDetailsDestination.route)})
        }
        composable(route = ItemEntryDestination.route) {
            ItemEntryBody( navigateToHome={navController.navigate(HomeDestination.route)})
        }
        composable(route = ItemDetailsDestination.route){
            Deatail_state()
        }


    }
}
