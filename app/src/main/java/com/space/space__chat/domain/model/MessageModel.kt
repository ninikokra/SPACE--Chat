package com.space.space__chat.domain.model

data class MessageModel(
    val id: Int?,
    val sender: String?,
    val message: String?,
    val timeStamp: Long?
)