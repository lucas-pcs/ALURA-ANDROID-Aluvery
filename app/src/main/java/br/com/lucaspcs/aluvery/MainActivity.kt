package br.com.lucaspcs.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucaspcs.aluvery.extensions.toBrazilianCurrency
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductSection("Promoções")
        ProductSection("Doces")
        ProductSection("Bebidas")
    }
}


@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun ProductSectionPreview() {
    ProductSection("Promoções")
}

@Composable
fun ProductSection(sectionName: String) {
    Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {

        Text(
            text = sectionName, modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight(400),
            fontSize = 18.sp
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(state = rememberScrollState())
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier)
            ProductItem(Product("Burguer", BigDecimal(19.90), R.drawable.burger))
            ProductItem(Product("Fries", BigDecimal(9.90), R.drawable.fries))
            ProductItem(Product("Pizza", BigDecimal(15.90), R.drawable.pizza))
            Spacer(modifier = Modifier)
        }

    }
}

@Composable
fun ProductItemPreview() {
    ProductItem(Product("Pizza", BigDecimal(15.90), R.drawable.pizza))
}

@Composable
fun ProductItem(product: Product) {

    val imageSize = 100.dp

    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .heightIn(250.dp, 300.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(id = R.color.purple_500),
                                colorResource(id = R.color.teal_200)
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(y = imageSize / 2)
                        .clip(CircleShape)
                        .size(imageSize)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(imageSize / 2))

            Column(

            ) {

                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(16.dp)
                )

                Text(
                    text = product.price.toBrazilianCurrency(),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )

                Spacer(modifier = Modifier.padding(all = 8.dp))

            }

        }
    }

}

@Composable
fun ProductItemKitPreview() {
    ProductItemKit()
}


@Composable
fun ProductItemKit() {
    val productItemKitWidth = 300.dp
    val productItemKitHeight = 150.dp
    val boxWidth = productItemKitWidth / 4

    Surface(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .width(productItemKitWidth)
                .height(productItemKitHeight)
                .clip(shape = RoundedCornerShape(8.dp))
        ) {

            Box(
                modifier = Modifier
                    .width(boxWidth)
                    .fillMaxHeight()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.purple_700),
                                colorResource(id = R.color.purple_200)
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = boxWidth / 2)
                        .align(Alignment.Center)
                        .border(
                            width = 2.dp,
                            brush = Brush.verticalGradient(
                                listOf(
                                    colorResource(id = R.color.purple_200),
                                    colorResource(id = R.color.purple_700)
                                )
                            ),
                            shape = CircleShape
                        )
                        .clip(shape = CircleShape)

                )
            }

            Spacer(modifier = Modifier.size(boxWidth / 2))

            Text(
                text = LoremIpsum(50).values.first(),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically),
                maxLines = 6,
                overflow = TextOverflow.Ellipsis

            )
        }
    }

}