package com.mkiperszmid.travelguideai.home.presentacion.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeFilterDialog (
    modifier: Modifier = Modifier
){
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        modifier = modifier.fillMaxWidth(),
        buttons = {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                Text(text = "Aplicar")
            }
        }, text = {
            Column (
                modifier = modifier.fillMaxWidth()
            ){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text (text = "Personas")
                    HomeFilterIncrement(number = 1, onMinus = { /*TODO*/ }, onPlus = { /*TODO*/ })
                }
            }
        }, shape = RoundedCornerShape(30.dp)
    )
}

@Preview
@Composable
fun HomeFilterDialogPreview() {
    HomeFilterDialog()
}