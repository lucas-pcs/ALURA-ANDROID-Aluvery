package br.com.lucaspcs.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import br.com.lucaspcs.aluvery.model.Product
import br.com.lucaspcs.aluvery.sampledata.sampleProducts

class ProductDao {
    fun save(newProduct: Product) {
        products.add(newProduct)
    }

    companion object {
        //private val products = sampleProducts.toMutableList()
        private val products = mutableStateListOf<Product>()
    }

    val productList: List<Product> = products.toList()

}