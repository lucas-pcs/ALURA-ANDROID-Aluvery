package br.com.lucaspcs.aluvery.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductFormScreen("Android")
                }
            }
        }
    }
}

@Composable
fun ProductFormScreen(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Criando o produto",
            modifier = modifier,
            fontSize = 28.sp
        )

        var url by remember {
            mutableStateOf("")
        }
        TextField(
            value = url,
            onValueChange = {
                url = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Url da imagem")
            }
        )

        var name by remember {
            mutableStateOf("")
        }
        TextField(value = name, onValueChange = {
            name = it
        },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nome") })

        var price by remember {
            mutableStateOf("")
        }
        TextField(value = price, onValueChange = {
            price = it
        },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Valor") })

        var description by remember {
            mutableStateOf("")
        }
        TextField(value = description, onValueChange = {
            description = it
        },
            modifier = Modifier.fillMaxWidth()
                .heightIn(min = 100.dp),
            label = { Text(text = "Descrição") })

        Button(onClick = {},
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Salvar")
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductFormScreenPreview() {
    AluveryTheme {
        ProductFormScreen("Android")
    }
}