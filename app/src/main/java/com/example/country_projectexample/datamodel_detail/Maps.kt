package com.example.country_projectexample.datamodel_detail

import com.google.gson.annotations.SerializedName

data class Maps(
    @SerializedName("googleMaps")
    val googleMaps: String?,
    @SerializedName("openStreetMaps")
    val openStreetMaps: String?
)
