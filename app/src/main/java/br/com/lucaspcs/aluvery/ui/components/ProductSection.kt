package br.com.lucaspcs.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts


@Composable
fun ProductSection(sectionName: String, products: List<Product>, modifier: Modifier) {
    Column(modifier = modifier.padding(top = 8.dp, bottom = 8.dp)) {

        Text(
            text = sectionName, modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight(400),
            fontSize = 18.sp
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        ) {
            items(products) { product ->
                ProductItem(product = product, modifier = Modifier)
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun ProductSectionPreview() {
    ProductSection("Promoções", sampleProducts, Modifier)
}
