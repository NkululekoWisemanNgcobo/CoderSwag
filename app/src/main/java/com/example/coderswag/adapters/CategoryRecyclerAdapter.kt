package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Category
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryRecyclerAdapter.holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_list_item , parent , false)
        return holder(view , itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.bindCategory(categories[position] , context)
    }

    inner class holder(itemView: View? ,  val itemClick: (Category) -> Unit): RecyclerView.ViewHolder(itemView!!){
        var categoryImage: ImageView? = itemView?.findViewById<ImageView>(R.id.categoryImage)
        var categoryName: TextView? = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category ,context: Context){
            val resourceId = context.resources.getIdentifier(category.image , "drawable" , context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }
    }
}