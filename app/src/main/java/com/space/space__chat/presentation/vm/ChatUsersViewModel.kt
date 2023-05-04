package com.space.space__chat.presentation.vm

import androidx.lifecycle.ViewModel
import com.space.space__chat.domain.ChatRepository
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.extensions.getTimeInMills
import com.space.space__chat.utils.extensions.viewModelScope
import kotlinx.coroutines.flow.Flow

class ChatUsersViewModel(private val chatRepository: ChatRepository) : ViewModel() {

    fun showMessages(): Flow<List<MessageModel>> = chatRepository.getMessages()

    private fun provideMessageModel(editTextInput: String, tag: String) = MessageModel(
        sender = tag,
        message = editTextInput,
        timeStamp = getTimeInMills()
    )
    fun sendMessage(messageInput: String, tag: String) {
        viewModelScope {
            chatRepository.insertMessages(provideMessageModel(messageInput, tag))
        }
    }
}