package com.joses.scaffoldnav.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.joses.scaffoldnav.R
import kotlinx.serialization.Serializable

@Serializable
object ProfileScreen

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
   LazyColumn(
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       item {
           UserDetails(
               modifier = modifier
           )
       }
   }
}

@Composable
fun UserDetails(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_foreground),
            contentDescription = "User Image",
            modifier = Modifier
                .size(700.dp)
        )
        Text(
            text = "xJoses"
        )
    }
}

@Preview
@Composable
private fun UserPreview() {
    val nav = rememberNavController()
    ProfileScreen(navController = nav)
}