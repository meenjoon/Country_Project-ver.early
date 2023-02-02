package com.example.country_projectexample.datamodel_detail


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country_ResponseItem_Detail(
    @SerializedName("capital")
    val capital: List<String>?,
    @SerializedName("cioc")
    val cioc: String?,
    @SerializedName("currencies")
    val currencies: Currencies?,
    @SerializedName("languages")
    @Expose
    val languages: Languages?,
    @SerializedName("name")
    val name: Name?,
    @SerializedName("population")
    val population: Int?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("maps")
    val maps: Maps?
)
