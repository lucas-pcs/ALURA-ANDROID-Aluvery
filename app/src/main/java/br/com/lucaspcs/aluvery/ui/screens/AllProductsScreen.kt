package br.com.lucaspcs.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucaspcs.aluvery.sampledata.sampleAllProducts
import br.com.lucaspcs.aluvery.ui.components.ProductItem

@Composable
fun AllProductsScreen() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = "Todos produtos",
                fontSize = 32.sp,
            )
        }

        items(sampleAllProducts) { product ->
            ProductItem(product = product)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun AllProductsScreenPreview() {
    AllProductsScreen()
}