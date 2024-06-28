package br.com.lucaspcs.aluvery.sampledata

import br.com.lucaspcs.aluvery.R
import br.com.lucaspcs.aluvery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product("Burguer", BigDecimal(15.90), R.drawable.burger),
    Product("Pizza", BigDecimal(15.90), R.drawable.pizza),
    Product("Fritas", BigDecimal(15.90), R.drawable.fries)
)