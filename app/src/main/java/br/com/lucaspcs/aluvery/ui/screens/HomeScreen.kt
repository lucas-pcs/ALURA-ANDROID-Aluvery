package br.com.lucaspcs.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleSections
import br.com.lucaspcs.aluvery.ui.components.ProductSection
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        for (section in sections) {
            val sectionDescription = section.key
            val sectionProducts = section.value
            item {
                ProductSection(sectionName = sectionDescription, products = sectionProducts)
            }
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