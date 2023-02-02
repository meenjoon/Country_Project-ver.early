package com.example.country_projectexample.datamodel_detail


import com.google.gson.annotations.SerializedName

data class HKD(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)
