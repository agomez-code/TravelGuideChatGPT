package com.mkiperszmid.travelguideai.home.presentacion

sealed interface HomeFilterDialogAction {
    object OnApplyClick: HomeFilterDialogAction
    object OnRestaurantsClick: HomeFilterDialogAction
    object OnMuseumsClick: HomeFilterDialogAction
    object OnPeoplePlus: HomeFilterDialogAction
    object OnPeopleMinus: HomeFilterDialogAction

}