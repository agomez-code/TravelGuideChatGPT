package com.mkiperszmid.travelguideai.home.presentacion

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mkiperszmid.travelguideai.home.domain.model.Region
import com.mkiperszmid.travelguideai.home.presentacion.component.HomeFilterButton
import com.mkiperszmid.travelguideai.home.presentacion.component.HomeFilterDialog
import com.mkiperszmid.travelguideai.home.presentacion.component.HomePopularFilter
import com.mkiperszmid.travelguideai.home.presentacion.component.HomeSearchBar

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if (state.showDialog) {
        HomeFilterDialog(onDismiss = {
            viewModel.onFilterDismiss()
        }, filterSettings = state.filterSettings, onAction = {
            viewModel.onSettingChange(it)
        })
    }

    BackHandler(state.chatReply != null) {
        viewModel.onBackPress()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "A donde viajas?",
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HomeSearchBar(onSearch = {
                    viewModel.search()
                },
                    placeholder = "Pais, Ciudad",
                    inputText = state.searchText,
                    onValueChange = { viewModel.onSearchTextChange(it) })
                HomeFilterButton(onClick = { viewModel.onFilterClick() })
            }
            Spacer(modifier = Modifier.height(32.dp))
        }


        state.chatReply?.let {
            item {
                Text(text = it)
            }
        } ?: item {
            if (state.popularPlaces.isNotEmpty()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Lugares Populares",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    HomePopularFilter(modifier = Modifier.fillMaxWidth(),
                        selectedRegion = state.selectedRegion,
                        selectRegion = {
                            viewModel.onRegionSelect(it)
                        })
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        items(state.popularPlaces) {
                            Box(
                                modifier = Modifier.size(180.dp, 250.dp)
                                    .clickable {
                                        viewModel.onSearchTextChange("${it.country}, ${it.city}")
                                    }.clip(RoundedCornerShape(20.dp))
                            ) {
                                AsyncImage(
                                    model = it.image,
                                    contentDescription = "${it.country} ${it.city}",
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = "${it.country}, ${it.city}",
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    modifier = Modifier.align(Alignment.BottomStart).padding(12.dp)
                                )
                                TextButton(onClick = {
                                    viewModel.onSearchTextChange("${it.country}, ${it.city}")
                                }) {

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}