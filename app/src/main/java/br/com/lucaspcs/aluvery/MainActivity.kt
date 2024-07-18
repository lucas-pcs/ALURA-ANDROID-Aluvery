package br.com.lucaspcs.aluvery

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.lucaspcs.aluvery.sampledata.sampleSections
import br.com.lucaspcs.aluvery.ui.screens.HomeScreen
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme
import br.com.lucaspcs.aluvery.activities.ProductFormActivity
import br.com.lucaspcs.aluvery.dao.ProductDao
import br.com.lucaspcs.aluvery.sampledata.sampleCandies
import br.com.lucaspcs.aluvery.sampledata.sampleDrinks
import br.com.lucaspcs.aluvery.sampledata.sampleProducts

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    val sampleSections = mapOf(
        "Todos os Produtos" to dao.productList,
        "Promoções" to sampleProducts,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onFabClick = {
                    startActivity(Intent(this, ProductFormActivity::class.java))
                }, {
                    HomeScreen(sections = sampleSections)
                }
            )
        }
    }
}

@Composable
private fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    AluveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AppPreview() {
    App {
        HomeScreen(sections = sampleSections)
    }
}