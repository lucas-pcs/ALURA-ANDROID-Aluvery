package br.com.lucaspcs.aluvery.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucaspcs.aluvery.R
import br.com.lucaspcs.aluvery.dao.ProductDao
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductFormScreen(onSaveClick = {newProduct ->
                        Log.d("TAG", "onCreate: save clicked")
                        dao.save(newProduct)
                        finish()
                    })
                }
            }
        }
    }
}

@Composable
fun ProductFormScreen(onSaveClick: (Product) -> Unit = {}, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Criando o produto",
            modifier = modifier,
            fontSize = 28.sp
        )

        var url by remember {
            mutableStateOf("")
        }

        if (url.isNotBlank()) {
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.error)
            )
        }

        TextField(
            value = url,
            onValueChange = {
                url = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Url da imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            ),
        )

        var name by remember {
            mutableStateOf("")
        }
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nome") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        var price by remember {
            mutableStateOf("")
        }
        val formatter = remember {
            DecimalFormat("#.##")
        }
        TextField(
            value = price,
            onValueChange = {
                try {
                   price = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException) {
                    if(it.isEmpty()){
                        price = it
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Valor") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
        )

        var description by remember {
            mutableStateOf("")
        }
        TextField(
            value = description,
            onValueChange = {
                description = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = { Text(text = "Descrição") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            ),
        )

        Button(
            onClick = {

                var convertedPrice: BigDecimal
                try {
                    convertedPrice = BigDecimal(price)
                } catch (e: Exception) {
                    convertedPrice = BigDecimal.ZERO
                }
                val newProduct = Product(
                    name = name,
                    price = convertedPrice,
                    image = url,
                    description = description
                )

                Log.d("ProductFormActivity", "ProductFormScreen: $newProduct")

                onSaveClick(newProduct)

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductFormScreenPreview() {
    AluveryTheme {
        ProductFormScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductFormScreenPreviewWithImage() {
    AluveryTheme {
        ProductFormScreen()
    }
}