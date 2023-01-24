package com.example.country_projectexample.datamodel


import com.google.gson.annotations.SerializedName

data class Kor(
    @SerializedName("official")
    val korName_Official: String?,

    @SerializedName("common")
    val korName_Common: String?

)
