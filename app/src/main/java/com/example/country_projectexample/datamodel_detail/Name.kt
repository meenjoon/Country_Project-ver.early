package com.example.country_projectexample.datamodel_detail


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("nativeName")
    val nativeName: NativeName?
)
