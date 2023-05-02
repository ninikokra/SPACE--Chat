package com.space.space__chat.data.mapper

import com.space.space__chat.data.entity.ChatEntity
import com.space.space__chat.domain.model.MessageModel

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