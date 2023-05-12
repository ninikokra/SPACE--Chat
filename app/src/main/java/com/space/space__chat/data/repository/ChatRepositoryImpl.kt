package com.space.space__chat.data.repository

import com.space.space__chat.data.dao.ChatDao
import com.space.space__chat.data.mapper.toEntity
import com.space.space__chat.data.mapper.toModel
import com.space.space__chat.domain.ChatRepository
import com.space.space__chat.domain.model.MessageModel
import kotlinx.coroutines.flow.map

/**
 * ChatRepositoryImpl is a class that implements the ChatRepository interface,
 * which defines the methods for interacting with the chat data source.
 */

class ChatRepositoryImpl(private val dao: ChatDao) : ChatRepository {

    override fun getMessages() = dao.getAllMessages().map { chat ->
        chat.map {
            it.toModel()
        }
    }

    override suspend fun insertMessages(message: MessageModel) {
        dao.insertMessages(message.toEntity())

    }
}