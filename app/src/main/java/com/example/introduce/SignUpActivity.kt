package com.example.introduce

import android.content.Intent
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
            val idSignUp = idEditText.text.toString()
            val passwordSignUp = passwordEditText.text.toString()

            if (nameEditText.text.isEmpty() || idEditText.text.isEmpty() || passwordEditText.text.isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_msg_checkinfo), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                val intent = Intent (this@SignUpActivity, SignInActivity::class.java)
                intent.putExtra("id_signup", idSignUp)
                intent.putExtra("password_signup", passwordSignUp)
                setResult(RESULT_OK, intent)

                if (!isFinishing) finish()
            }
        }
    }
}