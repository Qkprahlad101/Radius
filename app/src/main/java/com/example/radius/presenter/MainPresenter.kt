package com.example.radius.presenter

import com.example.radius.contract.MainContract

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    override fun getItems() {
        view.showLoading()
        // Get items from the repository
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10")
        view.showItems(items)
        view.hideLoading()
    }
}