package br.com.lucaspcs.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.lucaspcs.aluvery.R

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

@Preview
@Composable
private fun ProductItemKitPreview() {
    ProductItemKit()
}
