package com.mkiperszmid.travelguideai.home.presentacion.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkiperszmid.travelguideai.home.presentacion.HomeFilterDialogAction
import com.mkiperszmid.travelguideai.home.domain.model.HomeFilterSettings
import com.mkiperszmid.travelguideai.ui.theme.DarkGreen

@Composable
fun HomeFilterDialog(
    onDismiss: () -> Unit,
    filterSettings: HomeFilterSettings,
    onAction: (HomeFilterDialogAction) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(onDismissRequest = onDismiss, modifier = modifier.fillMaxWidth(), buttons = {
        Button(
            onClick = { onAction(HomeFilterDialogAction.OnApplyClick) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .defaultMinSize(minHeight = 53.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkGreen,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(text = "Aplicar")
        }
    }, text = {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Personas")
                HomeFilterIncrement(number = filterSettings.people,
                    onMinus = { onAction(HomeFilterDialogAction.OnPeopleMinus) },
                    onPlus = { onAction(HomeFilterDialogAction.OnPeoplePlus) })
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Restaurantes")
                HomFilterCheckbox(
                    onClick = { onAction(HomeFilterDialogAction.OnRestaurantsClick) },
                    isChecked = filterSettings.restaurants
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Museos")
                HomFilterCheckbox(
                    onClick = { onAction(HomeFilterDialogAction.OnMuseumsClick) },
                    isChecked = filterSettings.museums
                )
            }
        }
    }, shape = RoundedCornerShape(30.dp)
    )
}

@Preview
@Composable
fun HomeFilterDialogPreview() {
    HomeFilterDialog({}, filterSettings = HomeFilterSettings(), {})
}