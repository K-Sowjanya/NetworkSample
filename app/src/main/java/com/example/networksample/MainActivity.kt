package com.example.networksample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networksample.adapter.CountryAdapter
import com.example.networksample.databinding.ActivityMainBinding
import com.example.networksample.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var countryViewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryAdapter = CountryAdapter(emptyList())
        binding.recyclerView.adapter = countryAdapter

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        countryViewModel = ViewModelProvider(this)[CountryViewModel::class.java]

        countryViewModel.countries.observe(this) { countries ->
            countryAdapter.countries = countries
            countryAdapter.notifyDataSetChanged()
        }

        countryViewModel.loading.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        countryViewModel.error.observe(this) {

        }

        countryViewModel.fetchCountries()
    }
}
