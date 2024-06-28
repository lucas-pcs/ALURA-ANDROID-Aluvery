package br.com.lucaspcs.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.R
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts
import br.com.lucaspcs.aluvery.ui.components.ProductSection
import java.math.BigDecimal


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductSection("Promoções", sampleProducts)
        ProductSection(
            "Doces", listOf(
                Product(
                    name = "Chocolate",
                    price = BigDecimal("5.90"),
                    image = R.drawable.placeholder
                )
            )
        )
        ProductSection("Bebidas", sampleProducts)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}