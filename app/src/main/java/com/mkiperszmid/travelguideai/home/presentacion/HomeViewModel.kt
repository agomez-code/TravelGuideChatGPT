package com.mkiperszmid.travelguideai.home.presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkiperszmid.travelguideai.BuildConfig
import com.mkiperszmid.travelguideai.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun search() {
        viewModelScope.launch {
            repository.getTravelGuide(state.searchText).onSuccess {
                println(it)
            }.onFailure {
                println("Hubo un error")
            }
        }
    }

    fun onSearchTextChange(newText: String) {
        state = state.copy(
            searchText = newText
        )
    }

    fun onFilterClick() {
        state = state.copy(
            showDialog = true
        )
    }

    fun onFilterDismiss() {
        state = state.copy(
            showDialog = false
        )
    }

}
