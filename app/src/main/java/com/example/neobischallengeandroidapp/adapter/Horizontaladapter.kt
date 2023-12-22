package com.example.neobischallengeandroidapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.neobischallengeandroidapp.R
import com.example.neobischallengeandroidapp.databinding.ItemCategoriesBinding
import com.example.neobischallengeandroidapp.module.CategoryModel

class Horizontaladapter(private val onClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<Horizontaladapter.CategoryViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION


    private val categoryList = arrayListOf<CategoryModel>()

    fun setData(itemList: List<CategoryModel>) {
        categoryList.clear()
        categoryList.addAll(itemList)
        notifyItemChanged(itemList.size)
    }

    class CategoryViewHolder(private val cardCategoryBinding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(cardCategoryBinding.root) {
        val cardView = cardCategoryBinding.cvCategory
        val tv_name = cardCategoryBinding.tvName
        fun bind(category: CategoryModel) {
            cardCategoryBinding.tvName.text = category.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryLayout =
            ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(categoryLayout)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        holder.bind(categoryList[position])
        holder.itemView.setOnClickListener {
            onClickListener.invoke(position)
            notifyItemChanged(selectedPosition)
            selectedPosition = holder.adapterPosition
            notifyItemChanged(selectedPosition)

            if (position == selectedPosition) {
                holder.cardView.setCardBackgroundColor(holder.itemView.context.getColor(R.color.green_selected_color))
                holder.cardView.strokeWidth = 0
                holder.tv_name.setTextColor(holder.itemView.context.getColor(R.color.white))
            } else {
                holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.white))
                holder.cardView.strokeWidth = 1
                holder.tv_name.setTextColor(holder.itemView.context.getColor(R.color.grey))
            }

        }

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}