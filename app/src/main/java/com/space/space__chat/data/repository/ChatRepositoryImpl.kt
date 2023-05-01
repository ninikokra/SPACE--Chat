package com.space.space__chat.data.repository

import com.space.space__chat.data.ChatDao
import com.space.space__chat.data.mapper.toEntity
import com.space.space__chat.data.mapper.toModel
import com.space.space__chat.data.model.MessageModel
import com.space.space__chat.domain.ChatRepository
import kotlinx.coroutines.flow.map

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