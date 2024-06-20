package com.example.tp_android_anaguerreiro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp_android_anaguerreiro.databinding.ActivityAddNewTripBinding

class AddNewTripActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAddNewTripBinding.inflate(layoutInflater)
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

        binding.addTrip.setOnClickListener {
            // Text fields for a new trip
            val origin = capitalizeFirstLetter(binding.origin.text.toString())
            val destination = capitalizeFirstLetter(binding.destination.text.toString())
            val departureDate = capitalizeFirstLetter(binding.departureDate.text.toString())
            val returnDate = capitalizeFirstLetter(binding.returnDate.text.toString())
            val tripPrice = capitalizeFirstLetter(binding.tripPrice.text.toString())

            // Checking if any field is empty, only adds with all info
            when {
                origin.isEmpty() -> {
                    Toast.makeText(this, "Please enter the origin.", Toast.LENGTH_SHORT).show()
                }
                destination.isEmpty() -> {
                    Toast.makeText(this, "Please enter the destination.", Toast.LENGTH_SHORT).show()
                }
                departureDate.isEmpty() -> {
                    Toast.makeText(this, "Please enter the departure date.", Toast.LENGTH_SHORT).show()
                }
                returnDate.isEmpty() -> {
                    Toast.makeText(this, "Please enter the return date.", Toast.LENGTH_SHORT).show()
                }
                tripPrice.isEmpty() -> {
                    Toast.makeText(this, "Please enter the price of the trip.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val i = Intent(this, TripDetailsActivity::class.java).apply {
                        putExtra("origin", origin)
                        putExtra("destination", destination)
                        putExtra("departureDate", departureDate)
                        putExtra("returnDate", returnDate)
                        putExtra("tripPrice", tripPrice)
                    }
                    startActivity(i)
                }
            }


        }
    }

    private fun capitalizeFirstLetter(text: String): String {
        return text.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }

}
