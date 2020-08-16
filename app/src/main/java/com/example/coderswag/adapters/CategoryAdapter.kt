package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holderView : ViewHolder
        val categoryView: View

        if ( convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item , null)
            holderView = ViewHolder()
            holderView.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holderView.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holderView
        } else {
            holderView = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]
        holderView.categoryName?.text = category.title

        val resourceId = context.resources.getIdentifier(category.image , "drawable" ,context.packageName)
        holderView.categoryImage?.setImageResource(resourceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return  categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder{
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}