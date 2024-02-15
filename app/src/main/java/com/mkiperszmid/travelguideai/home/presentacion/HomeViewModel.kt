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

    init {
        viewModelScope.launch {
            repository.getTravelGuide().onSuccess {
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
}
