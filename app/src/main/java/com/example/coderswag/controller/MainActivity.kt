package com.example.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.R
import com.example.coderswag.adapters.CategoryRecyclerAdapter
import com.example.coderswag.service.DataService
import com.example.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter :  CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this , DataService.categories){ category ->
            val productIntent = Intent(this , ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY , category.title)
            startActivity(productIntent)
        }
        productsListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        productsListView?.layoutManager = layoutManager
        productsListView.setHasFixedSize(true)
    }
}