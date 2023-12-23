package com.example.neobischallengeandroidapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neobischallengeandroidapp.adapter.Horizontaladapter
import com.example.neobischallengeandroidapp.adapter.VerticalAdapter
import com.example.neobischallengeandroidapp.databinding.FragmentDetailBinding
import com.example.neobischallengeandroidapp.ui.home.HomeViewModel


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    val binding get() = _binding!!
    lateinit var horizonlatAdpater: Horizontaladapter
    lateinit var verticalAdapter: VerticalAdapter

    lateinit var viewModel: HomeViewModel

    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        horizonlatAdpater = Horizontaladapter { }
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Observe the LiveData and update UI accordingly
        viewModel.categories.observe(viewLifecycleOwner, Observer { categories ->
            // Update your UI with the categories data
            // For example, you can use an adapter for RecyclerView
            horizonlatAdpater.setData(categories)
            with(binding.rvCategory) {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = horizonlatAdpater
            }
        })
// Observe the products LiveData
        viewModel.detailCategory.observe(viewLifecycleOwner, { products ->
            // Update UI with the list of products
            // e.g., update RecyclerView adapter
            verticalAdapter.setData(products)
            with(binding.rvVerticalCategory) {
                layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = verticalAdapter
            }
        })

        // Trigger the network request

        // Make the API call when the activity is created or whenever needed
        viewModel.getAllCategories()
        val name = args.categoryName
        val id = args.postionSelected
        viewModel.fetchProducts(name!!)
       // viewModel.searchByCategory(name!!, id)
    }

}