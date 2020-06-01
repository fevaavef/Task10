package com.example.dmitrii_korolev_shop

class Product(
    private val price: Double,
    private val name: String,
    private val salePercent: Int = 0
) {
    fun getDiscountPrice(): Double = price * (1 - salePercent / 100.0)
    fun getName() = name
    fun getPrice() = price
    fun getDiscountPriceString(): String = "%.2f".format(getDiscountPrice())
}