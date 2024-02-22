package com.mkiperszmid.travelguideai.home.presentacion

import com.mkiperszmid.travelguideai.home.domain.model.HomeFilterSettings
import com.mkiperszmid.travelguideai.home.domain.model.Region

data class HomeState(
    val searchText: String = "",
    val showDialog: Boolean = false,
    val filterSettings: HomeFilterSettings = HomeFilterSettings(),
    val filterSettingsBackup: HomeFilterSettings = filterSettings,
    val chatReply: String? = null,
    val selectedRegion: Region = Region.TODAS
)
