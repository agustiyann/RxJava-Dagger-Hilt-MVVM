package com.masscode.gonews.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masscode.gonews.data.Resource
import com.masscode.gonews.databinding.ActivityHomeBinding
import com.masscode.gonews.ui.adapter.ListAdapter
import com.masscode.gonews.ui.detail.DetailActivity
import com.masscode.gonews.ui.detail.DetailActivity.Companion.EXTRA_DATA
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val articleAdapter = ListAdapter()
        articleAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(EXTRA_DATA, selectedData)
            }
            startActivity(intent)
        }

        homeViewModel.articles.observe(this@HomeActivity, { articles ->
            Timber.d(articles.data?.size.toString())
            if (articles != null) {
                when (articles) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        articleAdapter.setData(articles.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.visibility = View.VISIBLE
                    }
                }
            }
        })

        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            setHasFixedSize(true)
            adapter = articleAdapter
        }
    }
}