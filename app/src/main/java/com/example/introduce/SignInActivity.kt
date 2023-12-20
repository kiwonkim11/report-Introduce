package com.example.introduce

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private fun setResultSignUp() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val idSignUp = result.data?.getStringExtra("id_signup") ?: ""
                val passwordSignUp = result.data?.getStringExtra("password_signup") ?: ""
                idEditText.setText(idSignUp)
                passwordEditText.setText(passwordSignUp)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val idEditText = findViewById<EditText>(R.id.et_id)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnSignUp = findViewById<Button>(R.id.btn_signup)

        btnLogin.setOnClickListener{
            val id = idEditText.text.toString()

            if (idEditText.text.isEmpty() || passwordEditText.text.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            else Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}