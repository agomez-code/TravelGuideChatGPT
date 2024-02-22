package com.mkiperszmid.travelguideai.home.presentacion

data class HomeFilterSettings(
    val people: Int = 1,
    val restaurants : Boolean = true,
    val museums: Boolean = false
)
