package br.com.lucaspcs.aluvery.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    val image: String,
    val description: String? = null
) {

}
