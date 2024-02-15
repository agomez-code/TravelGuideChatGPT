package com.mkiperszmid.travelguideai.home.presentacion.component

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Captura de valores - barra de busqueda
@Composable
fun HomeSearchBar(
    onSearch: () -> Unit,
    placeholder: String,
    inputText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = inputText,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder)
        },
        modifier = modifier.background(color = Color.LightGray, shape = RoundedCornerShape(86.dp)),
        singleLine = true,
        trailingIcon = {
            HomeSearchButton(
                icon = Icons.Default.Search,
                onClick = onSearch,
                modifier = Modifier.padding(8.dp)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        )
    )
}

//Previsualización de los datos en la barra de búsqueda
@Preview
@Composable
fun HomSearchBarPreview() {
    HomeSearchBar(
        onSearch = {},
        placeholder = "Pais, Ciudad",
        inputText = "",
        onValueChange = {}
    )
}