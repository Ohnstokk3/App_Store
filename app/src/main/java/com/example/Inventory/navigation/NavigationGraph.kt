package com.example.Inventory.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.Human_Resource.Add_EmployeeDestination
import com.example.Human_Resource.Body
import com.example.Human_Resource.Employee
import com.example.Human_Resource.resultDestination

import com.example.Inventory.Deatails_state
import com.example.Inventory.HomeBody
import com.example.Inventory.HomeDestination
import com.example.Inventory.ItemDetailsDestination
import com.example.Inventory.ItemDetailsScreen
import com.example.Inventory.ItemEntryBody
import com.example.Inventory.ItemEntryDestination
import com.example.Inventory.QueryDestination


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
        composable(route = resultDestination.route) {
            Body(navigateToItems = { navController.navigate(HomeDestination.route) })
        }
        composable(route = Add_EmployeeDestination.route) {
            Employee(navigatemain = { navController.navigate(HomeDestination.route) })
        }
        composable(route = QueryDestination.route) {
            Deatails_state(navigateTomain = { navController.navigate(HomeDestination.route) })
        }
        composable(route = HomeDestination.route) {
            HomeBody(

                navigateToItem ={
                    navController.navigate("${ItemDetailsDestination.route}/${it}")
                }
            )
        }
        composable(
            route = ItemEntryDestination.route
        ) {
            ItemEntryBody(navigateToHome = { navController.navigate(HomeDestination.route) })
        }
        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemDetailsScreen(

            )

        }
    }
}
