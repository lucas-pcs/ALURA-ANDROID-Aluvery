package br.com.lucaspcs.aluvery.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SearchTextFieldItem(searchText: String, onSearchTextChange: (String) -> Unit) {

    OutlinedTextField(
        value = searchText,
        onValueChange = { newValue ->
            Log.i("TAG", "HomeScreen: $newValue")
            onSearchTextChange(newValue)
        },
        modifier = Modifier
         //   .align(alignment = Alignment.CenterHorizontally)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(100),

        // slot API
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "search icon")
        },
        label = {
            Text(text = "Produto")
        },
        placeholder = {
            Text(text = "O que você procura ?")
        }

    )
}