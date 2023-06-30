package com.example.radius.contract

interface MainContract {
    interface View {
        fun showItems(items: List<String>)
        fun showError(message: String)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun getItems()
    }
}