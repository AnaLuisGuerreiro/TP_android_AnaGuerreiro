package com.example.tp_android_anaguerreiro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

            val resultIntent = Intent().apply {
                putExtra("origin", origin)
                putExtra("destination", destination)
                putExtra("departureDate", departureDate)
                putExtra("returnDate", returnDate)
                putExtra("tripPrice", tripPrice)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        binding.confirmTrip.setOnClickListener {
            val destination = intent.getStringExtra("destination")

            // Redirect to main view
            val toMain = Intent(this, MainActivity::class.java)
            startActivity(toMain)

            // Message of confirmation
            Toast.makeText(this, "Your trip to $destination is confirmed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAllInfo() {
        // User inputs
        val origin = intent.getStringExtra("origin")
        val destination = intent.getStringExtra("destination")
        val departureDate = intent.getStringExtra("departureDate")
        val returnDate = intent.getStringExtra("returnDate")
        val tripPrice = intent.getStringExtra("tripPrice")

        // Text views to complete with user inputs
        binding.originTextView.text = origin
        binding.destinationTextView.text = destination
        binding.departureDateTextView.text = departureDate
        binding.returnDateTextView.text = returnDate
        if (tripPrice != null) {
            binding.tripPriceTextView.text = if (tripPrice.isNotEmpty()) "$tripPrice€" else ""
        }
    }
}
