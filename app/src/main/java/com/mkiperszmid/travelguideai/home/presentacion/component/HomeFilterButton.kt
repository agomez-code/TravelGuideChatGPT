package com.mkiperszmid.travelguideai.home.presentacion.component

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkiperszmid.travelguideai.ui.theme.BackgroundFilterGray
import com.mkiperszmid.travelguideai.ui.theme.FilterColor

@Composable
fun HomeFilterButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier.background(
            color = BackgroundFilterGray,
            shape = RoundedCornerShape(13.dp)
        )
    ) {
        Icon(
            imageVector = Icons.Default.Tune,
            contentDescription = "filter",
            tint = FilterColor
            )
    }
}

@Preview
@Composable
fun HomeFilterButtonPreview() {
    HomeFilterButton({})
}

