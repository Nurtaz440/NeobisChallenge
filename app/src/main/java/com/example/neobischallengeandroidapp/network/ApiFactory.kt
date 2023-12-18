package com.example.neobischallengeandroidapp.network

import retrofit2.http.GET

interface ApiFactory {
    @GET("product-category-list/")
    suspend fun getAllCategories(): List<String>
}