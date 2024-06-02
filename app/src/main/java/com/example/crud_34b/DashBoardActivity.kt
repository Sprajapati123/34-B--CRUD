package com.example.crud_34b

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_34b.adapter.ProductAdapter
import com.example.crud_34b.databinding.ActivityDashBoardBinding
import com.example.crud_34b.model.ProductModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DashBoardActivity : AppCompatActivity() {
    lateinit var dashBoardBinding: ActivityDashBoardBinding

    var database : FirebaseDatabase = FirebaseDatabase.getInstance()

    var ref : DatabaseReference = database.reference.child("products")

    var productList = ArrayList<ProductModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dashBoardBinding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(dashBoardBinding.root)

        dashBoardBinding.floatingActionButton.setOnClickListener {
            var intent = Intent(this@DashBoardActivity,
                AddProductActivity::class.java)
            startActivity(intent)
        }

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                productList.clear()
                Log.d("snapshot data ",snapshot.children.toString())
                for(eachData in snapshot.children){
                    var product = eachData.getValue(ProductModel::class.java)
                    if(product!=null){
                        Log.d("data from firebase",product.name)
                        Log.d("data from firebase",product.description)
                        Log.d("data from firebase",product.price.toString())
                        productList.add(product)
                    }
                }
                var adapter = ProductAdapter(this@DashBoardActivity,productList)

                dashBoardBinding.recyclerView.layoutManager =
                    LinearLayoutManager(this@DashBoardActivity)

                dashBoardBinding.recyclerView.adapter = adapter


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}