package com.example.crud_34b.repository

import android.net.Uri
import com.example.crud_34b.model.ProductModel

interface ProductRepository {

    fun uploadImage(imageUrl : Uri,callback: (Boolean, String?,String?) -> Unit)
    fun addProduct(productModel: ProductModel,callback :(Boolean,String?) -> Unit)
}