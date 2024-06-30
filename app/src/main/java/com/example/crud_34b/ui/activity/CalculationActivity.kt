package com.example.crud_34b.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.R
import com.example.crud_34b.databinding.ActivityCalculationBinding

class CalculationActivity : AppCompatActivity() {
    lateinit var calculationBinding: ActivityCalculationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        calculationBinding = ActivityCalculationBinding.inflate(layoutInflater)
        setContentView(calculationBinding.root)

        calculationBinding.btnSum.setOnClickListener {
            var a = calculationBinding.number1.text.toString().toInt()
            var b = calculationBinding.number2.text.toString().toInt()

            var sum = a+b

            calculationBinding.resultText.text = sum.toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}