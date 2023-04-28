package com.example.click_me.domain

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("category") val category: String,
    @SerializedName("delivery") val delivery: String,
    @SerializedName("lang") val lang: String
)
