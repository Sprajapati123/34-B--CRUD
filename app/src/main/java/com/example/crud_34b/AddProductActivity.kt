package com.example.crud_34b

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.databinding.ActivityAddProductBinding
import com.example.crud_34b.model.ProductModel
import com.google.firebase.database.FirebaseDatabase

class AddProductActivity : AppCompatActivity() {
    var firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()
    var ref = firebaseDatabase.reference.child("products")
    lateinit var addProductBinding: ActivityAddProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        addProductBinding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(addProductBinding.root)

        addProductBinding.btnPost.setOnClickListener {
            var name : String = addProductBinding.editTextProductName.text.toString()
            var price : Int = addProductBinding.editTextProductPrice.text.toString().toInt()
            var desc : String = addProductBinding.editTextProductDesc.text.toString()

            var id = ref.push().key.toString()

            var data = ProductModel(id,name,price,desc)

            ref.child(id).setValue(data).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(applicationContext,"Data added",
                        Toast.LENGTH_LONG).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,it.exception?.message,
                        Toast.LENGTH_LONG).show()
                }
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}