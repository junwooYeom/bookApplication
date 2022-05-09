package com.junwooyeom.bookapplication.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.junwooyeom.bookapplication.R

object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun load(imageView: ImageView, url: String?) {
        if (url.isNullOrEmpty().not()) {
            GlideApp.with(imageView.context)
                .load(url)
                .into(imageView)
        } else {
            imageView.setBackgroundResource(R.drawable.ic_image_not_supported)
        }
    }

    @BindingAdapter("authorList")
    @JvmStatic
    fun getAuthorList(textView: TextView, list: List<String>?) {
        if (list.isNullOrEmpty()) {
            textView.text = ""
        } else {
            textView.text = list.joinToString(", ")
        }
    }
}