package com.mkiperszmid.travelguideai.home.presentacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkiperszmid.travelguideai.BuildConfig
import com.mkiperszmid.travelguideai.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    init {

        println("Soy el home view model - AGOMEZ.CODE!")
        println("Mi api key es: ${BuildConfig.API_KEY}")

        viewModelScope.launch {
            repository.getTravelGuide().onSuccess {
                println("EXITO!")
                println(it)
            }.onFailure {
                println("ERROR!")
                println("Hubo un error")
            }
        }

    }
}
