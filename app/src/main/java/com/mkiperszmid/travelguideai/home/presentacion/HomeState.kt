package com.mkiperszmid.travelguideai.home.presentacion

data class HomeState(
    val searchText: String = "",
    val showDialog: Boolean = false,
    val filterSettings: HomeFilterSettings = HomeFilterSettings(),
    val filterSettingsBackup: HomeFilterSettings = filterSettings
)
