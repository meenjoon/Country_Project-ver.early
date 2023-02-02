package com.example.country_projectexample.datamodel_detail


import com.google.gson.annotations.SerializedName

data class NIO(
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)
