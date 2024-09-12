package com.joses.scaffoldnav.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
object DetailsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .height(75.dp)
                    .padding(top = 8.dp, start = 2.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }

                },
                title = {
                    Text(
                        text = "Post Details",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(start = 8.dp, top = 4.dp)
                    )
                }
            )
        },
        bottomBar = {
//            Should not be there
        }
    ) { pad ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues = pad)
        ) {
            item {
                DetailsUi()
            }
        }
    }
}

@Composable
fun DetailsUi(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "Details Page"
            )
            Text(
                text = "Yes, you can change the image extension from .svg to .xml.\n" +
                        "\n" +
                        "However, it's important to understand that changing the extension alone won't alter the image's content or format. SVG files are already XML-based, so renaming the extension to .xml won't fundamentally change the file's structure or functionality.\n" +
                        "\n" +
                        "Here's a breakdown of what happens when you change the extension:\n" +
                        "\n" +
                        "SVG to XML: Renaming an SVG file to .xml won't affect its content. The file will still contain the SVG code, which is XML-based. This might not be desirable if you're expecting the file to be interpreted as a different XML format.\n" +
                        "XML to SVG: Renaming an XML file to .svg won't necessarily make it a valid SVG file. The XML content must adhere to the SVG specification for it to be recognized and rendered as an SVG image.\n" +
                        "If your goal is to ensure that the file is recognized as an SVG image, it's not necessary to change the extension. SVG files are typically recognized by their .svg extension.\n" +
                        "\n" +
                        "If you have a specific reason for wanting to change the extension, please provide more details so I can offer tailored advice."
            )
        }
    }
}
