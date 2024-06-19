package br.com.lucaspcs.aluvery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme

@Preview(showBackground = true)
@Composable
fun ComposeLayoutsTestPreview() {
    ComposeLayoutsTest()
}

@Composable
fun ComposeLayoutsTest() {
    Column(modifier = Modifier
        .background(color = Color.Cyan)
        .padding(all = 8.dp)) {
        Text(text = "Text 1")
        Text(text = "Text 2")
        Row {
            Text(text = "Text 1")
            Text(text = "Text 2")
        }
    }
}

@Preview(name = "FirstComposablePreview")
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

