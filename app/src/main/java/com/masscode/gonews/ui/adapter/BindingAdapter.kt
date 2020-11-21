package com.masscode.gonews.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("app:loadImage")
fun loadImage(imageView: ImageView, url: String) {
    imageView.load(url)
}