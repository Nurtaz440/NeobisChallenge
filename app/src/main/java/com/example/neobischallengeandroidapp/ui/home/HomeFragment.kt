package com.example.neobischallengeandroidapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neobischallengeandroidapp.R
import com.example.neobischallengeandroidapp.adapter.HomeAdapter
import com.example.neobischallengeandroidapp.databinding.ActivityMainBinding
import com.example.neobischallengeandroidapp.databinding.FragmentHomeBinding
import com.example.neobischallengeandroidapp.module.CategoryModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!

    lateinit var homeAdapter: HomeAdapter

    lateinit var viewModel: HomeViewModel
    lateinit var arrayList: ArrayList<CategoryModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
         return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arrayList = ArrayList()
        homeAdapter = HomeAdapter()
        setRecyclerView()
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Observe the LiveData and update UI accordingly
        viewModel.categories.observe(viewLifecycleOwner, Observer { categories ->
            // Update your UI with the categories data
            // For example, you can use an adapter for RecyclerView
            arrayList.add(categories)
            homeAdapter.setData(arrayList)

        })

        // Make the API call when the activity is created or whenever needed
        viewModel.getAllCategories()

    }
    private fun setRecyclerView(){
        with(binding.rvPopular){
            layoutManager= GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            adapter=homeAdapter
        }
    }
}