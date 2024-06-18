package com.example.tp_android_anaguerreiro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp_android_anaguerreiro.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.buttonLogin.setOnClickListener {
            val userName = binding.userName.text.toString()
            val userPassword = binding.userPassword.text.toString()

            when {
                userName == "admin" && userPassword == "password123" -> {
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra("username", userName)
                    startActivity(i)
                }
                userName == "it" && userPassword == "pastelNata" -> {
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra("username", userName)
                    startActivity(i)
                }
                userName == "ana" && userPassword == "anaDeveloper" -> {
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra("username", userName)
                    startActivity(i)
                }
                else -> {
                    binding.userName.setText("")
                    binding.userPassword.setText("")
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}