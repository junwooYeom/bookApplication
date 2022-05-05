package com.junwooyeom.bookapplication.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun load(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context)
            .load(url)
            .into(imageView)
    }

    @BindingAdapter("authorList")
    @JvmStatic
    fun getAuthorList(textView: TextView, list: List<String>) {
        textView.text = list.joinToString(", ")
    }
}