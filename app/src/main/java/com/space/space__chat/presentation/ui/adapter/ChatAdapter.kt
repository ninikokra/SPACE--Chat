package com.space.space__chat.presentation.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.space__chat.databinding.RvUserItemBinding
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.ChatCallBack
import com.space.space__chat.utils.extensions.viewBinding

/**
 * [ChatAdapter] class is a custom implementation of a RecyclerView.
 * Adapter that is used to display chat messages in a RecyclerView
 */
class ChatAdapter(private val listener: AdapterListener) :
    ListAdapter<MessageModel, ChatAdapter.ChatRvViewHolder>(ChatCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRvViewHolder {
        return ChatRvViewHolder(parent.viewBinding(RvUserItemBinding::inflate)
            )

    }
    override fun onBindViewHolder(holder: ChatRvViewHolder, position: Int) {
        holder.bind(listener, getItem(position))
    }

    class ChatRvViewHolder(private val binding: RvUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: AdapterListener, item: MessageModel) = with(binding) {
            messageCustomView.apply {
                if (listener.getUserId() == item.sender) {
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