package com.example.country_projectexample.datamodel


import com.google.gson.annotations.SerializedName

data class Country_ResponseItem(
    @SerializedName("capital")
    val capital: List<String?>?,
    @SerializedName("name")
    val name: Name?,
    @SerializedName("translations")
    val translations: Translations?,
    @SerializedName("flags")
    val flags: Flags?
)
