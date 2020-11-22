package com.masscode.gonews.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masscode.gonews.R
import com.masscode.gonews.databinding.ActivityDetailBinding
import com.masscode.gonews.domain.model.Article

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Article>(EXTRA_DATA)
        binding.textView.text = data?.username
    }
}