package br.com.lucaspcs.aluvery

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    FirstComposable()
                }
            }
        }

    }
}

@Preview(name = "FirstComposablePreview",
    showSystemUi = true)
@Composable
fun FirstComposablePreview() {
    AluveryTheme {
        Surface {
            FirstComposable()
        }
    }
}

@Composable
fun FirstComposable() {
    AluveryTheme {
        Surface {
            Text("First Text")
        }
    }
}

