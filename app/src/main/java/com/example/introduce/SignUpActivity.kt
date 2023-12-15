package com.example.introduce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val nameEditText = findViewById<EditText>(R.id.et_name)
        val idEditText = findViewById<EditText>(R.id.et_id_signup)
        val passwordEditText = findViewById<EditText>(R.id.et_password_signup)
        val btnSignUp = findViewById<Button>(R.id.btn_signup_finish)

        btnSignUp.setOnClickListener{
            if (nameEditText.text.isEmpty() || idEditText.text.isEmpty() || passwordEditText.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            finish()
        }
    }
}