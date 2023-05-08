package com.space.space__chat.presentation.ui.adapter.chatUI

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.ColorRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.space.space__chat.R
import com.space.space__chat.databinding.MessageCustomviewBinding
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.extensions.convertTimeToString
import com.space.space__chat.utils.extensions.setImgTint
import com.space.space__chat.utils.extensions.setTextViewColor
import com.space.space__chat.utils.extensions.setTint


class MessageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var binding: MessageCustomviewBinding =
        MessageCustomviewBinding.inflate(LayoutInflater.from(context), this, true)

    fun setErrorUI(item: MessageModel) {
        with(binding) {
            timeStampTV.text = timeStampTV.context.getString(R.string.error_message)
            timeStampTV.setTextViewColor(R.color.error_label)
            messageInputTextView.text = item.message
            messageInputTextView.setTextViewColor(R.color.error_text)
            setChatDesignColors(R.color.purple_light)
            root.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
    }

    fun setReceivedUI(item: MessageModel) {
        with(binding) {
            timeStampTV.text = item.timeStamp!!.convertTimeToString()
            timeStampTV.setTextViewColor(R.color.neutral_02_dark_grey)
            messageInputTextView.text = item.message
            setChatDesignColors(R.color.neutral_05_lightest_grey)
            root.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }
    }

    fun setSentUI(item: MessageModel) {
        with(binding) {
            timeStampTV.text = item.timeStamp!!.convertTimeToString()
            timeStampTV.setTextViewColor(R.color.neutral_02_dark_grey)
            messageInputTextView.text = item.message
            setChatDesignColors(R.color.purple_light)
            root.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
    }

    private fun setChatDesignColors(@ColorRes colorRes: Int) {
        with(colorRes) {
            binding.chatDesignBigBubbleIMG.setImgTint(this)
            binding.chatDesignSmallBubbleIMG.setImgTint(this)
            binding.messageInputTextView.setTint(this)
        }
    }
}