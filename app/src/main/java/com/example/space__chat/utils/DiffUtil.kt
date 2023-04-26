package com.example.space__chat.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.space__chat.data.Entity

class ChatCallBack : DiffUtil.ItemCallback<Entity>() {
    override fun areItemsTheSame(oldItem: Entity, newItem: Entity) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Entity, newItem: Entity) =
        oldItem == newItem
}