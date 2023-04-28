package com.example.space__chat.presentation.vm

import androidx.lifecycle.ViewModel
import com.example.space__chat.data.model.MessageModel
import com.example.space__chat.domain.ChatRepository
import com.example.space__chat.utils.extensions.viewModelScope
import kotlinx.coroutines.flow.Flow

class ChatUsersViewModel(private val chatRepository: ChatRepository) : ViewModel() {

    fun showMessages(): Flow<List<MessageModel>> = chatRepository.getMessages()

    fun sendMessage(messageModel: MessageModel) {
        viewModelScope {
            chatRepository.insertMessages(messageModel)
        }
    }
}