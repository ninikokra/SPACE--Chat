package com.example.space__chat.Presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.space__chat.Presentation.model.UserTypeEnum
import com.example.space__chat.utils.setTint
import com.example.space__chat.R
import com.example.space__chat.data.MessageModel
import com.example.space__chat.databinding.RvUserItemBinding
import com.example.space__chat.utils.setImgTint

class ChatRVAdapter(private val user: UserTypeEnum) :
    ListAdapter<MessageModel, ChatRVAdapter.ChatRvViewHolder>(ChatCallBack()) {
    class ChatCallBack : DiffUtil.ItemCallback<MessageModel>() {
        override fun areItemsTheSame(oldItem: MessageModel, newItem: MessageModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MessageModel, newItem: MessageModel) =
            oldItem == newItem
    }

    class ChatRvViewHolder(private val binding: RvUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserTypeEnum, item: MessageModel) = with(binding) {
            messageInputTV.text = item.message
            timeStampTV.text = item.timeStamp
            val color =
                if (user.name == item.sender) R.color.purple_light else R.color.neutral_05_lightest_grey
            chatDesignSmallBubbleIMG.setImgTint(color)
            chatDesignBigBubbleIMG.setImgTint(color)
            messageInputTV.setTint(color)
            root.scaleX = if (user.name == item.sender) NEGATIVE else POSITIVE
            messageInputTV.scaleX = root.scaleX
            timeStampTV.scaleX = root.scaleX
        }
    }

    companion object {
        private const val POSITIVE = 1f
        private const val NEGATIVE = -1f
    }

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
}