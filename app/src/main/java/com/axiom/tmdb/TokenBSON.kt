package com.axiom.tmdb


import com.google.gson.annotations.SerializedName

data class TokenBSON(
    @SerializedName("expires_at")
    val expiresAt: String = "",
    @SerializedName("request_token")
    val requestToken: String = "",
    @SerializedName("success")
    val success: Boolean = false
)