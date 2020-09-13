package com.marand.databinding.databinding

import android.widget.ImageView
import com.squareup.picasso.Picasso
import androidx.databinding.BindingAdapter
import com.marand.databinding.R

@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, imageUrl: String?) {

    if (!imageUrl.isNullOrBlank()) {
        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(view)
    }
}