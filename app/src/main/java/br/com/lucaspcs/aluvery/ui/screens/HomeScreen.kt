package br.com.lucaspcs.aluvery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts
import br.com.lucaspcs.aluvery.sampledata.sampleSections
import br.com.lucaspcs.aluvery.ui.components.CardProductItem
import br.com.lucaspcs.aluvery.ui.components.ProductSection
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column {
        var textVar by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = textVar,
            onValueChange = { newValue: String ->
                Log.i("TAG", "HomeScreen: $newValue")
                textVar = newValue
            },
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            items(sampleProducts) {product ->
                CardProductItem(
                    product = product,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

//            for (section in sections) {
//                val sectionDescription = section.key
//                val sectionProducts = section.value
//                item {
//                    ProductSection(sectionName = sectionDescription, products = sectionProducts)
//                }
//            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}