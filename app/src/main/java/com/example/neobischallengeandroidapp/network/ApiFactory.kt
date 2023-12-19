package com.example.neobischallengeandroidapp.network

import com.example.neobischallengeandroidapp.module.CategoryModel
import retrofit2.http.GET

interface ApiFactory {
    @GET("product-category-list/")
    suspend fun getAllCategories(): CategoryModel
}