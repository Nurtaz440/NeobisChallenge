package com.example.neobischallengeandroidapp.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.neobischallengeandroidapp.module.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BasketViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    val allProducts: LiveData<List<Product>>

    init {
        val dao = ProductDatabase.getDatabase(application).productDao()
        repository = ProductRepository(dao)
        allProducts = repository.getAllProducts().asLiveData()
    }

    // Function to insert a product into the database
    fun insertProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertProduct(product)
        }
    }
}