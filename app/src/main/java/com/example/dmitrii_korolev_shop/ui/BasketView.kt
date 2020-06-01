package com.example.dmitrii_korolev_shop.ui

import com.example.dmitrii_korolev_shop.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProducts(products: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)
}