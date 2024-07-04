package br.com.lucaspcs.aluvery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts
import br.com.lucaspcs.aluvery.sampledata.sampleSections
import br.com.lucaspcs.aluvery.ui.components.CardProductItem
import br.com.lucaspcs.aluvery.ui.components.ProductSection
import br.com.lucaspcs.aluvery.ui.components.SearchTextFieldItem
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {

        var text by remember {
            mutableStateOf(searchText)
        }

        SearchTextFieldItem(searchText = text, onSearchTextChange = {
            newValue ->
            text = newValue
            Log.d("TAG", "HomeScreen: text: $text")
        })

        val searchedProductList = remember(text) {
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(
                        text,
                        ignoreCase = true,
                    ) ||
                            product.description?.contains(
                                text,
                                ignoreCase = true,
                            ) ?: false
                }
            } else emptyList()
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (text.isBlank()) {
                for (section in sections) {
                    val sectionDescription = section.key
                    val sectionProducts = section.value
                    item {
                        ProductSection(
                            sectionName = sectionDescription,
                            products = sectionProducts,
                            modifier = Modifier
                        )
                    }
                }
            } else {
                items(searchedProductList) { product ->
                    CardProductItem(
                        product = product,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                sections = sampleSections,
                searchText = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                sections = sampleSections,
                searchText = "hamb"
            )
        }
    }
}