package com.example.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import com.example.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_show_product.*

class ShowProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_product)
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        showProductName.text = product.title
        showPrice.text = product.price
        val resourceId = this.resources.getIdentifier(product.image,"drawable",this.packageName)
        showProductImage?.setImageResource(resourceId)

    }
}
