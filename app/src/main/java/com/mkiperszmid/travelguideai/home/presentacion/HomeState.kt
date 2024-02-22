package com.mkiperszmid.travelguideai.home.presentacion

import com.mkiperszmid.travelguideai.home.domain.HomeFilterSettings

data class HomeState(
    val searchText: String = "",
    val showDialog: Boolean = false,
    val filterSettings: HomeFilterSettings = HomeFilterSettings(),
    val filterSettingsBackup: HomeFilterSettings = filterSettings
)
