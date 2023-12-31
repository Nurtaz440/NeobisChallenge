package com.example.neobischallengeandroidapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.neobischallengeandroidapp.app.ShoppingApp
import com.example.neobischallengeandroidapp.module.CategoryModel
import com.example.neobischallengeandroidapp.module.DetailModel
import com.example.neobischallengeandroidapp.utils.Constants
import dagger.hilt.android.internal.Contexts.getApplication
import kotlinx.coroutines.launch
import org.json.JSONObject


class HomeViewModel : ViewModel() {
    private val _categories = MutableLiveData<List<CategoryModel>>()
    val categories: LiveData<List<CategoryModel>> get() = _categories

    private val _detailCategory = MutableLiveData<List<DetailModel>>()
    val detailCategory: LiveData<List<DetailModel>> get() = _detailCategory



    // Function to make the API call and update the LiveData
    fun getAllCategories() {
        viewModelScope.launch {
            try {
                val response = Constants.apiService.getAllCategories()
                _categories.value = response
            } catch (e: Exception) {
                // Handle error (e.g., show an error message)
                Log.e("YourViewModel", "Error: ${e.message}", e)
            }
        }
    }
    fun fetchProducts(categoryName: String) {
        viewModelScope.launch {
            try {
                // val response = productService.getProducts(categoryName)
                val response = Constants.apiService.getProducts(categoryName)
                _detailCategory.value = response
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}