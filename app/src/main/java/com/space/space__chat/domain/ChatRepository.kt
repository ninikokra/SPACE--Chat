package com.space.space__chat.domain

import com.space.space__chat.domain.model.MessageModel
import kotlinx.coroutines.flow.Flow

/**
 * [ChatRepository] is an interface, represents a repository for handling the data of the chat application.
 * It defines methods for getting and inserting messages.
 */

interface ChatRepository {
    fun getMessages(): Flow<List<MessageModel>>
    suspend fun insertMessages(message: MessageModel)
}