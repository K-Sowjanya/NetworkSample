package com.example.networksample.api

import com.example.networksample.model.Country
import retrofit2.http.GET

/**
 * Created by Ajay Vamsee on 6/30/2023.
 * Time : 16:37
 */
interface ApiService {
    @GET("all")
    suspend fun getCountries(): List<Country>
}