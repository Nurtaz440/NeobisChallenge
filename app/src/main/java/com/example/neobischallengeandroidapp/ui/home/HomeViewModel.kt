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

    fun searchByCategory(categoryName: String, id: Int) {
     //   viewModelScope.launch {
//            val response =
//                Constants.apiService.getDetailCategories().plus("?category_name=" + categoryName)
//            _detailCategory.value = response
//
//            val queue = (getApplication() as ShoppingApp).requestQueue
//
//            val url = Constants.PRODUCT_URL + "?category_name=" + categoryName
//            val request = StringRequest(Request.Method.GET, url, { response ->
               // try {
               //     val objProducts = JSONObject(response)
//                    if (objProducts.getString("status") == "success") {
//                        val productArray = objProducts.getJSONArray("products")
//                        for (i in 0 until productArray.length() step 1) {
//                            val childObj = productArray.getJSONObject(i)
//                            val product = Product(
//                                childObj.getString("name"),
//                                Constants.PRODUCTS_IMAGE_URL + childObj.getString("image"),
//                                childObj.getString("status"),
//                                childObj.getDouble("price"),
//                                childObj.getDouble("price_discount"),
//                                childObj.getInt("stock"),
//                                childObj.getInt("id"),
//                            )
//                            productList.add(product)
//                        }
//                        productAdapter.notifyDataSetChanged()
//                    } else {
//                        // do nothing
//                    }
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//
//            }, {
//                // textView.text = "That didn't work!"
//            })
//            queue.add(request)

    }


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