package br.com.lucaspcs.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucaspcs.aluvery.R
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts
import java.math.BigDecimal


@Composable
fun ProductSection(sectionName: String, products: List<Product>) {
    Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {

        Text(
            text = sectionName, modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight(400),
            fontSize = 18.sp
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(state = rememberScrollState())
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier)
            for(p in products) {
                ProductItem(product = p)
            }
            Spacer(modifier = Modifier)
        }

    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun ProductSectionPreview() {
    ProductSection("Promoções", sampleProducts)
}
