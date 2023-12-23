package com.example.neobischallengeandroidapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.neobischallengeandroidapp.R
import com.example.neobischallengeandroidapp.databinding.ItemCategoriesBinding
import com.example.neobischallengeandroidapp.databinding.ItemDetailVerticalBinding
import com.example.neobischallengeandroidapp.module.CategoryModel
import com.example.neobischallengeandroidapp.module.DetailModel
import java.text.NumberFormat

class VerticalAdapter: RecyclerView.Adapter<VerticalAdapter.CategoryViewHolder>() {


    private val categoryList = arrayListOf<DetailModel>()

    fun setData(itemList: List<DetailModel>) {
        categoryList.clear()
        categoryList.addAll(itemList)
        notifyItemChanged(itemList.size)
    }

    class CategoryViewHolder(private val cardCategoryBinding: ItemDetailVerticalBinding) :
        RecyclerView.ViewHolder(cardCategoryBinding.root) {
        val image = cardCategoryBinding.ivProduct
        val tv_name = cardCategoryBinding.tvName
        fun bind(category: DetailModel) {
            cardCategoryBinding.tvName.text = category.title
            cardCategoryBinding.tvPrice.text = NumberFormat.getCurrencyInstance().format(category.price)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryLayout =
            ItemDetailVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(categoryLayout)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        holder.bind(categoryList[position])
        holder.image.load(categoryList[position].image)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}