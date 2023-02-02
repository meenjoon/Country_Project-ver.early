package com.example.country_projectexample.datamodel_detail


import com.google.gson.annotations.SerializedName

data class PYG(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)
