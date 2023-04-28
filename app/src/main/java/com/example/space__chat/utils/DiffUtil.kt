package com.example.space__chat.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.space__chat.data.Entity

class ChatCallBack<T : Any> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem === newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}