package com.example.networksample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networksample.api.ApiClient
import com.example.networksample.model.Country
import kotlinx.coroutines.launch

/**
 * Created by Ajay Vamsee on 6/30/2023.
 * Time : 16:38
 */
class CountryViewModel : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _loading = MutableLiveData<Boolean>()
    val loading:LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error:LiveData<String> = _error

    fun fetchCountries() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response = ApiClient.apiService.getCountries()
                _countries.value = response
            } catch (e: Exception) {
                // Handle error
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}