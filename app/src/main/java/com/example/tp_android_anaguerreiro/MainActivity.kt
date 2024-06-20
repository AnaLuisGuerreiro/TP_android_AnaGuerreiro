package com.example.tp_android_anaguerreiro

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp_android_anaguerreiro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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

        welcomeText()

        // Logout button
        binding.logout.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        // Add new product button
        binding.newProduct.setOnClickListener {
            val i = Intent(this, AddNewTripActivity::class.java)
            startActivity(i)
        }


    }


    private fun welcomeText(){
        // Get username with
        val userName = intent.getStringExtra("username")?.split(" ")?.joinToString(" ") { it.capitalize() }

        // Modify the welcome text
        if(userName == null){
            binding.welcome.text = "Welcome!"
        } else{
            binding.welcome.text = "Welcome, ${userName}!"
        }
    }
}