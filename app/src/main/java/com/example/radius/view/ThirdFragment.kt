package com.example.radius.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.radius.contract.MainContract
import com.example.radius.presenter.MainPresenter
import com.example.radius.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(), MainContract.View {

    private lateinit var binding: FragmentThirdBinding
    private lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        presenter = MainPresenter(this)
        presenter.getItems()
        binding.recyclerView3.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun showItems(items: List<String>) {
        // Show items in the list
        binding.recyclerView3.adapter = ItemAdapter(items.take(5))
    }

    override fun showError(message: String) {
        // Show error message
    }

    override fun showLoading() {
        // Show loading indicator
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        // Hide loading indicator
        binding.progressBar.visibility = View.GONE
    }
}