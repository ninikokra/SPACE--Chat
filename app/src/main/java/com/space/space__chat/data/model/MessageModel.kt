package com.space.space__chat.data.model

import com.space.space__chat.presentation.model.UserType

data class MessageModel(
    val id: Int?,
    val sender: UserType?,
    val message: String?,
    val timeStamp: Long?
)