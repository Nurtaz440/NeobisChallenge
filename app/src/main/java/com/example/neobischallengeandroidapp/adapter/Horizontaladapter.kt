package com.example.neobischallengeandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.neobischallengeandroidapp.R
import com.example.neobischallengeandroidapp.databinding.ItemCategoriesBinding
import com.example.neobischallengeandroidapp.module.CategoryModel

class Horizontaladapter(val context: Context,private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<Horizontaladapter.CategoryViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION


    private val categoryList = arrayListOf<CategoryModel>()
    private val selectedItems = mutableSetOf<Int>()
    fun setData(itemList: List<CategoryModel>,id : Int) {
        categoryList.clear()
        categoryList.addAll(itemList)
        notifyItemChanged(itemList.size)
        this.selectedPosition = id
    }

    class CategoryViewHolder(private val cardCategoryBinding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(cardCategoryBinding.root) {
        val cardView = cardCategoryBinding.cvCategory
        val tv_name = cardCategoryBinding.tvName
        fun bind(category: CategoryModel) {
            cardCategoryBinding.tvName.text = category.name
            // Change background color based on the selected state
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
            onItemSelected.invoke(position)
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                updateSelectedItem(position)
                //onItemClick(position)

            }


        }

        if (position == selectedPosition) {
            holder.cardView.setCardBackgroundColor(holder.itemView.context.getColor(R.color.green_selected_color))
            holder.cardView.strokeWidth = 1
            holder.cardView.strokeColor = holder.itemView.context.getColor(R.color.green_selected_color)
            holder.tv_name.setTextColor(holder.itemView.context.getColor(R.color.white))
        } else {
            holder.cardView.setBackgroundColor(holder.itemView.context.getColor(R.color.white))
            holder.cardView.strokeWidth = 1
            holder.tv_name.setTextColor(holder.itemView.context.getColor(R.color.grey))
            holder.cardView.strokeColor = holder.itemView.context.getColor(R.color.grey)
        }


//        if (selectedItems.contains(holder.adapterPosition)) {
//            holder.cardView.setCardBackgroundColor(holder.itemView.context.getColor(R.color.green_selected_color))
//            holder.cardView.strokeWidth = 0
//            holder.tv_name.setTextColor(holder.itemView.context.getColor(R.color.white))
//        } else {
//            holder.cardView.setBackgroundColor(holder.itemView.context.getColor(R.color.white))
//            holder.cardView.strokeWidth = 1
//            holder.tv_name.setTextColor(holder.itemView.context.getColor(R.color.grey))
//        }

//        holder.itemView.setOnClickListener {
//                val position = holder.adapterPosition
//                if (position != RecyclerView.NO_POSITION) {
//                    updateSelectedItem(position)
//                }
//            }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
     fun updateSelectedItem(newPosition: Int) {
        val previousSelectedItem = selectedPosition
        selectedPosition = newPosition
        notifyItemChanged(previousSelectedItem)
        notifyItemChanged(newPosition)
//        if (selectedItems.contains(newPosition)) {
//            selectedItems.remove(newPosition)
//        } else {
//            selectedItems.add(newPosition)
//        }
        notifyDataSetChanged()
       // onItemSelected(selectedItems)
    }

}