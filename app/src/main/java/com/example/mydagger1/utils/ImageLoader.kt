package com.example.mydagger1.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoader {
    fun loadImage(url: String, imageView: ImageView) = Picasso.get().load(url).into(imageView)
}