package com.example.country_projectexample.retrofit


import com.example.country_projectexample.datamodel.Country_Response
import retrofit2.Call
import retrofit2.http.GET

interface CountriesApi {
    @GET("v3.1/all?fields=name,capital,translations,flags")
    fun getCountries(): Call<Country_Response>
}
