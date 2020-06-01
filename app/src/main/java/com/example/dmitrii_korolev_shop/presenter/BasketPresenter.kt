package com.example.dmitrii_korolev_shop.presenter

import com.example.dmitrii_korolev_shop.Product
import com.example.dmitrii_korolev_shop.ui.BasketView
import moxy.MvpPresenter

class BasketPresenter : MvpPresenter<BasketView>()
{
    private val assaultRifle = Product(4672.0, "Assault rifle", 27)
    private val pumpShotgun = Product(1339.0, "Pump-action shotgun", 18)
    private val SMG = Product(4179.0, "Submachine gun", 16)
    private val sawedOff = Product(1991.0, "Sawed-off shotgun", 15)
    private val M134 = Product(1089.0, "Minigun", 25)
    private val MG = Product(2286.0, "Machine gun", 23)
    private val rifle = Product(1519.0, "Rifle", 26)
    private val carbine = Product(3875.0, "Carbine", 25)
    private val revolver = Product(3886.0, "Revolver", 23)
    private val rocketLauncher = Product(1356.0, "Rocket launcher", 29)
    private val pistol = Product(2834.0, "Pistol", 12)

    private val allProducts = mutableListOf(assaultRifle, sawedOff, M134,
        pumpShotgun, MG, rifle, SMG, carbine, revolver, rocketLauncher, pistol)

    fun setData(){
        viewState.setProducts(allProducts)
    }

    fun removeItem(product: Product){
        val position = allProducts.indexOf(product)
        allProducts.remove(product)
        viewState.removeItem(position)
    }

    fun totalPrice() : Double{
        var result = 0.0
        allProducts.forEach{product -> result+=product.getPrice()}
        return result
    }

    fun totalPriceWithDiscount() : Double
    {
        var total = 0.0
        allProducts.forEach{product -> total+=product.getDiscountPrice()}
        return total
    }

    fun totalDiscount() : Double = "%.2f".format((1.0-totalPriceWithDiscount()/totalPrice()) * 100.0).toDouble()
}
