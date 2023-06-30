package com.example.radius.view
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.radius.contract.MainContract
import com.example.radius.presenter.MainPresenter
import com.example.radius.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        setupTabs()
    }

    private fun setupTabs() {
        binding.viewPager.adapter = MainPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    override fun showItems(items: List<String>) {
        // Show items in the corresponding fragment
    }

    override fun showError(message: String) {
        // Show error message
    }

    override fun showLoading() {
        // Show loading indicator
    }

    override fun hideLoading() {
        // Hide loading indicator
    }
}
