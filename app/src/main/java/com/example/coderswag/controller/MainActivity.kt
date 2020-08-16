package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.adapters.CategoryAdapter
import com.example.coderswag.adapters.CategoryRecyclerAdapter
import com.example.coderswag.model.Category
import com.example.coderswag.service.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter :  CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this , DataService.categories)
        CategoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        CategoryListView?.layoutManager = layoutManager
        CategoryListView.setHasFixedSize(true)
    }
}