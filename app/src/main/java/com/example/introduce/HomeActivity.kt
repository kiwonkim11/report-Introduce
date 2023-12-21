package com.example.introduce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

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

        val iv_login = findViewById<ImageView>(R.id.iv_home_login)

        val iv = when((1..5).random()) {
            1 -> R.drawable.ic_login1
            2 -> R.drawable.ic_login2
            3 -> R.drawable.ic_login3
            4 -> R.drawable.ic_login4
            else -> R.drawable.ic_login5
        }

        iv_login.setImageDrawable(ResourcesCompat.getDrawable(resources, iv, null))
    }
}