package com.example.neobischallengeandroidapp.ui.home

import com.example.neobischallengeandroidapp.network.ApiFactory
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiFactory: ApiFactory) {

    suspend fun getCategories() = apiFactory.getAllCategories()
}