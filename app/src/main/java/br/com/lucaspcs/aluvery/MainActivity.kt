package br.com.lucaspcs.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.lucaspcs.aluvery.sampledata.sampleSections
import br.com.lucaspcs.aluvery.ui.screens.AllProductsScreen
import br.com.lucaspcs.aluvery.ui.screens.HomeScreen
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    Column {
                        App()
                    }
                }
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun App() {
    HomeScreen(sampleSections)
    //AllProductsScreen()
}