package com.example.radius.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.radius.contract.MainContract
import com.example.radius.presenter.MainPresenter
import com.example.radius.databinding.FragmentFourthBinding

class FourthFragment : Fragment(), MainContract.View {

    private lateinit var binding: FragmentFourthBinding
    private lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFourthBinding.inflate(inflater, container, false)
        presenter = MainPresenter(this)
        presenter.getItems()
        binding.recyclerView4.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun showItems(items: List<String>) {
        // Show items in the list
        binding.recyclerView4.adapter = ItemAdapter(items.take(5))
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