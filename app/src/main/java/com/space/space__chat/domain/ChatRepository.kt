package com.space.space__chat.domain

import com.space.space__chat.data.model.MessageModel
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getMessages(): Flow<List<MessageModel>>
    suspend fun insertMessages(message: MessageModel)
}