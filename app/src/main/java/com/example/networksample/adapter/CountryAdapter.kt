package com.example.networksample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networksample.R
import com.example.networksample.databinding.CountryItemBinding
import com.example.networksample.model.Country

/**
 * Created by Ajay Vamsee on 6/30/2023.
 * Time : 16:39
 */
class CountryAdapter(var countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CountryItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class ViewHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) {
            binding.countryName.text = "Country Name: ${country.name.common}"
            binding.region.text = "Region: ${country.region}"
            binding.subregion.text = "${country.subregion}"
            binding.area.text = "Area: ${country.area.toString()}"
            binding.population.text = "Population: ${country.population.toString()}"

            Glide.with(binding.root)
                .load(country.flags.png)
                .placeholder(R.drawable.default_image)
                .into(binding.flagImage)
        }
    }
}
