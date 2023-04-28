package com.example.space__chat.data.model

import com.example.space__chat.presentation.model.UserType

data class MessageModel(
    val id: Int?,
    val sender: UserType?,
    val message: String?,
    val timeStamp: Long?
)