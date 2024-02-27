package com.mkiperszmid.travelguideai.home.presentacion.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomFilterCheckbox (
    onClick: () -> Unit,
    isChecked: Boolean,
    modifier: Modifier = Modifier
){
    val icon = if (isChecked) Icons.Default.Check else null
    HomFilterSettingsButton(
        onClick = onClick,
        icon = icon,
        modifier = modifier
    )
}

@Preview
@Composable
fun HomFilterCheckboxPreview() {
    HomFilterCheckbox({}, true)
}