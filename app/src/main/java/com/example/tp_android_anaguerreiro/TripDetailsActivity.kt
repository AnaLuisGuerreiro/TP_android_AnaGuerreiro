package com.example.tp_android_anaguerreiro

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp_android_anaguerreiro.databinding.ActivityTripDetailsBinding

class TripDetailsActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityTripDetailsBinding.inflate(layoutInflater)
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

        getAllInfo()

            binding.back.setOnClickListener {
                val origin = intent.getStringExtra("origin")
                val destination = intent.getStringExtra("destination")
                val departureDate = intent.getStringExtra("departureDate")
                val returnDate = intent.getStringExtra("returnDate")
                val tripPrice = intent.getStringExtra("tripPrice")

                var i = Intent().apply {
                    putExtra("origin", origin)
                    putExtra("destination", destination)
                    putExtra("departureDate", departureDate)
                    putExtra("returnDate", returnDate)
                    putExtra("tripPrice", tripPrice)
                }
                setResult(1,intent)
                finish()
            }

            binding.confirmTrip.setOnClickListener {  }

    }

    private fun getAllInfo(){
        // User inputs
        val origin = intent.getStringExtra("origin")
        val destination = intent.getStringExtra("destination")
        val departureDate = intent.getStringExtra("departureDate")
        val returnDate = intent.getStringExtra("returnDate")
        val tripPrice = intent.getStringExtra("tripPrice")

        // Text views to complete with user inputs
        binding.originTextView.setText("${origin}")
        binding.destinationTextView.setText("${destination}")
        binding.departureDateTextView.setText("${departureDate}")
        binding.returnDateTextView.setText("${returnDate}")
        binding.tripPriceTextView.setText("${tripPrice}")
        setResult(1,intent)
        finish()




    }
}