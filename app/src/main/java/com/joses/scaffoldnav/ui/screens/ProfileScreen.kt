package com.joses.scaffoldnav.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
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
   LazyColumn {
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
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_foreground),
            contentDescription = "User Image"
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