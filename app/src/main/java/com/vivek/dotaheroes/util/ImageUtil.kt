package com.vivek.dotaheroes.util

import android.widget.ImageView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.vivek.dotaheroes.R

fun ImageView.loadImage(imgUrl: String) {
    load(data = imgUrl) {
        scale(Scale.FILL)
        placeholder(R.drawable.hero_iv_placeholder)
        error(R.drawable.hero_iv_error)
        transformations(
            RoundedCornersTransformation(16f)
        )
    }
}

fun ImageView.loadImageFromDrawables(id: Int) {
    load(id) {
        scale(Scale.FILL)
    }
}