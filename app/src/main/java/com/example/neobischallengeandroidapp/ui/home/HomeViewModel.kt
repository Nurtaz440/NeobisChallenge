package com.example.neobischallengeandroidapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    private val _categoryData = MutableLiveData<List<String>?>()
    val categoryData: LiveData<List<String>?>
        get() = _categoryData

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            val request = repository.getCategories()

            _categoryData.value = request.data

        }
    }
}