package com.space.space__chat.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.space__chat.databinding.RvUserItemBinding
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.ChatCallBack

class ChatAdapter(private val adapterListener: () -> String) :
    ListAdapter<MessageModel, ChatAdapter.ChatRvViewHolder>(ChatCallBack()) {

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
        holder.bind(adapterListener, getItem(position))
    }

    class ChatRvViewHolder(private val binding: RvUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(adapterListener: () -> String, item: MessageModel) = with(binding) {
            messageCustomView.apply {
                if (adapterListener.invoke() == item.sender) {
                    if (item.isOnline) {
                        setSentUI(item)
                    } else setErrorUI(item)
                } else {
                    setReceivedUI(item)
                }
            }
        }
    }
}