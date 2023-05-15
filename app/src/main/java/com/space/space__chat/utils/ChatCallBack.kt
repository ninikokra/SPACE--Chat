package com.space.space__chat.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * [ChatCallBack] is used by the ListAdapter to calculate the difference between two lists of items
 * and update the RecyclerView accordingly,
 * by calling the appropriate notifyItem*() methods.
 */

class ChatCallBack<T : Any> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem === newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}