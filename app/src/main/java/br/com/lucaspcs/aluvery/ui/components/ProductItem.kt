package br.com.lucaspcs.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucaspcs.aluvery.R
import br.com.lucaspcs.aluvery.extensions.toBrazilianCurrency
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts
import coil.compose.AsyncImage
import java.math.BigDecimal

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
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    modifier = Modifier
                        .offset(y = imageSize / 2)
                        .clip(CircleShape)
                        .size(imageSize)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
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

@Preview
@Composable
private fun ProductItemPreview() {
    ProductItem(sampleProducts[0])
}