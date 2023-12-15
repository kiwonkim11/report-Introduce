package com.example.introduce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val idData = intent.getStringExtra("id")
        val seeIdData = findViewById<TextView>(R.id.txt_id_confirm)
        val btnFinish = findViewById<Button>(R.id.btn_finish)

        seeIdData.setText(idData)
        btnFinish.setOnClickListener {
            finish()
        }
    }
}