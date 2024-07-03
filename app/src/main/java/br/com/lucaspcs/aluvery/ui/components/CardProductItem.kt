package br.com.lucaspcs.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.R
import br.com.lucaspcs.aluvery.extensions.toBrazilianCurrency
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    expanded: Boolean = false
) {

    var isDescriptionExpandedState by remember {
        mutableStateOf(expanded)
    }
    val textOverflow = if (isDescriptionExpandedState) {
        TextOverflow.Visible
    } else {
        TextOverflow.Ellipsis
    }
    val maxLines = if (isDescriptionExpandedState) {
        Int.MAX_VALUE
    } else {
        2
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 150.dp)
            .clickable {
                isDescriptionExpandedState = !isDescriptionExpandedState
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            AsyncImage(
                model = product.image, contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.purple_200))
                    .padding(16.dp)
            ) {
                Text(text = product.name)
                Text(text = product.price.toBrazilianCurrency())
            }

            product.description?.let {
                Text(
                    text = product.description,
                    modifier = Modifier
                        .padding(16.dp),
                    maxLines = maxLines,
                    overflow = textOverflow,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(sampleProducts[1])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardProductItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(sampleProducts[0])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardProductItemWithDescriptionPreviewExpanded() {
    AluveryTheme {
        Surface {
            CardProductItem(sampleProducts[0],Modifier,true)
        }
    }
}
