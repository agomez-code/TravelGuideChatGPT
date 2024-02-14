package com.mkiperszmid.travelguideai.home.presentacion

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Text(text = "Soy la Home Screen - AGOMEZ.CODE!")
}
