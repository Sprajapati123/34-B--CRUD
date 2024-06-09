package com.example.crud_34b.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.crud_34b.model.ProductModel
import com.example.crud_34b.repository.ProductRepository

class ProductViewModel(val repository: ProductRepository) : ViewModel() {
    fun uploadImage(imageUrl: Uri, callback: (Boolean, String?, String?) -> Unit) {
        repository.uploadImage(imageUrl) { success, imageUrl, imageName ->
            callback(success, imageUrl, imageName)
        }
    }

    fun addProduct(productModel: ProductModel, callback: (Boolean, String?) -> Unit) {
        repository.addProduct(productModel, callback)
    }
}