package com.space.space__chat.utils.extensions

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes


fun View.setTint(colorRes: Int) {
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(colorRes))
}

fun ImageView.setImgTint(colorRes: Int) {
    this.imageTintList = ColorStateList.valueOf(this.context.getColor(colorRes))
}
fun TextView.setTextViewColor(@ColorRes colorRes: Int) {
    this.setTextColor(context.getColor(colorRes))
}