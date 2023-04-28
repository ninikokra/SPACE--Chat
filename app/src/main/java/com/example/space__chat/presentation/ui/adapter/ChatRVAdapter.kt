package com.example.space__chat.Presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.space__chat.Presentation.model.UserType
import com.example.space__chat.utils.setTint
import com.example.space__chat.R
import com.example.space__chat.data.Entity
import com.example.space__chat.databinding.RvUserItemBinding
import com.example.space__chat.utils.ChatCallBack
import com.example.space__chat.utils.convertTimeToString
import com.example.space__chat.utils.setImgTint

class ChatRVAdapter(private val user: UserType) :
    ListAdapter<Entity, ChatRVAdapter.ChatRvViewHolder>(ChatCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRvViewHolder {
        return ChatRvViewHolder(
            RvUserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatRvViewHolder, position: Int) {
        holder.bind(user, getItem(position))
    }

    class ChatRvViewHolder(private val binding: RvUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserType, item: Entity) = with(binding) {
            messageInputTV.text = item.message
            timeStampTV.text = item.timeStamp?.convertTimeToString()
            val color =
                if (user.name == item.sender) R.color.purple_light else R.color.neutral_05_lightest_grey
            chatDesignSmallBubbleIMG.setImgTint(color)
            chatDesignBigBubbleIMG.setImgTint(color)
            messageInputTV.setTint(color)
            root.layoutDirection = if (user.name == item.sender) View.LAYOUT_DIRECTION_RTL else View.LAYOUT_DIRECTION_LTR
            messageInputTV.layoutDirection
            timeStampTV.layoutDirection
        }
    }
}