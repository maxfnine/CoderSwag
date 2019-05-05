package com.example.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductsAdapter(val context: Context,val products:List<Product> ): RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item,parent,false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(productHolder: ProductHolder, position: Int) {
        productHolder?.bindProduct(products[position],context)
    }

    inner class ProductHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val productImage:ImageView = itemView?.findViewById(R.id.productImage)
        val productName:TextView = itemView?.findViewById(R.id.productName)
        val productPrice:TextView = itemView?.findViewById(R.id.productPrice)

        fun bindProduct(product:Product,context: Context){
            val resourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price


        }
    }
}