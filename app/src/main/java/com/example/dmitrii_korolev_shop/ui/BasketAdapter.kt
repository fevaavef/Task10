package com.example.dmitrii_korolev_shop.ui

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dmitrii_korolev_shop.Product
import com.example.dmitrii_korolev_shop.R
import kotlinx.android.synthetic.main.item_basket.view.*

class BasketAdapter(
    private val products: List<Product>,
    private val onDeleteClick: (product: Product) -> Unit
): RecyclerView.Adapter<BasketAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_basket, parent, false))
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(products[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(product: Product){
            itemView.categoryTv.text = product.getName()
            itemView.itemStartPrice.text = product.getPrice().toString()
            itemView.itemStartPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            itemView.itemDiscountedPrice.text = product.getDiscountPriceString()

            itemView.deleteIv.setOnClickListener{
                onDeleteClick(product)
            }
        }
    }
}