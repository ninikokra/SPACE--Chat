package com.example.space__chat.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.space__chat.presentation.model.UserType
import com.example.space__chat.R
import com.example.space__chat.data.model.MessageModel
import com.example.space__chat.databinding.RvUserItemBinding
import com.example.space__chat.utils.ChatCallBack
import com.example.space__chat.utils.extensions.convertTimeToString
import com.example.space__chat.utils.extensions.setImgTint
import com.example.space__chat.utils.extensions.setTint

class ChatRVAdapter(private val user: UserType) :
    ListAdapter<MessageModel, ChatRVAdapter.ChatRvViewHolder>(ChatCallBack()) {

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

        fun bind(user: UserType, item: MessageModel) = with(binding) {
            messageInputTV.text = item.message
            timeStampTV.text = item.timeStamp!!.convertTimeToString()
            val color =
                if (user.name == item.sender!!.name) R.color.purple_light else R.color.neutral_05_lightest_grey
            chatDesignSmallBubbleIMG.setImgTint(color)
            chatDesignBigBubbleIMG.setImgTint(color)
            messageInputTV.setTint(color)
            root.layoutDirection =
                if (user.name == item.sender.name) View.LAYOUT_DIRECTION_RTL else View.LAYOUT_DIRECTION_LTR
            messageInputTV.layoutDirection
            timeStampTV.layoutDirection
        }
    }
}