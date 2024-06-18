package com.example.tp_android_anaguerreiro

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp_android_anaguerreiro.databinding.ActivityAddNewTripBinding

class AddNewTripActivity : AppCompatActivity() {
    private lateinit var result: ActivityResultLauncher<Intent>

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

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                if (data != null) {
                    binding.origin.setText(data.getStringExtra("origin"))
                    binding.destination.setText(data.getStringExtra("destination"))
                    binding.departureDate.setText(data.getStringExtra("departureDate"))
                    binding.returnDate.setText(data.getStringExtra("returnDate"))
                    binding.tripPrice.setText(data.getStringExtra("tripPrice"))
                }
            }
        }

        binding.addTrip.setOnClickListener {
            val origin = binding.origin.text.toString()
            val destination = binding.destination.text.toString()
            val departureDate = binding.departureDate.text.toString()
            val returnDate = binding.returnDate.text.toString()
            val tripPrice = binding.tripPrice.text.toString()


            val i = Intent(this,TripDetailsActivity::class.java).apply{
                putExtra("origin", origin)
                putExtra("destination", destination)
                putExtra("departureDate", departureDate)
                putExtra("returnDate", returnDate)
                putExtra("tripPrice", tripPrice)
            }

            result.launch(i)
        }


    }
}