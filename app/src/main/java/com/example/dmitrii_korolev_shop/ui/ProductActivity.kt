package com.example.dmitrii_korolev_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.dmitrii_korolev_shop.R
import kotlinx.android.synthetic.main.product_layout.*

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)
        addListeners()
    }

    private fun addListeners()
    {
        productToCatalogBtn.setOnClickListener{
            startActivity(Intent(this, CatalogActivity::class.java))
        }
        productBackArrow.setOnClickListener{
            finish()
        }
    }
}