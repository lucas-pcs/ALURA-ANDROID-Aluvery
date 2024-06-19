package br.com.lucaspcs.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductItem()
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview(){
    ProductItem()
}

@Composable
fun ProductItem() {
    Column {
        Box(modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .background(Color.Blue))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null)
        Text(text = "Text 1")
        Text(text = "Text 2")
    }
}