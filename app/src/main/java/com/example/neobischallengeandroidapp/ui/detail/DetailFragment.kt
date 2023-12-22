package com.example.neobischallengeandroidapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neobischallengeandroidapp.R
import com.example.neobischallengeandroidapp.adapter.HomeAdapter
import com.example.neobischallengeandroidapp.adapter.Horizontaladapter
import com.example.neobischallengeandroidapp.databinding.FragmentDetailBinding
import com.example.neobischallengeandroidapp.databinding.FragmentHomeBinding
import com.example.neobischallengeandroidapp.ui.home.HomeViewModel


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    val binding get() = _binding!!
    lateinit var horizonlatAdpater: Horizontaladapter

    lateinit var viewModel: HomeViewModel
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
            with(binding.rvCategory){
                layoutManager= LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
                setHasFixedSize(true)
                adapter=horizonlatAdpater
            }

        })

        // Make the API call when the activity is created or whenever needed
        viewModel.getAllCategories()
    }

}