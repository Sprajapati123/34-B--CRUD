package com.example.crud_34b.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.R
import com.example.crud_34b.databinding.ActivitySensorDashBoardBinding

class SensorDashBoardActivity : AppCompatActivity() {
    lateinit var sensorDashBoardBinding: ActivitySensorDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sensorDashBoardBinding = ActivitySensorDashBoardBinding.inflate(layoutInflater)
        setContentView(sensorDashBoardBinding.root)

        sensorDashBoardBinding.btnSensorList.setOnClickListener{
            var intent = Intent(this@SensorDashBoardActivity,
                SensorListActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSensorList)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}