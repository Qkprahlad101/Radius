package com.example.radius.presenter

import android.util.Log
import com.example.radius.contract.MainContract
import com.example.radius.model.Item
import com.example.radius.model.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    override fun getItems() {
        view.showLoading()
        val retrofitClient = RetrofitClient()
        retrofitClient.apiService.getRadiusResponse().enqueue(object : Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body() ?: Item(emptyList(), emptyList())
                    val items = apiResponse.facilities
                    Log.d("MainPresenter", "onResponse: $items")
//                    view.showItems(items)
                } else {
                    val error = "Error: ${response.code()}"
                    Log.e("MainPresenter", error)
                    view.showError(error)
                }

                view.hideLoading()
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                val error = "Error: ${t.message}"
                Log.e("MainPresenter", error, t)
                view.showError(error)
                view.hideLoading()
            }
        })
    }
}


//class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
//
//    override fun getItems() {
//        view.showLoading()
//        // Get items from the repository
////        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10")
//        val retrofitClient = RetrofitClient()
//        retrofitClient.apiService.getRadiusResponse().enqueue(object : Callback<List<Item>> {
//            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
//                if (response.isSuccessful) {
//                    val items = response.body() ?: emptyList()
//                    Log.d("ApiResponse", "onResponse: $items")
////                    view.showItems(items)
//                } else {
//                    view.showError("Error: ${response.code()}")
//                }
//
//                view.hideLoading()
//            }
//
//            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
//                view.showError("Error: ${t.message}")
//                view.hideLoading()
//            }
//        })
////
////
////        view.showItems(items)
////        view.hideLoading()
//    }
//}
//
//private fun <T> Call<T>.enqueue(callback: Callback<List<T>>) {
//
//}
