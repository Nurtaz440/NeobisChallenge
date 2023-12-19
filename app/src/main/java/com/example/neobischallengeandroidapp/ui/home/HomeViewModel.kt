package com.example.neobischallengeandroidapp.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neobischallengeandroidapp.module.CategoryModel
import com.example.neobischallengeandroidapp.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel  : ViewModel() {
    private val _categories = MutableLiveData<CategoryModel>()
    val categories: LiveData<CategoryModel> get() = _categories
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
}