package com.joses.scaffoldnav

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joses.scaffoldnav.ui.screens.DetailsScreen
import com.joses.scaffoldnav.ui.screens.DetailsUi
import com.joses.scaffoldnav.ui.screens.HomeScreen
import com.joses.scaffoldnav.ui.screens.ProfileScreen

@Composable
fun AppNav(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar {
                NavBar(
                    navController = navController
                )
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = HomeScreen
        ) {
            composable<HomeScreen> {
                HomeScreen(
                    modifier = Modifier
                        .padding(padding),
                    navController = navController
                )
            }

            composable<ProfileScreen> {
                ProfileScreen(
                    modifier = Modifier
                        .padding(padding),
                    navController = navController
                )
            }

            composable<DetailsScreen> {
                DetailsScreen(
                    modifier = Modifier
                        .padding(padding),
                    navController = navController
                )
            }

        }

    }
}

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var isSelected by rememberSaveable { mutableIntStateOf(0) }

   NavigationBar {
       bottomNavItem.forEachIndexed { index, bottomNavItem ->
           NavigationBarItem(
               selected = index == isSelected,
               icon = { if (isSelected == index) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon },
               onClick = {
                   navController.navigate(bottomNavItem.route)
                   isSelected = index
               },
               label = {
                   Text(
                       text = bottomNavItem.name
                   )
               }
           )
       }

   }
}

val bottomNavItem = listOf(
    BottomNavItem(
        name = "Home",
        route = HomeScreen,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavItem(
        name = "Profile",
        route = ProfileScreen,
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle
    )
)

data class BottomNavItem(
    val name: String,
    val route: Any,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)
