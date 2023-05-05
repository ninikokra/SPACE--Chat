package com.space.space__chat.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.space__chat.R
import com.space.space__chat.databinding.RvUserItemBinding
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.ChatCallBack
import com.space.space__chat.utils.extensions.convertTimeToString
import com.space.space__chat.utils.extensions.setImgTint
import com.space.space__chat.utils.extensions.setTextViewColor
import com.space.space__chat.utils.extensions.setTint

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
            messageInputTextView.text = item.message
            val color =
                if (adapterListener.invoke() == item.sender) {
                    if (item.isOnline) messageSentSuccessfully(
                        binding,
                        item
                    ) else messageNotSentNoInternet(binding, item)
                } else {
                    messageReceiverUi(binding, item)
                }
        }
        private fun messageSentSuccessfully(binding: RvUserItemBinding, item: MessageModel) {
            with(binding) {
                with(R.color.purple_light) {
                    timeStampTV.text = item.timeStamp!!.convertTimeToString()
                    timeStampTV.setTextViewColor(R.color.neutral_02_dark_grey)
                    chatDesignBigBubbleIMG.setImgTint(this)
                    chatDesignSmallBubbleIMG.setImgTint(this)
                    messageInputTextView.setTint(this)
                }
                root.layoutDirection = View.LAYOUT_DIRECTION_RTL
            }

        }

        private fun messageNotSentNoInternet(binding: RvUserItemBinding, item: MessageModel) {
            with(binding) {
                with(R.color.purple_light) {
                    timeStampTV.text = timeStampTV.context.getString(R.string.error_message)
                    timeStampTV.setTextViewColor(R.color.error_label)
                    chatDesignBigBubbleIMG.setImgTint(this)
                    chatDesignSmallBubbleIMG.setImgTint(this)
                    messageInputTextView.setTint(this)
                    messageInputTextView.setTextViewColor(R.color.error_text)
                }
                root.layoutDirection = View.LAYOUT_DIRECTION_RTL
            }
        }

        private fun messageReceiverUi(binding: RvUserItemBinding, item: MessageModel) {
            with(binding) {
                with(R.color.neutral_05_lightest_grey) {
                    timeStampTV.text = item.timeStamp!!.convertTimeToString()
                    timeStampTV.setTextViewColor(R.color.neutral_02_dark_grey)
                    chatDesignBigBubbleIMG.setImgTint(this)
                    chatDesignSmallBubbleIMG.setImgTint(this)
                    messageInputTextView.setTint(this)
                }
                root.layoutDirection = View.LAYOUT_DIRECTION_LTR
            }
        }
    }
}