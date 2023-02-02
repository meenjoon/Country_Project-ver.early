package com.example.country_projectexample.datamodel_detail


import com.google.gson.annotations.SerializedName

data class Afr(
    @SerializedName("common")
    val common: String?,
    @SerializedName("official")
    val official: String?
)
