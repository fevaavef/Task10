package com.example.dmitrii_korolev_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.dmitrii_korolev_shop.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)
        addListeners()
    }

    private fun addListeners()
    {
        catalogToProductBtn.setOnClickListener{
            startActivity(Intent(this, ProductActivity::class.java))
        }
        catalogToBasketBtn.setOnClickListener{
            startActivity(Intent(this, BasketActivity::class.java))
        }
    }
}