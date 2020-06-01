package com.example.dmitrii_korolev_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmitrii_korolev_shop.Product
import com.example.dmitrii_korolev_shop.R
import com.example.dmitrii_korolev_shop.presenter.BasketPresenter
import kotlinx.android.synthetic.main.basket_layout.*
import kotlinx.android.synthetic.main.catalog_layout.*

class BasketActivity : BaseActivity(), BasketView {

    private val presenter = BasketPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_layout)

        addListeners()
        categoryRv.layoutManager = LinearLayoutManager(this)
        presenter.attachView(this)
        presenter.setData()
    }

    private fun addListeners()
    {
        basketToCatalogBtn.setOnClickListener{
            startActivity(Intent(this, CatalogActivity::class.java))
        }
        basketToCheckoutBtn.setOnClickListener{
            startActivity(Intent(this, CheckoutActivity::class.java))
        }
        basketBackArrow.setOnClickListener{
            finish()
        }
    }

    override fun setProducts(products: List<Product>) {
        categoryRv.adapter = BasketAdapter(products){
            product -> presenter.removeItem(product)
        }
    }

    override fun removeItem(position: Int) {
        categoryRv.adapter?.notifyItemRemoved(position)
    }
}