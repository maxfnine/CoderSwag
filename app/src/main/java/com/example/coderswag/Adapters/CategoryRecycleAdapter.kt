package com.example.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Adapters.CategoryRecycleAdapter.Holder
import com.example.coderswag.Model.Category
import com.example.coderswag.R

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>,val itemClick:(Category)->Unit):RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item,parent,false)
        return Holder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val category = categories[position]
        holder.bindCategory(category, context)
    }

    inner class Holder(itemView: View?,val itemClick:(Category)->Unit) : RecyclerView.ViewHolder(itemView!!){
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryNameText)

        fun bindCategory(category:Category,context: Context){

            categoryName?.text = category.title
            val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
            categoryImage?.setImageResource(resourceId)
            itemView?.setOnClickListener{itemClick(category)}
        }

    }
}