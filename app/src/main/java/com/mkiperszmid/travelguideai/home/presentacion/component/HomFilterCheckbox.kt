package com.mkiperszmid.travelguideai.home.presentacion.component

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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