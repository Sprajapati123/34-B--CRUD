package com.example.crud_34b.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_34b.R
import com.example.crud_34b.model.ProductModel

class ProductAdapter(var data:ArrayList<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var productName : TextView = view.findViewById(R.id.lblName)
        var productPrice : TextView = view.findViewById(R.id.lblPrice)
        var productDesc : TextView = view.findViewById(R.id.lblDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}