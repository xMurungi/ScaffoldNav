package com.joses.scaffoldnav.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
   LazyColumn {
       items(15) {
           PostDetails(
               navController = navController
           )
       }
   }
}

@Composable
fun PostDetails(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { navController.navigate(DetailsScreen) }
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Build something 100 people love, not something 1 million people kind of like."
            )
        }
    }
}
