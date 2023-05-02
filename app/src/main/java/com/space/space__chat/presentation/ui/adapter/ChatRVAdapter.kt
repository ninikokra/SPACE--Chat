package com.space.space__chat.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.space__chat.R
import com.space.space__chat.databinding.RvUserItemBinding
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.presentation.base.AdapterListener
import com.space.space__chat.utils.ChatCallBack
import com.space.space__chat.utils.extensions.convertTimeToString
import com.space.space__chat.utils.extensions.setImgTint
import com.space.space__chat.utils.extensions.setTint

class ChatRVAdapter(private val listener: AdapterListener) :
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
        holder.bind(listener, getItem(position))

    }
    class ChatRvViewHolder(private val binding: RvUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: AdapterListener, item: MessageModel) = with(binding) {
            messageInputTV.text = item.message
            timeStampTV.text = item.timeStamp!!.convertTimeToString()
            val color =
                if (listener.getUserId() == item.sender) R.color.purple_light else R.color.neutral_05_lightest_grey
            chatDesignSmallBubbleIMG.setImgTint(color)
            chatDesignBigBubbleIMG.setImgTint(color)
            messageInputTV.setTint(color)
            root.layoutDirection =
                if (listener.getUserId() == item.sender) View.LAYOUT_DIRECTION_RTL else View.LAYOUT_DIRECTION_LTR
        }
    }
}