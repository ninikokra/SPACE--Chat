package com.example.space__chat.Presentation.utils

import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView

fun TextView.setTint(color:Int){
    this.backgroundTintList = ColorStateList.valueOf(this.context.getColor(color))
}
fun ImageView.setTint(color:Int){
    this.imageTintList = ColorStateList.valueOf(this.context.getColor(color))
}