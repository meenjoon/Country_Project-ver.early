package com.example.country_projectexample.retrofit


import com.example.country_projectexample.datamodel_detail.Country_Response_Detail
import com.example.country_projectexample.datamodel.Country_Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {
    @GET("v3.1/all?fields=name,capital,translations,flags")
    fun getCountries(): Call<Country_Response>

//    @GET("v3.1/name/??")
//    fun getDetailCountries(enName_Common:String) : Call<Country_Response>

    @GET("v3.1/name/{countries-name}")
    fun getDetailCountries(
        @Path("countries-name") name: String
    ) : Call<Country_Response_Detail>
}
