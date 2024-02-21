package com.mkiperszmid.travelguideai.home.presentacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkiperszmid.travelguideai.home.presentacion.component.HomeFilterButton
import com.mkiperszmid.travelguideai.home.presentacion.component.HomeFilterDialog
import com.mkiperszmid.travelguideai.home.presentacion.component.HomeSearchBar

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if(state.showDialog) {
        HomeFilterDialog()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "A donde viajas?")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            HomeSearchBar(
                onSearch = {
                    viewModel.search()
                },
                placeholder = "Pais, CIudad",
                inputText = state.searchText,
                onValueChange = { viewModel.onSearchTextChange(it) }
            )
            HomeFilterButton(onClick = { viewModel.onFilterClick() })
        }
    }
}