package com.example.neobischallengeandroidapp.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.neobischallengeandroidapp.module.DetailModel
import com.example.neobischallengeandroidapp.utils.Constants
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _categories = MutableLiveData<List<DetailModel>>()
    val categories: LiveData<List<DetailModel>> get() = _categories


//    fun searchByCategory(categoryName: String, id: Int) {
//        viewModelScope.launch {
//            val queue = (getApplication() as ShoppingApp).requestQueue
//
//
//            val url = Constants.PRODUCT_URL + "?category_name=" + categoryName
//            val request = StringRequest(Request.Method.GET, url, { response ->
//                // try {
//                val objProducts = JSONObject(response)
//            }, {
//                // textView.text = "That didn't work!"
//            })
//            queue.add(request)
//
//        }
//    }

    fun fetchProducts(categoryName: String) {
        viewModelScope.launch {
            try {
                // val response = productService.getProducts(categoryName)
                val response = Constants.apiService.getProducts(categoryName)
                _categories.value = response
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}
