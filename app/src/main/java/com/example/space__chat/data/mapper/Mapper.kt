package com.example.space__chat.data.mapper

import com.example.space__chat.data.model.ChatEntity
import com.example.space__chat.data.model.MessageModel

fun MessageModel.toEntity() = ChatEntity(
    id = id,
    sender = sender,
    message = message,
    timeStamp = timeStamp,
)
fun ChatEntity.toModel() = MessageModel(
    id = id,
    sender = sender,
    message = message,
    timeStamp = timeStamp,
)