package com.example.country_projectexample.datamodel


import com.google.gson.annotations.SerializedName

data class Translations(
    @SerializedName("kor")
    val kor: Kor?
)
