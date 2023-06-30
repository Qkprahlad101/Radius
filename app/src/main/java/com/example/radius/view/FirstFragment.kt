package com.example.radius.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.radius.contract.MainContract
import com.example.radius.presenter.MainPresenter
import com.example.radius.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), MainContract.View {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        presenter = MainPresenter(this)
        presenter.getItems()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun showItems(items: List<String>) {
        val adapter = ItemAdapter(items.take(5))
        binding.recyclerView.adapter = adapter
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