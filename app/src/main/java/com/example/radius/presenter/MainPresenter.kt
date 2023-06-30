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
