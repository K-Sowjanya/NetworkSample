package com.example.networksample.model

/**
 * Created by Ajay Vamsee on 6/30/2023.
 * Time : 16:35
 */
data class Country(
    val name: CountryName,
    val region: String,
    val subregion: String,
    val area: Double,
    val population: Long,
    val flags: Flags
)

data class CountryName(
    val common: String,
    val official: String,
    val nativeName: Map<String, NativeName>
)

data class NativeName(
    val official: String,
    val common: String
)

data class Flags(
    val svg: String,
    val png: String
)
