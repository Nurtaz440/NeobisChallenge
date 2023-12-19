package com.example.neobischallengeandroidapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.neobischallengeandroidapp.databinding.ItemProductBinding
import com.example.neobischallengeandroidapp.module.CategoryModel

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.CategoryViewHolder>() {

    private val categoryList = arrayListOf<CategoryModel>()
    var onClick: (String) -> Unit = {}
    fun setData(itemList: List<CategoryModel>) {
        categoryList.clear()
        categoryList.addAll(itemList)
        notifyItemChanged(itemList.size)
    }

    class CategoryViewHolder(private val cardCategoryBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(cardCategoryBinding.root) {
        fun bind(category: CategoryModel, onClick: (String) -> Unit = {}) {
            cardCategoryBinding.ivProduct.load(category.image)
            cardCategoryBinding.tvName.text = category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryLayout =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(categoryLayout)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position], onClick)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}