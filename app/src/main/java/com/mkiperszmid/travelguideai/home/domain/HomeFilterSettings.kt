package com.mkiperszmid.travelguideai.home.domain

data class HomeFilterSettings(
    val people: Int = 1,
    val restaurants : Boolean = false,
    val museums: Boolean = false
)
