package com.example.neobischallengeandroidapp.ui.bottomDialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.neobischallengeandroidapp.R
import com.example.neobischallengeandroidapp.databinding.FragmentBottomDialogBinding
import com.example.neobischallengeandroidapp.databinding.FragmentDetailBinding
import com.example.neobischallengeandroidapp.ui.detail.DetailVIewModel
import com.example.neobischallengeandroidapp.ui.home.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.NumberFormat

class BottomDialogFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomDialogBinding? = null
    val binding get() = _binding!!
    lateinit var viewModel: DetailVIewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomDialogBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailVIewModel::class.java)
        // Set up behavior
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        val behavior = BottomSheetBehavior.from(bottomSheet!!)
        behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        val layoutParams = bottomSheet?.layoutParams
        val windowHeight = resources.displayMetrics.heightPixels
        layoutParams?.height = windowHeight
        bottomSheet?.layoutParams = layoutParams
        behavior.peekHeight = windowHeight /2

        with(binding) {
            btnAdd.setOnClickListener {
                viewModel.incrementCount()

            }
            btnMinus.setOnClickListener {
                viewModel.decrementCount()
            }
        }


        viewModel.count.observe(viewLifecycleOwner) { count ->
            binding.tvCount.text = count.toString()
            var totalPrice = args.product!!.price!! * count
            binding.tvPrice.text = NumberFormat.getCurrencyInstance().format(totalPrice)
        }
    }
    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}