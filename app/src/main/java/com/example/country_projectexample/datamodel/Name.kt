package com.example.country_projectexample.datamodel


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("official")
    val enName_Official: String?
)
