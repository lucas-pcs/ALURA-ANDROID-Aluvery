package br.com.lucaspcs.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.R
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts
import br.com.lucaspcs.aluvery.sampledata.sampleSections
import br.com.lucaspcs.aluvery.ui.components.ProductSection
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        for(section in sections){
            val sectionDescription = section.key
            val sectionProducts = section.value
            ProductSection(sectionName = sectionDescription, products = sectionProducts)
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