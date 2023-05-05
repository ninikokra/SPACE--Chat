package com.space.space__chat.data.mapper

import com.space.space__chat.data.entity.MessageEntity
import com.space.space__chat.domain.model.MessageModel

fun MessageModel.toEntity() = MessageEntity(
    id = id,
    sender = sender,
    message = message,
    timeStamp = timeStamp,
    isOnline = isOnline
)
fun MessageEntity.toModel() = MessageModel(
    id = id,
    sender = sender,
    message = message,
    timeStamp = timeStamp,
    isOnline = isOnline
)