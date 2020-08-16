package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Product
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductAdapter(val context: Context ,val products: List<Product>): RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item , parent , false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProduct(products[position] , context)
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName  = itemView?.findViewById<TextView>(R.id.productTitleText)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPriceText)

        fun bindProduct(product: Product , context: Context){
            val resourceId = context.resources.getIdentifier(product.image , "drawable", context.packageName)
            productImage?.setImageResource(resourceId)
            productName.text = product.title
            productPrice.text = product.price
        }
    }

}