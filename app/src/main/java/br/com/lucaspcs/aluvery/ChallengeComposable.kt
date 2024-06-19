package br.com.lucaspcs.aluvery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ComposableTest() {
    Row(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(100.dp)
                .background(Color.Blue)
        ) {

        }
        Column(
            modifier = Modifier
        ) {
            Text(
                modifier = Modifier
                    .width(200.dp)
                    .background(Color.LightGray)
                    .padding(8.dp),
                text = "Test 1"
            )
            Text(text = "Test 2",
                modifier = Modifier.padding(8.dp))

        }
    }
}