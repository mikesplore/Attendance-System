package com.mike.attendancesystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage


@Composable
fun LoadingImageFromInternet() {

    AsyncImage(
        model = "http://0.0.0.0:8080/cars/car2.jpg",
        contentDescription = "Translated description of what the image contains"
    )

}
